package cucumber;

import amazon.services.CartService;
import amazon.services.HomePageService;
import amazon.services.ProductService;
import amazon.services.ResultsOfSearchService;
import amazon.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static amazon.constants.Constant.MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART;

public class Stepdefs {

    WebDriver driver;
    HomePageService homePageService;
    ResultsOfSearchService resultsOfSearchService;
    ProductService productService;
    CartService cartService;

    @Given("Open link {string} in browser")
    public void openBrowser(String url) {
        driver = BaseTest.getWebDriverInstance();
        driver.get(url);
    }

    @When("Search {string} on Amazon")
    public void searchProduct(String productName) {
        homePageService = new HomePageService();
        resultsOfSearchService = homePageService.searchProduct(productName);
    }

    @Then("Check if product is displayed")
    public void productIsDisplayed() {
        Assert.assertTrue(resultsOfSearchService.isProductTitleDisplayed());
    }

    @And("Add product to cart")
    public void addProductToCart() {
        productService = new ProductService();
        productService.addProductToCart();
    }

    @Then("Check if product is added to cart")
    public void productIsAddedToCart() {
        Assert.assertTrue(productService.isProductPictureDisplayed());
        Assert.assertTrue(productService.isCheckMarkDisplayed());
        Assert.assertEquals(productService.successMessage(), MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART);
        Assert.assertEquals(productService.valueOfCountProductsInCart(), 1);
    }

    @And("Open cart page")
    public void openCartPage() {
        cartService = productService.clickOnShoppingCart();
    }

    @Then("Check is product displayed on cart page")
    public void productIsInCart() {
        Assert.assertTrue(cartService.isProductTitleDisplayed());
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
