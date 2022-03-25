package services;

public enum TestDataVariables {

    VARIANT("variant");

    private String variable;

    TestDataVariables(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }
}
