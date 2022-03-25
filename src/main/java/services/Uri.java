package services;

public enum Uri {

    API_URI("apiUri");

    private String uri;

    Uri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
