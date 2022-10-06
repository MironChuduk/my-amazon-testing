package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.amazon_home.AmazonHomePage;
import pages.base.BasePage;
import pages.cart.CartPage;
import pages.product.ProductPage;
import pages.results_of_search.ResultsOfSearchPage;
import pages.signin.SignIn;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {

    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
    protected ResultsOfSearchPage resultsOfSearchPage = new ResultsOfSearchPage(driver);
    protected ProductPage productPage = new ProductPage(driver);
    protected CartPage cartPage = new CartPage(driver);
    protected SignIn signIn = new SignIn(driver);

    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if(CLEAR_COOKIES_AND_STORAGE)
        {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close(){
        if(HOLD_BROWSER_OPEN)
        {
            driver.quit();
        }
    }

}
