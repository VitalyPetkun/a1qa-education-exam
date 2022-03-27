package services;

public enum TestDataVariables {

    VARIANT("variant"),
    USER_NAME("userName"),
    USER_PASSWORD("userPassword"),
    PROJECT_ID("projectId"),
    CURRENT_TESTS_PAGE("currentTestsPage"),
    EXCEPTIONAL_VALUE("exceptionalValue"),
    DATA_FORMAT_TESTS_TIME("dataFormatTestsTime");

    private String variable;

    TestDataVariables(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }
}
