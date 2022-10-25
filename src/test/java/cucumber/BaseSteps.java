package cucumber;

import amazon.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    private WebDriver driver;

    @Given("I open link {string} in browser")
    public void openBrowser(String url) {
        driver = BaseTest.getWebDriverInstance();
        driver.get(url);
    }

    @After
    public void tearDown() {
        driver = BaseTest.getWebDriverInstance();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
        driver.quit();
    }
}
