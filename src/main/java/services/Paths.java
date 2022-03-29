package services;

public enum Paths {

    MAIN_RESOURCES_PATH("mainResourcesPath"),
    TEST_RESOURCES_PATH("testResourcesPath");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
