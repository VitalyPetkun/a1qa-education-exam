package steps;

import models.Test;
import org.testng.Assert;
import pages.NewProjectPage;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

public class NewProjectPageSteps {

    private static final NewProjectPage newProjectPage = new NewProjectPage();

    private static List<Test> webTests = new ArrayList<>();

    private NewProjectPageSteps() {
    }

    private static List<Test> getTests() {
        if (webTests.size() == 0) {

            for (int i = 1; i < newProjectPage.getSizeTests(); i++) {
                webTests.add(new Test());
                webTests.get(i - 1).setName(newProjectPage.getTestName(i));
                webTests.get(i - 1).setMethod(newProjectPage.getMethodName(i));
                webTests.get(i - 1).setStartTime(newProjectPage.getStartTime(i));
                webTests.get(i - 1).setEndTime(TestUtils.getCorrectEndTime(newProjectPage.getEndTime(i)));
                webTests.get(i - 1).setDuration(newProjectPage.getDuration(i));
                webTests.get(i - 1).setStatus(TestUtils.getCorrectStatus(newProjectPage.getStatus(i)));
            }
        }

        return webTests;
    }

    private static boolean isTest(Test test) {
        boolean result = false;

        for (int i = 0; i < getTests().size(); i++) {
            if (getTests().get(i).getName().equals(test.getName()) &&
                    getTests().get(i).getMethod().equals(test.getMethod())) {
                result = true;
            }
        }

        return result;
    }

    public static void assertIsContainTest(Test test) {
        Assert.assertTrue(getTests().contains(test), "Web tests don't contains api test.");
    }

    public static void assertIsOpenNewProjectPage() {
        Assert.assertTrue(newProjectPage.state().waitForDisplayed(), "New project page isn't open.");
    }

    public static void assertIsTest(Test test) {
        Assert.assertTrue(isTest(test), "Test isn't in tests list.");
    }
}
