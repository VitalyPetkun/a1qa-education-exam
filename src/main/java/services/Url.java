package services;

public enum Url {

    API_URL("apiUrl"),
    HTTP("http"),
    WEB_URL("webUrl");

    private String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
