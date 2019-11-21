package selenium.core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.components.Browser;
import selenium.core.internal.WebDriverFactory;
import selenium.core.internal.WebDriverManager;

public abstract class BaseTest {
    private WebDriverManager mWebDriverManager;
    //Change it to true if you want to close the session
    protected boolean shouldStopDriver;

    @BeforeClass
    public void startDriver() {
        boolean hasDriverChanged = WebDriverFactory.sCurrentType != getWebDriverType();
        mWebDriverManager = WebDriverFactory.getDriverManager(getWebDriverType());
        if (Browser.getWebDriver() == null | hasDriverChanged) {
            Browser.setWebDriver(mWebDriverManager.getWebDriver());
        }
    }

    protected WebDriverType getWebDriverType() {
        return WebDriverFactory.sCurrentType;
    }

    @Test
    public abstract void execute();

    @AfterClass
    protected void stopDriver() {
        if (shouldStopDriver) {
            mWebDriverManager.stopWebDriver();
            Browser.setWebDriver(null);
        }
    }
}
