package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SmartLogger {

    private static Logger logger;

    private SmartLogger() {
        logger = LogManager.getLogger(SmartLogger.class);
    }

    private static Logger getLogger() {
        if (logger == null)
            new SmartLogger();
        return logger;
    }

    public static void logInfo(String message) {
        getLogger().info(message);
    }

    public static void logStep(int stepNumber, String message) {
        getLogger().info(String.format("STEP №%d: %s", stepNumber, message));
    }

    public static void logError(String message) {
        getLogger().error(message);
    }
}
