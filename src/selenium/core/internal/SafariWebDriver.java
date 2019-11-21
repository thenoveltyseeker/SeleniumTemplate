package selenium.core.internal;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

final class SafariWebDriver extends WebDriverManager {
    private static final String KEY = "webdriver.safari.driver";
    private static SafariWebDriver instance;

    private SafariWebDriver() {
        //Private constructor
    }

    static SafariWebDriver getInstance() {
        if (instance == null) {
            instance = new SafariWebDriver();
        }
        return instance;
    }

    @Override
    String getKey() {
        return KEY;
    }

    @Override
    String getDriverName() {
        return "safaridriver.exe";
    }

    @Override
    void createWebDriver() {
        SafariOptions safariOptions = new SafariOptions();
        webDriver = new SafariDriver(safariOptions);
    }
}
