package services;

public enum ProjectFiles {

    CONFIG("configFileName"),
    TEST_DATA("testDataFileName");

    private String file;

    ProjectFiles(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }
}
