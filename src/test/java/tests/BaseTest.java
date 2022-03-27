package tests;

import browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.Url;
import utils.*;
import utils.api.ApiUtils;

public class BaseTest {

    private final String API_URI = PropertiesManager.getTestDataValue(Url.API_URL.getUrl());

    @BeforeMethod
    protected void setup() {
        ApiUtils.setupBaseUri(API_URI);
        Browser.setMaximizeWindow();
        Browser.timeouts();
    }

    @AfterMethod
    protected void quitDriver() {
        Browser.quit();
    }
}