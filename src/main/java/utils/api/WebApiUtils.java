package utils.api;

import services.ApiParameters;

import static services.EndPointsApi.*;

public class WebApiUtils {

    private WebApiUtils() {
    }

    public static Response addTest(String SID, String projectName, String testName, String methodName, String env, String browser) {
        return ApiUtils.doPost(TEST_PUT.getPoint().
                concat(ApiParameters.SID.getMiddleParameter(SID)).
                concat(ApiParameters.PROJECT_NAME.getMiddleParameter(projectName)).
                concat(ApiParameters.TEST_NAME.getMiddleParameter(testName)).
                concat(ApiParameters.METHOD_NAME.getMiddleParameter(methodName)).
                concat(ApiParameters.ENV.getMiddleParameter(env)).
                concat(ApiParameters.BROWSER.getLastParameter(browser))
        );
    }

    public static Response getTests(String projectId) {
        return ApiUtils.doPost(TEST_GET_JSON.getPoint().
                concat(ApiParameters.PROJECT_ID.getLastParameter(projectId))
        );
    }

    public static Response getToken(String variant) {
        return ApiUtils.doPost(TOKEN_GET.getPoint().
                concat(ApiParameters.VARIANT.getLastParameter(variant))
        );
    }

    public static Response putAttachment(String testId, String content, String contentType) {
        return ApiUtils.doPost(TEST_PUT_LOG.getPoint().
                concat(ApiParameters.TEST_ID.getMiddleParameter(testId)).
                concat(ApiParameters.CONTENT_TYPE.getMiddleParameter(contentType)).
                concat(ApiParameters.CONTENT.getLastParameter(content))
        );
    }

    public static Response putLog(String testId, String content) {
        return ApiUtils.doPost(TEST_PUT_LOG.getPoint().
                concat(ApiParameters.TEST_ID.getMiddleParameter(testId)).
                concat(ApiParameters.CONTENT.getLastParameter(content))
        );
    }
}
