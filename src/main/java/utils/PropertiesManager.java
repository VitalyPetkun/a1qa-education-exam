package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private static final String CONFIG_PATH = "src/main/resources/config.properties";
    private static final String TEST_DATA_PATH = "src/test/resources/testData.properties";

    private PropertiesManager() {
    }

    private static Properties getProperties(String path) {
        try (FileInputStream fileTestDataInputStream = new FileInputStream(path)) {
            Properties testDataProperties = new Properties();
            testDataProperties.load(fileTestDataInputStream);

            return testDataProperties;
        } catch (IOException e) {
            SmartLogger.logError("Don't reading config file");
        }

        return null;
    }

    public static String getConfigValue(String key) {
        return getProperties(CONFIG_PATH).getProperty(key);
    }

    public static String getTestDataValue(String key) {
        return getProperties(TEST_DATA_PATH).getProperty(key);
    }
}