package tests;

import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.Url;
import utils.*;
import utils.api.ApiUtils;

public class BaseTest {

    private final String API_URI = PropertiesManager.getTestDataValue(Url.API_URL.getUrl());

    @BeforeMethod
    protected void setup() {
        SmartLogger.logInfo("Set base uri");
        ApiUtils.setupBaseUri(API_URI);
        SmartLogger.logInfo("Set window size maximize");
        AqualityServices.getBrowser().getDriver().manage().window().maximize();
        SmartLogger.logInfo("Timeout load browser");
        AqualityServices.getBrowser().getDriver().manage().timeouts();
    }

    @AfterMethod
    protected void quitDriver() {
        SmartLogger.logInfo("Quit browser");
        AqualityServices.getBrowser().getDriver().quit();
    }
}