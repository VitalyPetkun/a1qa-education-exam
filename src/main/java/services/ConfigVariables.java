package services;

public enum ConfigVariables {

    ENV("env");

    private String variable;

    ConfigVariables(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }
}
