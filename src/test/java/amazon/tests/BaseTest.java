package amazon.tests;

import amazon.common.Config;
import amazon.services.CartService;
import amazon.services.HomePageService;
import amazon.services.ProductService;
import amazon.services.ResultsOfSearchService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static amazon.constants.Constant.TimeoutVariable.IMPLICIT_WAIT;
import static amazon.constants.Constant.Urls.AMAZON_HOME_PAGE;

public class BaseTest {

    private static WebDriver driver;
    private static int count = 0;

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            System.out.println("Instance # " + count);
            count++;
            System.setProperty("webdriver.chrome.driver", Config.CHROME_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = getWebDriverInstance();
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
