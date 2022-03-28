package utils;

import static services.TestDataVariables.*;

public class StringUtils {

    private static final int BOTTOM_VALUE_LOWER_CASE = Integer.parseInt(PropertiesManager.
            getTestDataValue(BOTTOM_VALUE_ASCII_LOWER_CASE.getVariable()));
    private static final int TOP_VALUE_LOWER_CASE = Integer.parseInt(PropertiesManager.
            getTestDataValue(TOP_VALUE_ASCII_LOWER_CASE.getVariable()));
    private static final int BOTTOM_VALUE_CAPITAL_LETTERS = Integer.parseInt(PropertiesManager.
            getTestDataValue(BOTTOM_VALUE_ASCII_CAPITAL_LETTERS.getVariable()));
    private static final int TOP_VALUE_CAPITAL_LETTERS = Integer.parseInt(PropertiesManager.
            getTestDataValue(TOP_VALUE_ASCII_CAPITAL_LETTERS.getVariable()));

    private StringUtils() {}

    public static String generateRandomString(int length) {
        SmartLogger.logInfo("Generate a random string.");
        String random = "";

        random += String.valueOf(Character.toChars((int) (Math.random()
                * (TOP_VALUE_CAPITAL_LETTERS - BOTTOM_VALUE_CAPITAL_LETTERS)) + BOTTOM_VALUE_CAPITAL_LETTERS));

        for (int i = 1; i <= length; i++) {
            random += (String.valueOf(Character.toChars((int) (Math.random()
                    * (TOP_VALUE_LOWER_CASE - BOTTOM_VALUE_LOWER_CASE)) + BOTTOM_VALUE_LOWER_CASE)));
        }

        return random;
    }
}
