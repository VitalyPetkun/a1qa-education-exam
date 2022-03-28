package services;

public enum ConfigVariables {

    DATA_FORMAT_TESTS_TIME("dataFormatTestsTime"),
    ENV("env"),
    TIME_ZONE("timeZone"),
    USER_NAME("userName"),
    USER_PASSWORD("userPassword");

    private String variable;

    ConfigVariables(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }
}
