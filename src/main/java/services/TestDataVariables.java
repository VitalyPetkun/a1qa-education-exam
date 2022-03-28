package services;

public enum TestDataVariables {

    VARIANT("variant"),
    USER_NAME("userName"),
    USER_PASSWORD("userPassword"),
    PROJECT_ID("projectId"),
    CURRENT_TESTS_PAGE("currentTestsPage"),
    EXCEPTIONAL_VALUE("exceptionalValue"),
    DATA_FORMAT_TESTS_TIME("dataFormatTestsTime"),
    BOTTOM_VALUE_ASCII_LOWER_CASE("bottomValueAsciiLowerCase"),
    TOP_VALUE_ASCII_LOWER_CASE("topValueAsciiLowerCase"),
    BOTTOM_VALUE_ASCII_CAPITAL_LETTERS("bottomValueAsciiCapitalLetters"),
    TOP_VALUE_ASCII_CAPITAL_LETTERS("topValueAsciiCapitalLetters"),
    LENGTH_NEW_PROJECT_NAME("lengthNewProjectName"),
    LENGTH_TEST_LOG("lengthTestLog"),
    LENGTH_SID("lengthSID");

    private String variable;

    TestDataVariables(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }
}
