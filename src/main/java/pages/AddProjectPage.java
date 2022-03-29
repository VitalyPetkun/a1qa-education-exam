package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AddProjectPage extends Form {

    private static final String ADD_PROJECT_PAGE_LOCATOR = "//form[@id='addProjectForm']";

    private final IButton saveProject = getElementFactory().getButton(By.xpath("//button[@type='submit']"),
            "Save project");

    private final ILabel successfulSaveMessage = getElementFactory().getLabel(By.xpath("//div[contains(@class,'alert-success')]"),
            "Successful save message");

    private final ITextBox projectName = getElementFactory().getTextBox(By.xpath("//input[@id='projectName']"),
            "Project name");

    public AddProjectPage() {
        super(By.xpath(ADD_PROJECT_PAGE_LOCATOR), "Add project page");
    }

    public void clickSaveProjectBtn() {
        saveProject.click();
    }

    public void inputProjectNameTxt(String name) {
        projectName.clearAndType(name);
    }

    public boolean isDisplayedSuccessfulSaveMessage() {
        return successfulSaveMessage.state().waitForDisplayed();
    }
}
