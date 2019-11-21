package selenium.core.internal;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager {
    WebDriver webDriver;

    WebDriverManager() {
        String path = System.getProperty("user.dir");
        System.setProperty(getKey(), path + "\\driver\\" + getDriverName());
    }

    abstract String getKey();

    abstract String getDriverName();

    abstract void createWebDriver();

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            createWebDriver();
        }
        return webDriver;
    }

    public void stopWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
