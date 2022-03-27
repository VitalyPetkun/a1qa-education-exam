package services;

public enum ApiParameters {

    VARIANT("variant="),
    PROJECT_ID("projectId=");

    private String parameter;

    ApiParameters(String parameter) {
        this.parameter = parameter;
    }

    public String getVariant(String variant) {
        return parameter.concat(variant);
    }
}
