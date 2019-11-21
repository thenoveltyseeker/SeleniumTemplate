package selenium.core.internal;

import org.openqa.selenium.opera.OperaDriver;

final class OperaWebDriver extends WebDriverManager {
    private static final String KEY = "webdriver.opera.driver";
    private static OperaWebDriver instance;

    private OperaWebDriver() {
        //Private constructor
    }

    static OperaWebDriver getInstance() {
        if (instance == null) {
            instance = new OperaWebDriver();
        }
        return instance;
    }

    @Override
    String getKey() {
        return KEY;
    }

    @Override
    String getDriverName() {
        return "operadriver.exe";
    }

    @Override
    void createWebDriver() {
        webDriver = new OperaDriver();
    }
}
