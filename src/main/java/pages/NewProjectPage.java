package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class NewProjectPage extends Form {

    private final String NEW_PROJECT_PAGE_LOCATOR = "//table[@id='allTests']//div[contains(@class,'danger')]";
    private final String TESTS_LIST_LOCATOR = "//table[@class='table']//tr";
    private final String TD_ATTRIBUTE = ("td");
    private final String TEST_NAME_ATTRIBUTE = String.format("//%s[1]//a", TD_ATTRIBUTE);
    private final String METHOD_NAME_ATTRIBUTE = String.format("//%s[2]", TD_ATTRIBUTE);
    private final String STATUS_ATTRIBUTE = String.format("//%s[3]//span", TD_ATTRIBUTE);
    private final String START_TIME_ATTRIBUTE = String.format("//%s[4]", TD_ATTRIBUTE);
    private final String END_TIME_ATTRIBUTE = String.format("//%s[5]", TD_ATTRIBUTE);
    private final String DURATION_ATTRIBUTE = String.format("//%s[6]", TD_ATTRIBUTE);

    protected NewProjectPage(String locator, String name) {
        super(By.xpath(locator), name);
    }

    public NewProjectPage() {
        super(By.xpath(NEW_PROJECT_PAGE_LOCATOR), "New project");
    }

    private List<ILabel> getTests() {
        return getElementFactory().findElements(By.xpath(TESTS_LIST_LOCATOR), ElementType.LABEL);
    }

    public String getDuration(int index) {
        return getTests().get(index).findChildElement(By.xpath(DURATION_ATTRIBUTE), ElementType.LABEL).getText();
    }

    public String getEndTime(int index) {
        return getTests().get(index).findChildElement(By.xpath(END_TIME_ATTRIBUTE), ElementType.LABEL).getText();
    }

    public String getMethodName(int index) {
        return getTests().get(index).findChildElement(By.xpath(METHOD_NAME_ATTRIBUTE), ElementType.LABEL).getText();
    }

    public int getSizeTests() {
        return getTests().size();
    }

    public String getStartTime(int index) {
        return getTests().get(index).findChildElement(By.xpath(START_TIME_ATTRIBUTE), ElementType.LABEL).getText();
    }

    public String getStatus(int index) {
        return getTests().get(index).findChildElement(By.xpath(STATUS_ATTRIBUTE), ElementType.LABEL).getText();
    }

    public String getTestName(int index) {
        return getTests().get(index).findChildElement(By.xpath(TEST_NAME_ATTRIBUTE), ElementType.LABEL).getText();
    }
}
