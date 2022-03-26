package utils.api;

import utils.SmartLogger;
import static io.restassured.RestAssured.*;

public class ApiUtils {

    private ApiUtils() {
    }

    public static void setupBaseUri(String currentBaseUri) {
        SmartLogger.logInfo("Setup baseUri");
        baseURI = currentBaseUri;
    }

    protected static Response doGet(String endPoint) {
        SmartLogger.logInfo(String.format("Get request %s%s", baseURI, endPoint));
        return new Response(given().get(endPoint).then());
    }

    protected static Response doPost(String endPoint) {
        SmartLogger.logInfo(String.format("Post request %s%s", baseURI, endPoint));
        return new Response(given().post(endPoint).then());
    }
}
