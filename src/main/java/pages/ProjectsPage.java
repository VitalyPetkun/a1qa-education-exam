package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ProjectsPage extends Form {

    private final ILabel version = getElementFactory().getLabel(By.xpath("//p[contains(@class,'footer')]//span"), "Version");

    private final ILink nexage = getElementFactory().getLink(By.xpath("//div[@class='list-group']//a[text()='Nexage']"), "Nexage");

    public ProjectsPage() {
        super(By.xpath("//div[@class='list-group']"), "Projects page");
    }

    public String getVersionText() {
        return version.getText();
    }

    public void clickNexageLnk() {
        nexage.click();
    }
}
