package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class NexagePage extends Form {

    private final List<ILabel> tests = getElementFactory().findElements(By.xpath("//table[@class='table']//tr"), ElementType.LABEL);

    public NexagePage() {
        super(By.xpath("//ol[@class='breadcrumb']//li[text()='Nexage']"), "Nexage page");
    }
}
