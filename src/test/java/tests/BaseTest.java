package tests;

import org.testng.annotations.*;
import services.Uri;
import utils.*;
import utils.api.ApiUtils;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        SmartLogger.logInfo("Set base uri");
        ApiUtils.setupBaseUri(PropertiesManager.getTestDataValue(Uri.API_URI.getUri()));
        SmartLogger.logInfo("Set window size maximize");
      //  AqualityServices.getBrowser().getDriver().manage().window().maximize();
        SmartLogger.logInfo("Timeout load browser");
    //    AqualityServices.getBrowser().getDriver().manage().timeouts();
    }

    @AfterMethod
    protected void quitDriver() {
        SmartLogger.logInfo("Quit browser");
    //    AqualityServices.getBrowser().getDriver().quit();
    }
}