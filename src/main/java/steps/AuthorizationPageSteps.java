package steps;

import services.Url;
import utils.PropertiesManager;

public class AuthorizationPageSteps {

    public static String getUrl(String userName, String userPassword, String webUrl) {
        return PropertiesManager.getTestDataValue(Url.HTTP.getUrl()).concat(userName).concat(":").concat(userPassword).
                concat("@").concat(webUrl);
    }
}
