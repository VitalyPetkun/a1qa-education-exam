package services;

public enum EndPointsApi {

    TEST_PUT("/test/put?"),
    TEST_GET_CSV("/test/get/csv?"),
    TEST_UPDATE("/test/update?"),
    TEST_PUT_LOG("/test/put/log?"),
    TOKEN_GET("/token/get?"),
    TEST_PUT_ATTACHMENT("/test/put/attachment?"),
    TEST_UPDATE_AUTHOR("/test/update/author?"),
    TEST_GET_JSON("/test/get/json?"),
    TEST_UPDATE_DEV_INFO("/test/update/devInfo?"),
    TEST_GET_XML("/test/get/xml?");

    private String point;

    EndPointsApi(String point) {
        this.point = point;
    }

    public String getPoint() {
        return point;
    }
}
