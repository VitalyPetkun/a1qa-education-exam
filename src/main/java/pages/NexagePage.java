package pages;

import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class NexagePage extends NewProjectPage {

    private final String NEXAGE_PAGE_LOCATOR = "//ol[@class='breadcrumb']//li[text()='Nexage']";

    private final ILabel currentTestsPage = getElementFactory().getLabel(By.xpath("//ul[@class='pagination']//li[@class='active']//a"),
            "Current tests page");

    public NexagePage() {
        super(NEXAGE_PAGE_LOCATOR, "Nexage page");
    }

    public String getCurrentTestsPage() {
        return currentTestsPage.getText();
    }
}
