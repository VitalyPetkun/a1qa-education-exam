package browser;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import services.Url;
import utils.PropertiesManager;
import utils.SmartLogger;

import java.util.Set;

public class Browser {

    private Browser() {
    }

    private static aquality.selenium.browser.Browser getBrowser() {
        return AqualityServices.getBrowser();
    }

    private static RemoteWebDriver getDriver() {
        return getBrowser().getDriver();
    }

    public static void addCookie(Cookie cookie) {
        SmartLogger.logInfo("Add cookie.");
        getDriver().manage().addCookie(cookie);
    }

    public static void close() {
        SmartLogger.logInfo("Close current window.");
        getDriver().close();
    }

    public static String getBrowserName() {
        SmartLogger.logInfo("Get browser name.");
        return getBrowser().getBrowserName().toString();
    }

    public static String getWindowHandle() {
        SmartLogger.logInfo("Get handle current window.");
        return getDriver().getWindowHandle();
    }

    public static Set<String> getWindowHandles() {
        SmartLogger.logInfo("Get handles windows.");
        return getDriver().getWindowHandles();
    }

    public static void goBack() {
        SmartLogger.logInfo("Go back window.");
        getBrowser().goBack();
    }

    public static void goTo(String url) {
        SmartLogger.logInfo("Go to url - %s.".concat(url));
        getBrowser().goTo(url);
    }

    public static void goToAuthorization(String userName, String userPassword, String url) {
        String currentUrl = PropertiesManager.getConfigValue(Url.HTTP.getUrl()).
                concat(userName).concat(":").concat(userPassword).concat("@").concat(url);
        Browser.goTo(currentUrl);
    }

    public static void quit() {
        SmartLogger.logInfo("Quit browser.");
        getDriver().quit();
    }

    public static void refresh() {
        SmartLogger.logInfo("Refresh current window.");
        getDriver().navigate().refresh();
    }

    public static void setMaximizeWindow() {
        SmartLogger.logInfo("Set window size maximize");
        getDriver().manage().window().maximize();
    }

    public static void switchTo(String windowHandle) {
        SmartLogger.logInfo("Switch to window handle - %s".concat(windowHandle));
        getDriver().switchTo().window(windowHandle);
    }

    public static void switchToOtherWindow(String originalWindow) {
        for (String windowHandle : getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                switchTo(windowHandle);
                break;
            }
        }
    }

    public static String[] takeScreenshot() {
        SmartLogger.logInfo("Get info screenshot {base64, format}.");
        String screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE).toString();
        String[] screenshotInfo = {screenshot.replaceAll("[^0-9]", ""), screenshot.split("\\.")[1]};
        return screenshotInfo;
    }

    public static void timeouts() {
        SmartLogger.logInfo("Timeout load browser");
        getDriver().manage().timeouts();
    }
}
