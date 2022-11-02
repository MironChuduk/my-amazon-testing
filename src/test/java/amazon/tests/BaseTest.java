package amazon.tests;

import amazon.common.Config;
import amazon.listeners.WebDriverListener;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static amazon.constants.Constant.TimeoutVariable.IMPLICIT_WAIT;
import static amazon.constants.Constant.Urls.AMAZON_HOME_PAGE;

public class BaseTest {

    private static WebDriver driver;

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", Config.CHROME_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    @BeforeClass
    public void setUp() {
        BasicConfigurator.configure();

        driver = getWebDriverInstance();

        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new WebDriverListener());

        driver = eventFiringWebDriver;

        driver.get(AMAZON_HOME_PAGE);
    }

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (Config.CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        if (Config.HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
