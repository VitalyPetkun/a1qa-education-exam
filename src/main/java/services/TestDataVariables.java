package services;

public enum TestDataVariables {

    BOTTOM_VALUE_ASCII_LOWER_CASE("bottomValueAsciiLowerCase"),
    BOTTOM_VALUE_ASCII_CAPITAL_LETTERS("bottomValueAsciiCapitalLetters"),
    CURRENT_TESTS_PAGE("currentTestsPage"),
    EXCEPTIONAL_STATUS_VALUE("exceptionalStatusValue"),
    LENGTH_NEW_PROJECT_NAME("lengthNewProjectName"),
    LENGTH_SID("lengthSID"),
    LENGTH_TEST_LOG("lengthTestLog"),
    PROJECT_ID("projectId"),
    TOP_VALUE_ASCII_LOWER_CASE("topValueAsciiLowerCase"),
    TOP_VALUE_ASCII_CAPITAL_LETTERS("topValueAsciiCapitalLetters"),
    VARIANT("variant");

    private String variable;

    TestDataVariables(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }
}
