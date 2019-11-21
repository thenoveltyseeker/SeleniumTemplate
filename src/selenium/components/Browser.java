package selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
    private static final int SECONDS_CONVERTER = 1000;
    private static WebDriver sWebDriver;

    public static WebDriver getWebDriver() {
        return sWebDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        sWebDriver = webDriver;
    }

    /************************ WebDriver functions *********************************/

    public static void load(String url) {
        sWebDriver.get(url);
    }

    public static void waitFor(int seconds) {
        try {
            sWebDriver.wait(seconds * SECONDS_CONVERTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void maximize() {
        sWebDriver.manage().window().maximize();
    }

    public static void goForward() {
        sWebDriver.navigate().forward();
    }

    public static void goBack() {
        sWebDriver.navigate().back();
    }

    public static void refresh() {
        sWebDriver.navigate().refresh();
    }

    public static void navigateTo(String url) {
        sWebDriver.navigate().to(url);
    }


    /************************ WebElement functions *********************************/

    public static WebElement getWebElement(ByType byType, String byValue) {
        WebElement element;
        switch (byType) {
            case ID:
                element = sWebDriver.findElement(By.id(byValue));
                break;
            case NAME:
                element = sWebDriver.findElement(By.name(byValue));
                break;
            case CLASS_NAME:
                element = sWebDriver.findElement(By.className(byValue));
                break;
            case CSS_SELECTOR:
                element = sWebDriver.findElement(By.cssSelector(byValue));
                break;
            case XPATH:
            default:
                element = sWebDriver.findElement(By.xpath(byValue));
                break;
        }
        return element;
    }

    public static void performElementClick(ByType byType, String byValue) {
        WebElement element = getWebElement(byType, byValue);
        element.click();
    }

    public static void setElementText(ByType byType, String byValue, String text) {
        WebElement element = getWebElement(byType, byValue);
        element.sendKeys(text);
    }

    public static void clearElementText(ByType byType, String byValue) {
        WebElement element = getWebElement(byType, byValue);
        element.clear();
    }

    public static void performElementClick(WebElement element) {
        element.click();
    }

    public static void setElementText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static void clearElementText(WebElement element) {
        element.clear();
    }

    public static <T> void waitCondition(ExpectedCondition<T> conditions) {
        WebDriverWait driverWait = new WebDriverWait(sWebDriver, 20);
        driverWait.until(conditions);
    }

}
