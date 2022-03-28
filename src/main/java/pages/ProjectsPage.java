package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class ProjectsPage extends Form {

    private final IButton add = getElementFactory().getButton(By.xpath("//div[@class='panel-heading']//a"), "Add");

    private final ILabel version = getElementFactory().getLabel(By.xpath("//p[contains(@class,'footer')]//span"), "Version");

    private final ILink nexage = getElementFactory().getLink(By.xpath("//div[@class='list-group']//a[text()='Nexage']"), "Nexage");

    private final String NEW_PROJECT_LOCATOR = "//div[@class='list-group']//a[text()='%s']";

    public ProjectsPage() {
        super(By.xpath("//div[@class='list-group']"), "Projects page");
    }

    private List<ILabel> getProjects() {
        return getElementFactory().findElements(By.xpath("//div[@class='list-group']//a"), ElementType.LABEL);
    }

    public void clickAddBtn() {
        add.clickAndWait();
    }

    public void clickNewProjectLnk(String name) {
        getElementFactory().getLink(By.xpath(String.format(NEW_PROJECT_LOCATOR, name)), name).click();
    }

    public void clickNexageLnk() {
        nexage.click();
    }

    public String getNameProject(int i) {
        return getProjects().get(i).getText();
    }

    public int getSizeProjects() {
        return getProjects().size();
    }

    public String getVersionText() {
        return version.getText();
    }
}
