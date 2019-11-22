# SeleniumTemplate
A Library which can be used as a template for web automation.

This template already includes **Selenium** and **TestNG** frameworks.
The purpose of this library is to act as a wrapper over Selenium and TestNG, without the need of adding them seperately to your project.

## HOW
- Create or Open your project
- Add the **Selenium template** jar to your project
- Create a new folder named **driver** directly under your project directory, keep all the drivers in it and name them like below
  - `chromedriver.exe` -> Chrome
  - `geckodriver.exe` -> Firefox
  - `operadriver.exe` -> Opera
  - `safaridriver.exe` -> Safari
  - `edgedriver.exe` -> Edge
  - `iedriver.exe` -> Internet explorer
- Now you can start using the library features.

## Features

This template provides the following features:
- You don't need to create or manage `WebDriver`
- There is a parent class named `BaseTest` is available for your TestCase classes.
- All the `WebDriver` related functions are available in `Browswer` utility class.
- Getting a `WebElement` is as easy as providing the `ByType` and value   
- You can manage the type of browser by using the enums form `WebDriverType`. By Default the type will be Chrome, if you want to change it you can do by overriding it in your child class.
```   
@Override
protected WebDriverType getWebDriverType() {
  return WebDriverType.FIREFOX;
}
```
- You have to implement `execute()` from the `BaseTest`, the execution of each class will start from that method.
- You can write subsequent functions with `@Test` annotation along with execution priority. `execute` will always have priority 0.
- If you want to close the browser after the execution of a certain class then set `shouldStopDriver` falg to true.

### Sample test case class.

```
public class SampleTestCase extends BaseTest {

    @Override
    protected WebDriverType getWebDriverType() {
        return WebDriverType.FIREFOX;
    }

    @Override
    public void execute() {
        Browser.load("https://www.google.com/");
        Browser.setElementText(ByType.XPATH, "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input", "Fernando Torres");
        Browser.performElementClick(ByType.XPATH, "//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]");
    }

    @Test(priority = 1)
    public void loadImageTab() {
        Browser.performElementClick(ByType.XPATH, "//*[@id=\"hdtb-msb-vis\"]/div[3]/a");
    }
}
```
