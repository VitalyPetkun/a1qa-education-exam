package utils;

import models.Test;
import services.TestDataVariables;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestUtils {

    private static final String EXCEPTIONAL_VALUE = PropertiesManager.getTestDataValue(TestDataVariables.EXCEPTIONAL_VALUE.getVariable());
    private static final String DATA_FORMAT_TESTS_TIME = PropertiesManager.getTestDataValue(TestDataVariables.DATA_FORMAT_TESTS_TIME.getVariable());

    private static final SimpleDateFormat formatter = new SimpleDateFormat(DATA_FORMAT_TESTS_TIME);

    private static Date date;

    private static long firstTestTime = 0;
    private static long secondTestTime = 0;

    private TestUtils() {
    }

    public static String getCorrectEndTime(String endTime) {
        if (endTime.equals("")) {
            return null;
        } else {
            return endTime;
        }
    }

    public static String getCorrectStatus(String status) {
        if (!status.equals(EXCEPTIONAL_VALUE)) {
            return status.toUpperCase();
        } else {
            return status;
        }
    }

    public static boolean isSortedTestsByStartTime(List<Test> tests) {
        SmartLogger.logInfo("Checking the sorting of tests dates in descending order.");
        for (int i = 0; i < tests.size() - 1; i++) {
            try {
                date = formatter.parse(tests.get(i).getStartTime());
                firstTestTime = date.getTime();
                date = formatter.parse(tests.get(i + 1).getStartTime());
                secondTestTime = date.getTime();
            } catch (ParseException e) {
                SmartLogger.logError("Start time isn't correct.");
            }

            if (firstTestTime < secondTestTime) {
                return false;
            } else if (i == tests.size() - 2) {
                return true;
            }
        }

        return false;
    }


}
