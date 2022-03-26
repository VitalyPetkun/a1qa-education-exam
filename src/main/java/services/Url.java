package services;

public enum Url {

    HTTP("http"),
    API_URL("apiUrl"),
    WEB_URL("webUrl");

    private String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
