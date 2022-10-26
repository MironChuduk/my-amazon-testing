package cucumber;

import amazon.services.HomePageService;
import amazon.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class BaseSteps {

    private WebDriver driver;
    private HomePageService homePageService;

    @Given("I open link {string} in browser")
    public void openBrowser(String url) {
        driver = BaseTest.getWebDriverInstance();
        driver.get(url);
        System.out.println("TESTTT!");
    }

    @Then("Verify menu items$")
    public void itemsAreDisplayed(List<String> expectedItems) {
        homePageService = new HomePageService();
        Assert.assertEquals(homePageService.listOfGiftCardTitles(), expectedItems);
    }

    @When("I scroll page down")
    public void scrollPageDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,6000)");
    }

    @Then("Verify language is {string}")
    public void verifyLanguage(String expectedLanguage) {
        homePageService = new HomePageService();
        Assert.assertEquals(homePageService.getSelectedLanguage(), expectedLanguage);
    }

    @And("Verify currency is {string}")
    public void verifyCurrency(String expectedCurrency) {
        homePageService = new HomePageService();
        Assert.assertEquals(homePageService.getSelectedCurrency(), expectedCurrency);
    }

    @When("I open Gift Cards Page")
    public void openGiftCardsPage() {
        homePageService = new HomePageService();
        homePageService.goToGiftCardsPage();
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
