package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ProjectsPage extends Form {

    public ProjectsPage() {
        super(By.xpath("//div[@class='list-group']"), "Projects page");
    }
}
