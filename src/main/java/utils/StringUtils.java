package utils;

import static services.Paths.*;
import static services.ProjectFiles.*;
import static services.TestDataVariables.*;

public class StringUtils {

    private static final int BOTTOM_VALUE_CAPITAL_LETTERS = Integer.parseInt(PropertiesManager.
            getValue(TEST_RESOURCES_PATH.getPath(), TEST_DATA.getFile(), BOTTOM_VALUE_ASCII_CAPITAL_LETTERS.getVariable()));
    private static final int BOTTOM_VALUE_LOWER_CASE = Integer.parseInt(PropertiesManager.
            getValue(TEST_RESOURCES_PATH.getPath(), TEST_DATA.getFile(), BOTTOM_VALUE_ASCII_LOWER_CASE.getVariable()));
    private static final int TOP_VALUE_CAPITAL_LETTERS = Integer.parseInt(PropertiesManager.
            getValue(TEST_RESOURCES_PATH.getPath(), TEST_DATA.getFile(), TOP_VALUE_ASCII_CAPITAL_LETTERS.getVariable()));
    private static final int TOP_VALUE_LOWER_CASE = Integer.parseInt(PropertiesManager.
            getValue(TEST_RESOURCES_PATH.getPath(), TEST_DATA.getFile(), TOP_VALUE_ASCII_LOWER_CASE.getVariable()));

    private StringUtils() {
    }

    public static String deleteAllExceptNumbers(String string) {
        return string.replaceAll("[^0-9]", "");
    }

    public static String generateRandomString(int length) {
        SmartLogger.logInfo("Generate a random string.");
        String random = String.valueOf(Character.toChars((int) (Math.random()
                * (TOP_VALUE_CAPITAL_LETTERS - BOTTOM_VALUE_CAPITAL_LETTERS)) + BOTTOM_VALUE_CAPITAL_LETTERS));

        for (int i = 1; i < length; i++) {
            random += (String.valueOf(Character.toChars((int) (Math.random()
                    * (TOP_VALUE_LOWER_CASE - BOTTOM_VALUE_LOWER_CASE)) + BOTTOM_VALUE_LOWER_CASE)));
        }

        return random;
    }
}
