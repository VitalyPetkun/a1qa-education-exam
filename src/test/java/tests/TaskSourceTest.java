package tests;

import aquality.selenium.browser.AqualityServices;
import models.Token;
import org.apache.http.HttpStatus;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.TestDataVariables;
import services.Url;
import steps.AuthorizationPageSteps;
import steps.NexagePageSteps;
import steps.ProjectsPageSteps;
import utils.JsonConverter;
import utils.PropertiesManager;
import utils.SmartLogger;
import utils.api.Response;
import utils.api.WebApiUtils;

import java.util.List;

public class TaskSourceTest extends BaseTest {

    private final String VARIANT = PropertiesManager.getTestDataValue(TestDataVariables.VARIANT.getVariable());
    private final String WEB_URL = PropertiesManager.getTestDataValue(Url.WEB_URL.getUrl());
    private final String USER_NAME = PropertiesManager.getTestDataValue(TestDataVariables.USER_NAME.getVariable());
    private final String USER_PASSWORD = PropertiesManager.getTestDataValue(TestDataVariables.USER_PASSWORD.getVariable());
    private final String PROJECT_ID = PropertiesManager.getTestDataValue(TestDataVariables.PROJECT_ID.getVariable());
    private final String CURRENT_TESTS_PAGE = PropertiesManager.getTestDataValue(TestDataVariables.CURRENT_TESTS_PAGE.getVariable());

    private Response response;
    private Token token;
    private Cookie cookie;
    private List<models.Test> tests;

    @Test
    public void addTest() {
        SmartLogger.logStep(1, "Get token");
        response = WebApiUtils.getToken(VARIANT);
        token = new Token(JsonConverter.getString(response.getBody()));
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "Wrong status code returned");
        Assert.assertNotNull(token.getToken(), "Token is null");

        SmartLogger.logStep(2, "Authorization");
        SmartLogger.logInfo("Go projects page");
        AqualityServices.getBrowser().goTo(AuthorizationPageSteps.getUrl(USER_NAME, USER_PASSWORD, WEB_URL));
        ProjectsPageSteps.assertIsOpenWelcomePage();
        cookie = new Cookie("token", token.getToken());
        AqualityServices.getBrowser().getDriver().manage().addCookie(cookie);
        SmartLogger.logInfo("Refresh current page");
        AqualityServices.getBrowser().getDriver().navigate().refresh();
        ProjectsPageSteps.assertIsCorrectVersion(VARIANT);

        SmartLogger.logStep(3, "Get Nexage project tests");
        ProjectsPageSteps.clickNexageLnk();
        NexagePageSteps.assertIsOpenNexagePage();
        response = WebApiUtils.getTests(PROJECT_ID);
        tests = JsonConverter.getList(response.getBody(), models.Test.class);
        NexagePageSteps.assertIsCorrectCurrentTestsPage(CURRENT_TESTS_PAGE);
        NexagePageSteps.assertIsSortedTestsByStartTime();
        NexagePageSteps.assertIsContainTests(tests);
    }
}
