package steps;

import models.Test;
import org.testng.Assert;
import pages.NexagePage;
import services.TestDataVariables;
import utils.PropertiesManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NexagePageSteps {

    private static final String EXCEPTIONAL_VALUE = PropertiesManager.getTestDataValue(TestDataVariables.EXCEPTIONAL_VALUE.getVariable());

    private static final NexagePage nexagePage = new NexagePage();

    private static List<Test> webTests = new ArrayList<>();

    private NexagePageSteps() {
    }

    private static String getCurrentTestsPage() {
        return nexagePage.getCurrentTestsPage().replaceAll("[^0-9]", "");
    }

    private static List<Test> getTests() {
        if (webTests.size() == 0) {

            for (int i = 1; i < nexagePage.getSizeTests(); i++) {
                webTests.add(new Test());
                webTests.get(i - 1).setName(nexagePage.getTestName(i));
                webTests.get(i - 1).setMethod(nexagePage.getMethodName(i));
                webTests.get(i - 1).setStartTime(nexagePage.getStartTime(i));
                webTests.get(i - 1).setDuration(nexagePage.getDuration(i));

                if (nexagePage.getEndTime(i).equals("")) {
                    webTests.get(i - 1).setEndTime(null);
                } else {
                    webTests.get(i - 1).setEndTime(nexagePage.getEndTime(i));
                }

                if (!nexagePage.getStatus(i).equals(EXCEPTIONAL_VALUE)) {
                    webTests.get(i - 1).setStatus(nexagePage.getStatus(i).toUpperCase());
                } else {
                    webTests.get(i - 1).setStatus(nexagePage.getStatus(i));
                }
            }
        }

        return webTests;
    }

    public static void assertIsContainTests(List<Test> apiTests) {
        for (Test test : getTests()) {
            Assert.assertTrue(apiTests.contains(test), "Web tests don't contains api test.");
        }
    }

    public static void assertIsCorrectCurrentTestsPage(String expectedTestsPage) {
        Assert.assertTrue(getCurrentTestsPage().equals(expectedTestsPage), "Current tests page isn't correct.");
    }

    public static void assertIsOpenNexagePage() {
        Assert.assertTrue(nexagePage.state().waitForDisplayed(), "Nexage page isn't open.");
    }
}
