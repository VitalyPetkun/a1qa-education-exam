package steps;

import org.testng.Assert;
import pages.AddProjectPage;

public class AddProjectPageSteps {

    private static final AddProjectPage addProjectPage = new AddProjectPage();

    private AddProjectPageSteps() {
    }

    private static void inputProjectNameTxt(String name) {
        addProjectPage.inputProjectNameTxt(name);
    }

    private static void clickSaveProjectBtn() {
        addProjectPage.clickSaveProjectBtn();
    }

    public static void addNewProject(String name) {
        inputProjectNameTxt(name);
        clickSaveProjectBtn();
    }

    public static void assertIsDisplayedSuccessfulSaveMessage() {
        Assert.assertTrue(addProjectPage.isDisplayedSuccessfulSaveMessage(), "Successful save message isn't displayed.");
    }

    public static void assertIsOpenAddProjectPage() {
        Assert.assertTrue(addProjectPage.state().isDisplayed(), "Add project form isn't open.");
    }

    public static void assertIsCloseAddProjectPage() {
        Assert.assertFalse(addProjectPage.state().isDisplayed(), "Add project form isn't close.");
    }
}
