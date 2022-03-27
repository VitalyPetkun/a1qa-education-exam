package utils.api;

import services.ApiParameters;

import static services.EndPointsApi.TEST_GET_JSON;
import static services.EndPointsApi.TOKEN_GET;

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
}
