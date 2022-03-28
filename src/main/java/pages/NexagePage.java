package pages;

import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class NexagePage extends NewProjectPage {

    private final ILabel currentTestsPage = getElementFactory().getLabel(By.xpath("//ul[@class='pagination']//li[@class='active']//a"),
            "Current tests page");

    public NexagePage() {
        super("//ol[@class='breadcrumb']//li[text()='Nexage']", "Nexage page");
    }

    public String getCurrentTestsPage() {
        return currentTestsPage.getText();
    }
}
