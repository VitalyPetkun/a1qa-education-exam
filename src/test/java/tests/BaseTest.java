package tests;

import browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.ConfigVariables;
import services.TestDataVariables;
import services.Url;
import utils.*;
import utils.api.ApiUtils;

import java.util.TimeZone;

public class BaseTest {

    private final int LENGTH_SID = Integer.parseInt(PropertiesManager.
            getTestDataValue(TestDataVariables.LENGTH_SID.getVariable()));

    private final String API_URI = PropertiesManager.getConfigValue(Url.API_URL.getUrl());
    private final String TIME_ZONE = PropertiesManager.getConfigValue(ConfigVariables.TIME_ZONE.getVariable());
    protected final String SID = StringUtils.generateRandomString(LENGTH_SID);

    @BeforeMethod
    protected void setup() {
        TimeZone.setDefault(TimeZone.getTimeZone(TIME_ZONE));
        ApiUtils.setupBaseUri(API_URI);
        Browser.setMaximizeWindow();
        Browser.timeouts();
    }

    @AfterMethod
    protected void quitDriver() {
        Browser.quit();
    }
}