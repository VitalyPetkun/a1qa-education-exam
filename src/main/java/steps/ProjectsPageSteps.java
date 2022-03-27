package steps;

import org.testng.Assert;
import pages.ProjectsPage;
import pages.AddProjectPage;

public class ProjectsPageSteps {

    private final static ProjectsPage projectsPage = new ProjectsPage();
    private final static AddProjectPage addProjectForm = new AddProjectPage();

    private ProjectsPageSteps() {
    }

    private static String getVersionNumber() {
        return projectsPage.getVersionText().replaceAll("[^0-9]", "");
    }

    private static void inputProjectNameTxt(String name) {
        addProjectForm.inputProjectNameTxt(name);
    }

    private static void clickSaveProjectBtn() {
        addProjectForm.clickSaveProjectBtn();
    }

    public static void clickNexageLnk() {
        projectsPage.clickNexageLnk();
    }

    public static void clickAddBtn() {
        projectsPage.clickAddBtn();
    }

    public static void addNewProject(String name) {
        inputProjectNameTxt(name);
        clickSaveProjectBtn();
    }

    private static boolean isContainsProject(String name) {
        for (int i = 1; i < projectsPage.getSizeProjects(); i++) {
            if (projectsPage.getNameProject(i).equals(name))
                return true;
        }

        return false;
    }

    public static void assertIsContainsProjectInPageList(String name) {
        Assert.assertTrue(isContainsProject(name), "Project %s don't contains in page list".concat(name));
    }

    public static void assertIsDisplayedSuccessfulSaveMessage() {
        Assert.assertTrue(addProjectForm.isDisplayedSuccessfulSaveMessage(), "Successful save message isn't displayed.");
    }

    public static void assertIsOpenAddProjectForm() {
        Assert.assertTrue(addProjectForm.state().isDisplayed(), "Add project form isn't open.");
    }

    public static void assertIsCloseAddProjectForm() {
        Assert.assertFalse(addProjectForm.state().isDisplayed(), "Add project form isn't close.");
    }

    public static void assertIsCorrectVersion(String version) {
        Assert.assertTrue(getVersionNumber().equals(version), "Version isn't correct.");
    }

    public static void assertIsOpenProjectsPage() {
        Assert.assertTrue(projectsPage.state().waitForDisplayed(), "Projects page isn't open.");
    }
}
