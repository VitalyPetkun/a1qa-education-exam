package services;

public enum ApiParameters {

    VARIANT("variant="),
    PROJECT_ID("projectId="),
    PROJECT_NAME("projectName="),
    TEST_NAME("testName="),
    METHOD_NAME("methodName="),
    ENV("env="),
    BROWSER("browser="),
    TEST_ID("testId="),
    CONTENT("content="),
    CONTENT_TYPE("contentType");

    private String parameter;

    ApiParameters(String parameter) {
        this.parameter = parameter;
    }

    public String getVariant(String variant) {
        return parameter.concat(variant);
    }

    public String getProjectName(String projectName) {
        return parameter.concat(projectName).concat("&");
    }

    public String getTestName(String testName) {
        return parameter.concat(testName).concat("&");
    }

    public String getMethodName(String methodName) {
        return parameter.concat(methodName).concat("&");
    }

    public String getEnv(String env) {
        return parameter.concat(env).concat("&");
    }

    public String getTestId(String testId) {
        return parameter.concat(testId).concat("&");
    }

    public String getContentType(String contentType) {
        return parameter.concat(contentType).concat("&");
    }
}
