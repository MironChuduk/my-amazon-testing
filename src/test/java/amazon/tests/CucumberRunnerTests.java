package amazon.tests;

import amazon.common.Config;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static amazon.tests.BaseTest.getWebDriverInstance;

@CucumberOptions(tags = "", features = {"src/test/resources/cucumber/my_cucumber.feature"}, glue = {"cucumber"},
        plugin = {})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    private static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = getWebDriverInstance();
    }

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (Config.CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
}
