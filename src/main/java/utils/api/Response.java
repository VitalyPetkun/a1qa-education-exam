package utils.api;

import io.restassured.response.ValidatableResponse;

public class Response {

    private int status;
    private String body;

    protected Response(ValidatableResponse validatableResponse) {
        status = validatableResponse.extract().statusCode();
        body = validatableResponse.extract().body().asString();
    }

    public int getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }
}
