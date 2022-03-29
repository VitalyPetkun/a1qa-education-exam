package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private PropertiesManager() {
    }

    private static Properties getProperties(String pathFile) {
        try (FileInputStream fileTestDataInputStream = new FileInputStream(pathFile)) {
            Properties properties = new Properties();
            properties.load(fileTestDataInputStream);

            return properties;
        } catch (IOException e) {
            SmartLogger.logError("Don't reading file.");
        }

        return null;
    }

    public static String getValue(String path, String fileName, String key) {
        return getProperties(path.concat(fileName)).getProperty(key);
    }
}