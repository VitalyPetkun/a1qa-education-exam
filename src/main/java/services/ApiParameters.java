package services;

public enum ApiParameters {

    BROWSER("browser="),
    CONTENT("content="),
    CONTENT_TYPE("contentType="),
    ENV("env="),
    METHOD_NAME("methodName="),
    PROJECT_ID("projectId="),
    PROJECT_NAME("projectName="),
    SID("SID="),
    TEST_ID("testId="),
    TEST_NAME("testName="),
    VARIANT("variant=");

    private String parameterName;

    ApiParameters(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getLastParameter(String parameterValue) {
        return parameterName.concat(parameterValue);
    }

    public String getMiddleParameter(String parameterValue) {
        return parameterName.concat(parameterValue).concat("&");
    }
}
