package selenium.core.internal;

import org.openqa.selenium.edge.EdgeDriver;

final class EdgeWebDriver extends WebDriverManager {
    private static final String KEY = "webdriver.edge.driver";
    private static EdgeWebDriver instance;

    private EdgeWebDriver() {
        //Private constructor
    }

    static EdgeWebDriver getInstance() {
        if (instance == null) {
            instance = new EdgeWebDriver();
        }
        return instance;
    }

    @Override
    String getKey() {
        return KEY;
    }

    @Override
    String getDriverName() {
        return "edgedriver.exe";
    }

    @Override
    void createWebDriver() {
        webDriver = new EdgeDriver();
    }
}
