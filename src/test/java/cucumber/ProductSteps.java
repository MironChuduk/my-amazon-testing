package cucumber;

import amazon.services.HomePageService;
import amazon.services.ResultsOfSearchService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductSteps {
    private HomePageService homePageService;
    private ResultsOfSearchService resultsOfSearchService;

    @When("I search {string} on Amazon")
    public void searchProduct(String productName) {
        homePageService = new HomePageService();
        resultsOfSearchService = homePageService.searchProduct(productName);
    }

    @Then("Verify if product is displayed")
    public void productIsDisplayed() {
        Assert.assertTrue(resultsOfSearchService.isProductTitleDisplayed());
    }
}
