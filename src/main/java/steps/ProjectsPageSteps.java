package steps;

import org.testng.Assert;
import pages.ProjectsPage;

public class ProjectsPageSteps {

    private final static ProjectsPage projectsPage = new ProjectsPage();

    private ProjectsPageSteps() {
    }

    private static String getVersionNumber() {
        return projectsPage.getVersionText().replaceAll("[^0-9]", "");
    }

    public static void clickAddBtn() {
        projectsPage.clickAddBtn();
    }

    public static void clickNexageLnk() {
        projectsPage.clickNexageLnk();
    }

    public static void clickNewProjectLnk(String name) {
        projectsPage.clickNewProjectLnk(name);
    }

    public static boolean isContainsProject(String name) {
        for (int i = 0; i < projectsPage.getSizeProjects(); i++) {
            if (projectsPage.getNameProject(i).equals(name))
                return true;
        }

        return false;
    }

    public static void assertIsContainsProjectInPageList(String name) {
        Assert.assertTrue(isContainsProject(name), String.format("Project %s don't contains in page list", name));
    }

    public static void assertIsCorrectVersion(String version) {
        Assert.assertTrue(getVersionNumber().equals(version), "Version isn't correct.");
    }

    public static void assertIsOpenProjectsPage() {
        Assert.assertTrue(projectsPage.state().waitForDisplayed(), "Projects page isn't open.");
    }
}
