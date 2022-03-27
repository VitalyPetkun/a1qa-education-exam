package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class NexagePage extends Form {

    private final ILabel currentTestsPage = getElementFactory().getLabel(By.xpath("//ul[@class='pagination']//li[@class='active']//a"),
            "Current tests page");

    private List<ILabel> tests = new ArrayList<>();

    private final String TD_ATTRIBUTE = ("td");
    private final String TEST_NAME_ATTRIBUTE = String.format("//%s[1]//a", TD_ATTRIBUTE);
    private final String METHOD_NAME_ATTRIBUTE = String.format("//%s[2]", TD_ATTRIBUTE);
    private final String STATUS_ATTRIBUTE = String.format("//%s[3]//span", TD_ATTRIBUTE);
    private final String START_TIME_ATTRIBUTE = String.format("//%s[4]", TD_ATTRIBUTE);
    private final String END_TIME_ATTRIBUTE = String.format("//%s[5]", TD_ATTRIBUTE);
    private final String DURATION_ATTRIBUTE = String.format("//%s[6]", TD_ATTRIBUTE);

    public NexagePage() {
        super(By.xpath("//ol[@class='breadcrumb']//li[text()='Nexage']"), "Nexage page");
    }

    private List<ILabel> getTests() {
        if (tests.size() == 0)
            tests = getElementFactory().findElements(By.xpath("//table[@class='table']//tr"), ElementType.LABEL);

        return tests;
    }

    public int getSizeTests() {
        return getTests().size();
    }

    public String getTestName(int index) {
        return getTests().get(index).findChildElement(By.xpath(TEST_NAME_ATTRIBUTE), ElementType.LABEL).getText();
    }

    public String getMethodName(int index) {
        return getTests().get(index).findChildElement(By.xpath(METHOD_NAME_ATTRIBUTE), ElementType.LABEL).getText();
    }

    public String getStatus(int index) {
        return getTests().get(index).findChildElement(By.xpath(STATUS_ATTRIBUTE), ElementType.LABEL).getText();
    }

    public String getStartTime(int index) {
        return getTests().get(index).findChildElement(By.xpath(START_TIME_ATTRIBUTE), ElementType.LABEL).getText();
    }

    public String getEndTime(int index) {
        return getTests().get(index).findChildElement(By.xpath(END_TIME_ATTRIBUTE), ElementType.LABEL).getText();
    }

    public String getDuration(int index) {
        return getTests().get(index).findChildElement(By.xpath(DURATION_ATTRIBUTE), ElementType.LABEL).getText();
    }

    public String getCurrentTestsPage() {
        return currentTestsPage.getText();
    }
}
