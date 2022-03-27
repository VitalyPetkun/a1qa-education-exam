package steps;

import aquality.selenium.browser.AqualityServices;
import services.Url;
import utils.PropertiesManager;
import utils.SmartLogger;

public class AuthorizationPageSteps {

    private static String url;

    public static void authorization(String userName, String userPassword, String webUrl) {
        SmartLogger.logInfo("Go projects page");
        url = PropertiesManager.getTestDataValue(Url.HTTP.getUrl()).concat(userName).concat(":").concat(userPassword).
                concat("@").concat(webUrl);
        AqualityServices.getBrowser().goTo(url);
    }
}
