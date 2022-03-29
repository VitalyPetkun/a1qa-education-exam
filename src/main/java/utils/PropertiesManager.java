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
            Properties properties = new Properties();
            properties.load(fileTestDataInputStream);

            return properties;
        } catch (IOException e) {
            SmartLogger.logError("Don't reading config file");
        }

        return null;
    }

    public static String getValue(String path, String fileName, String key) {
        return getProperties(path.concat(fileName)).getProperty(key);
    }

    public static String getConfigValue(String key) {
        return getProperties(CONFIG_PATH).getProperty(key);
    }

    public static String getTestDataValue(String key) {
        return getProperties(TEST_DATA_PATH).getProperty(key);
    }
}