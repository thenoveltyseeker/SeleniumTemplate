package selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
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

    /* ------- WebDriver functions ------- */

    /**
     * Loads a particular url in the current browser.
     *
     * @param url - url to be loaded
     */
    public static void load(String url) {
        sWebDriver.get(url);
    }

    /**
     * Browser will wait for the given amount of time.
     *
     * @param seconds - time to wait in seconds
     */
    public static void waitFor(int seconds) {
        try {
            sWebDriver.wait(seconds * SECONDS_CONVERTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Maximize the browser window.
     */
    public static void maximize() {
        sWebDriver.manage().window().maximize();
    }

    /**
     * Navigate forward in the browser.
     */
    public static void goForward() {
        sWebDriver.navigate().forward();
    }

    /**
     * Navigate backward in the browser.
     */
    public static void goBack() {
        sWebDriver.navigate().back();
    }

    /**
     * Refresh the current page.
     */
    public static void refresh() {
        sWebDriver.navigate().refresh();
    }

    /**
     * Navigate to a particular Url.
     *
     * @param url - url to be loaded.
     */
    public static void navigateTo(String url) {
        sWebDriver.navigate().to(url);
    }


    /* ------- WebElement functions ------- */

    /**
     * Get a particular Web element based on the By Type passed. Default will be XPATH.
     *
     * @param byType  - which type should be used to find the element.{@link ByType}
     * @param byValue - Value of the {@link ByType}
     * @return element - corresponding web element.
     */
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

    /**
     * Performs click on the web element.
     *
     * @param byType  - ByType of the web element.
     * @param byValue - Value of the ByType.
     * @see Browser#getWebElement(ByType, String)
     */
    public static void performElementClick(ByType byType, String byValue) {
        WebElement element = getWebElement(byType, byValue);
        element.click();
    }

    /**
     * Set a text on the web element.
     *
     * @param byType  - ByType of the web element.
     * @param byValue - Value of the ByType.
     * @param text    - text to be set.
     * @see Browser#getWebElement(ByType, String)
     */
    public static void setElementText(ByType byType, String byValue, String text) {
        WebElement element = getWebElement(byType, byValue);
        element.sendKeys(text);
    }

    /**
     * Clear the text from the web element.
     *
     * @param byType  - ByType of the web element.
     * @param byValue - Value of the ByType.
     * @see Browser#getWebElement(ByType, String)
     */
    public static void clearElementText(ByType byType, String byValue) {
        WebElement element = getWebElement(byType, byValue);
        element.clear();
    }

    /**
     * Performs click on the web element.
     *
     * @param element - {@link WebElement}.
     */
    public static void performElementClick(WebElement element) {
        element.click();
    }

    /**
     * Set text on the web element.
     *
     * @param element - {@link WebElement}.
     * @param text    - Text to be set.
     */
    public static void setElementText(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Clear text from the web element.
     *
     * @param element - {@link WebElement}.
     */
    public static void clearElementText(WebElement element) {
        element.clear();
    }

    /**
     * Selects an option from the dropdown based on the index.
     * It will throw an exception if an item is not available at that index.
     *
     * @param byType  - ByType of the web element.
     * @param byValue - Value of the ByType.
     * @param index   - index of the item to be selected
     * @see Browser#getWebElement(ByType, String)
     */
    public static void selectDropDownByIndex(ByType byType, String byValue, int index) {
        Select dropDown = new Select(getWebElement(byType, byValue));
        dropDown.selectByIndex(index);
    }

    /**
     * Keeps the browser in wait mode until the condition is satisfied.
     *
     * @param conditions - {@link org.openqa.selenium.support.ui.ExpectedConditions}
     * @see org.openqa.selenium.support.ui.ExpectedConditions for different available options.
     * @see WebDriverWait
     */
    public static <T> void waitCondition(ExpectedCondition<T> conditions) {
        WebDriverWait driverWait = new WebDriverWait(sWebDriver, 20);
        driverWait.until(conditions);
    }

}
