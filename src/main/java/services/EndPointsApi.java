package services;

public enum EndPointsApi {

    TEST_GET_JSON("/test/get/json?"),
    TEST_PUT("/test/put?"),
    TEST_PUT_LOG("/test/put/log?"),
    TOKEN_GET("/token/get?");

    private String point;

    EndPointsApi(String point) {
        this.point = point;
    }

    public String getPoint() {
        return point;
    }
}
