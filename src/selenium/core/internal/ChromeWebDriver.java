package selenium.core.internal;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

final class ChromeWebDriver extends WebDriverManager {
    private static final String KEY = "webdriver.chrome.driver";
    private static ChromeWebDriver instance;

    private ChromeWebDriver() {
        //Private constructor
    }

    static ChromeWebDriver getInstance() {
        if (instance == null) {
            instance = new ChromeWebDriver();
        }
        return instance;
    }

    @Override
    String getKey() {
        return KEY;
    }

    @Override
    String getDriverName() {
        return "chromedriver.exe";
    }

    @Override
    void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        webDriver = new ChromeDriver(options);
    }
}
