package services;

public enum TestDataVariables {

    VARIANT("variant"),
    USER_NAME("userName"),
    USER_PASSWORD("userPassword");

    private String variable;

    TestDataVariables(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }
}
