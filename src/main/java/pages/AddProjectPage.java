package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AddProjectPage extends Form {

    private final ITextBox projectName = getElementFactory().getTextBox(By.xpath("//input[@id='projectName']"),
            "Project name");

    private final IButton saveProject = getElementFactory().getButton(By.xpath("//button[@type='submit']"),
            "Save project");

    private final ILabel successfulSaveMessage = getElementFactory().getLabel(By.xpath("//div[contains(@class,'alert-success')]"),
            "Successful save message");

    public AddProjectPage() {
        super(By.xpath("//form[@id='addProjectForm']"), "Add project page");
    }

    public void inputProjectNameTxt(String name) {
        projectName.clearAndType(name);
    }

    public void clickSaveProjectBtn() {
        saveProject.click();
    }

    public boolean isDisplayedSuccessfulSaveMessage() {
        return successfulSaveMessage.state().waitForDisplayed();
    }
}
