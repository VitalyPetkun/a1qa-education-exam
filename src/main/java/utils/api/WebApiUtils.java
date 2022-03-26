package utils.api;

import services.ApiParameters;

import static services.EndPointsApi.TOKEN_GET;

public class WebApiUtils {

    private WebApiUtils() {}

    public static Response getToken(String variant) {
        return ApiUtils.doPost(TOKEN_GET.getPoint().
                concat(ApiParameters.VARIANT.getVariant(variant))
        );
    }
}
