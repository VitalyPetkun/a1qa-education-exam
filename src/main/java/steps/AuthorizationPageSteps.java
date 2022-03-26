package steps;

import services.Url;

public class AuthorizationPageSteps {

    public static String getUrl(String userName, String userPassword, String webUrl) {
        return Url.HTTP.getUrl().concat(userName).concat(":").concat(userPassword).concat("@").concat(webUrl);
    }
}
