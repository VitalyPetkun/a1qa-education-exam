package utils.api;

import services.ApiParameters;

import java.util.Locale;

import static services.EndPointsApi.*;

public class WebApiUtils {

    private WebApiUtils() {}

    public static Response getToken(String variant) {
        return ApiUtils.doPost(TOKEN_GET.getPoint().
                concat(ApiParameters.VARIANT.getVariant(variant))
        );
    }

    public static Response getTests(String projectId) {
        return ApiUtils.doPost(TEST_GET_JSON.getPoint().
                concat(ApiParameters.PROJECT_ID.getVariant(projectId))
        );
    }

    public static Response addTest(String projectName, String testName, String methodName, String env, String browser) {
        return ApiUtils.doPost(TEST_PUT.getPoint().
                concat(ApiParameters.PROJECT_NAME.getProjectName(projectName)).
                concat(ApiParameters.TEST_NAME.getTestName(testName)).
                concat(ApiParameters.METHOD_NAME.getMethodName(methodName)).
                concat(ApiParameters.ENV.getEnv(env)).
                concat(ApiParameters.BROWSER.getVariant(browser))
        );
    }

    public static Response putLog(String testId, String content) {
        return ApiUtils.doPost(TEST_PUT_LOG.getPoint().
                concat(ApiParameters.TEST_ID.getTestId(testId)).
                concat(ApiParameters.CONTENT.getVariant(content))
        );
    }

    public static Response putAttachment(String testId, String content, String contentType) {
        return ApiUtils.doPost(TEST_PUT_LOG.getPoint().
                concat(ApiParameters.TEST_ID.getTestId(testId)).
                concat(ApiParameters.CONTENT_TYPE.getContentType(contentType)).
                concat(ApiParameters.CONTENT.getVariant(content))
        );
    }
}
