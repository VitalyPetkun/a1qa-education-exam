package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ProjectsPage extends Form {

    private final ILabel version = getElementFactory().getLabel(By.xpath("//p[contains(@class,'footer')]//span"), "Version");

    public ProjectsPage() {
        super(By.xpath("//div[@class='list-group']"), "Projects page");
    }

    public String getVersionText() {
        return version.getText();
    }
}
