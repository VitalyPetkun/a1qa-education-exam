package utils.api;

import io.restassured.response.ValidatableResponse;

public class Response {

    private String body;
    private int status;

    protected Response(ValidatableResponse validatableResponse) {
        body = validatableResponse.extract().body().asString();
        status = validatableResponse.extract().statusCode();
    }

    public String getBody() {
        return body;
    }

    public int getStatus() {
        return status;
    }
}
