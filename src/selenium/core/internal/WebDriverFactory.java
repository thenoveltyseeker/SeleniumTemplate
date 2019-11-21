package selenium.core.internal;

import selenium.core.WebDriverType;

public final class WebDriverFactory {
    public static WebDriverType sCurrentType = WebDriverType.CHROME;

    public static WebDriverManager getDriverManager(WebDriverType driverType) {
        sCurrentType = driverType;
        switch (driverType) {
            case FIREFOX:
                return FirefoxWebDriver.getInstance();
            case SAFARI:
                return SafariWebDriver.getInstance();
            case OPERA:
                return OperaWebDriver.getInstance();
            case IE:
                return ExplorerWebDriver.getInstance();
            case EDGE:
                return EdgeWebDriver.getInstance();
            case CHROME:
            default:
                return ChromeWebDriver.getInstance();
        }
    }
}
