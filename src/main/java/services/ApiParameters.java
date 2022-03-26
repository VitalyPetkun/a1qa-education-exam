package services;

public enum ApiParameters {

    VARIANT("variant=");

    private String parameter;

    ApiParameters(String parameter) {
        this.parameter = parameter;
    }

    public String getVariant(String variant) {
        return parameter.concat(variant);
    }
}
