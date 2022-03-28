package tests;

import browser.Browser;
import models.NewTest;
import models.Token;
import org.apache.http.HttpStatus;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.TestDataVariables;
import services.Url;
import steps.AddProjectPageSteps;
import steps.NewProjectPageSteps;
import steps.NexagePageSteps;
import steps.ProjectsPageSteps;
import utils.JsonConverter;
import utils.PropertiesManager;
import utils.SmartLogger;
import utils.StringUtils;
import utils.api.Response;
import utils.api.WebApiUtils;

import java.util.List;

public class UnionReportingWebTest extends BaseTest {

    private final int LENGTH_NEW_PROJECT_NAME = Integer.parseInt(PropertiesManager.
            getTestDataValue(TestDataVariables.LENGTH_NEW_PROJECT_NAME.getVariable()));
    private final int LENGTH_TEST_LOG = Integer.parseInt(PropertiesManager.
            getTestDataValue(TestDataVariables.LENGTH_TEST_LOG.getVariable()));

    private final String VARIANT = PropertiesManager.getTestDataValue(TestDataVariables.VARIANT.getVariable());
    private final String WEB_URL = PropertiesManager.getTestDataValue(Url.WEB_URL.getUrl());
    private final String USER_NAME = PropertiesManager.getTestDataValue(TestDataVariables.USER_NAME.getVariable());
    private final String USER_PASSWORD = PropertiesManager.getTestDataValue(TestDataVariables.USER_PASSWORD.getVariable());
    private final String PROJECT_ID = PropertiesManager.getTestDataValue(TestDataVariables.PROJECT_ID.getVariable());
    private final String CURRENT_TESTS_PAGE = PropertiesManager.getTestDataValue(TestDataVariables.CURRENT_TESTS_PAGE.getVariable());

    private String newProjectName;
    private String originalWindow;
    private String testLog;

    private Cookie cookie;
    private NewTest newTest;
    private Response response;
    private Token token;

    private List<models.Test> tests;

    @Test
    public void addTest() {
        SmartLogger.logStep(1, "Get token.");
        response = WebApiUtils.getToken(VARIANT);
        token = new Token(JsonConverter.getString(response.getBody()));
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "Wrong status code returned.");
        Assert.assertNotNull(token.getToken(), "Token is null.");

        SmartLogger.logStep(2, "Authorization.");
        Browser.goToAuthorization(USER_NAME, USER_PASSWORD, WEB_URL);
        ProjectsPageSteps.assertIsOpenProjectsPage();
        cookie = new Cookie("token", token.getToken());
        Browser.addCookie(cookie);
        Browser.refresh();
        ProjectsPageSteps.assertIsCorrectVersion(VARIANT);

        SmartLogger.logStep(3, "Get Nexage project tests.");
        ProjectsPageSteps.clickNexageLnk();
        NexagePageSteps.assertIsOpenNexagePage();
        response = WebApiUtils.getTests(PROJECT_ID);
        JsonConverter.assertIsJsonArrayFormatResponse(response.getBody());
        tests = JsonConverter.getList(response.getBody(), models.Test.class);
        NexagePageSteps.assertIsCorrectCurrentTestsPage(CURRENT_TESTS_PAGE);
        NexagePageSteps.assertIsSortedTestsByStartTime();
        NexagePageSteps.assertIsContainTests(tests);

        SmartLogger.logStep(4, "Add new project.");
        newProjectName =  StringUtils.generateRandomString(LENGTH_NEW_PROJECT_NAME);
        Browser.goBack();
        ProjectsPageSteps.assertIsOpenProjectsPage();
        originalWindow = Browser.getWindowHandle();
        ProjectsPageSteps.clickAddBtn();
        Browser.switchToOtherWindow(originalWindow);
        AddProjectPageSteps.assertIsOpenAddProjectPage();
        AddProjectPageSteps.addNewProject(newProjectName);
        AddProjectPageSteps.assertIsDisplayedSuccessfulSaveMessage();
        Browser.close();
        Browser.switchTo(originalWindow);
        AddProjectPageSteps.assertIsCloseAddProjectPage();
        Browser.refresh();
        ProjectsPageSteps.assertIsContainsProjectInPageList(newProjectName);

        SmartLogger.logStep(5, "Add new test.");
        testLog = StringUtils.generateRandomString(LENGTH_TEST_LOG);
        ProjectsPageSteps.clickNewProjectLnk(newProjectName);
        String[] screenshotInfo = Browser.takeScreenshot();
        Browser.close();
    }
}
