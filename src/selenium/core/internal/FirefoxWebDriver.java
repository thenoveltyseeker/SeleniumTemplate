package selenium.core.internal;

import org.openqa.selenium.firefox.FirefoxDriver;

final class FirefoxWebDriver extends WebDriverManager {
    private static final String KEY = "webdriver.gecko.driver";
    private static FirefoxWebDriver instance;

    private FirefoxWebDriver() {
        //Private constructor
    }

    static FirefoxWebDriver getInstance() {
        if (instance == null) {
            instance = new FirefoxWebDriver();
        }
        return instance;
    }

    @Override
    String getKey() {
        return KEY;
    }

    @Override
    String getDriverName() {
        return "geckodriver.exe";
    }

    @Override
    void createWebDriver() {
        webDriver = new FirefoxDriver();
    }
}
