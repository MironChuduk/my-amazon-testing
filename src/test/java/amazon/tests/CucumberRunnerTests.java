package amazon.tests;

import amazon.common.Config;
import amazon.listeners.TestListener;
import amazon.listeners.WebDriverListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static amazon.tests.BaseTest.getWebDriverInstance;

@Listeners(TestListener.class)
@CucumberOptions(tags = "", features = {"src/test/resources/cucumber/my_cucumber.feature"}, glue = {"cucumber"},
        plugin = {})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    private static WebDriver driver;

    @BeforeClass
    public void setUp() {
        BasicConfigurator.configure();

        driver = getWebDriverInstance();

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new WebDriverListener());

        driver = eventFiringWebDriver;
    }

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (Config.CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }

        driver.quit();
    }
}
