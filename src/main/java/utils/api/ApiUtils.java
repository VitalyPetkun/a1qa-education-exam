package utils.api;

import utils.SmartLogger;

import static io.restassured.RestAssured.*;

public class ApiUtils {

    private ApiUtils() {
    }

    protected static Response doPost(String endPoint) {
        SmartLogger.logInfo(String.format("Post request %s%s", baseURI, endPoint));
        return new Response(given().post(endPoint).then());
    }

    public static void setupBaseUri(String currentBaseUri) {
        SmartLogger.logInfo("Setup base uri.");
        baseURI = currentBaseUri;
    }
}
