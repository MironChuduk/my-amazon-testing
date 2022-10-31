package cucumber;

import amazon.services.HomePageService;
import amazon.tests.BaseTest;
import amazon.utils.JavascriptExecutorUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

import static amazon.constants.Constant.Urls.AMAZON_HOME_PAGE;

public class BaseSteps {

    private WebDriver driver;
    private HomePageService homePageService;

    @Given("I open the site in browser")
    public void openBrowser() {
        driver = BaseTest.getWebDriverInstance();
        driver.get(AMAZON_HOME_PAGE);
    }

    @Then("Verify menu items$")
    public void verifyAreItemsDisplayed(List<String> expectedItems) {
        homePageService = new HomePageService();
        Assert.assertEquals(homePageService.listOfGiftCardTitles(), expectedItems);
    }

    @When("I scroll page down")
    public void scrollPageDown() {
        JavascriptExecutorUtil.scrollPage(driver, 6000);
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
}
