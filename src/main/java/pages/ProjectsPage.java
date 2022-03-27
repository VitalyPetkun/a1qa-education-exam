package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class ProjectsPage extends Form {

    private final List<ILabel> projects = getElementFactory().findElements(By.xpath("//div[@class='list-group']//a"), ElementType.LABEL);

    private final ILabel version = getElementFactory().getLabel(By.xpath("//p[contains(@class,'footer')]//span"), "Version");

    private final ILink nexage = getElementFactory().getLink(By.xpath("//div[@class='list-group']//a[text()='Nexage']"), "Nexage");

    private final IButton add = getElementFactory().getButton(By.xpath("//div[@class='panel-heading']//a"), "Add");

    public ProjectsPage() {
        super(By.xpath("//div[@class='list-group']"), "Projects page");
    }

    public String getVersionText() {
        return version.getText();
    }

    public void clickNexageLnk() {
        nexage.click();
    }

    public void clickAddBtn() {
        add.clickAndWait();
    }

    public int getSizeProjects() {
        return projects.size();
    }

    public String getNameProject(int i) {
        return projects.get(i).getText();
    }
}
