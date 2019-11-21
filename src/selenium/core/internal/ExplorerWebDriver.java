package selenium.core.internal;

import org.openqa.selenium.ie.InternetExplorerDriver;

final class ExplorerWebDriver extends WebDriverManager {
    private static final String KEY = "webdriver.ie.driver";
    private static ExplorerWebDriver instance;

    private ExplorerWebDriver() {
        //Private constructor
    }

    static ExplorerWebDriver getInstance() {
        if (instance == null) {
            instance = new ExplorerWebDriver();
        }
        return instance;
    }

    @Override
    String getKey() {
        return KEY;
    }

    @Override
    String getDriverName() {
        return "iedriver.exe";
    }

    @Override
    void createWebDriver() {
        webDriver = new InternetExplorerDriver();
    }
}
