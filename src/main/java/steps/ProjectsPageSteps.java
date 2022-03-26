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

    public static void clickNexageLnk() {
        projectsPage.clickNexageLnk();
    }

    public static void assertIsCorrectVersion(String version) {
        Assert.assertEquals(getVersionNumber(), version, "Version isn't correct.");
    }

    public static void assertIsOpenWelcomePage() {
        Assert.assertTrue(projectsPage.state().isDisplayed(), "Projects page isn't open.");
    }
}
