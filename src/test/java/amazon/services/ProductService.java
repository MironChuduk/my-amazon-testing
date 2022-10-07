package amazon.services;

import amazon.pages.BasePage;
import amazon.pages.ProductPage;
import amazon.pages.ResultsOfSearchPage;
import amazon.tests.BaseTest;

public class ProductService {

    BasePage basePage;
    ResultsOfSearchPage resultsOfSearchPage;
    ProductPage productPage;

    public void addProductToCart() {
        basePage = new BasePage();
        productPage = new ProductPage();
        resultsOfSearchPage = new ResultsOfSearchPage();
        resultsOfSearchPage.clickOnProductTitle();
        productPage.clickOnAddToCartButton();
    }

    public boolean productPictureIsDisplayed() {
        return productPage.productPictureIsDisplayed();
    }

    public boolean checkMarkIsDisplayed() {
        return productPage.checkMarkIsDisplayed();
    }

    public String successMessage() {
        return productPage.successMessage();
    }

    public int valueOfCountProductsInCart() {
        return productPage.valueOfCountProductsInCart();
    }

    public void clickOnShoppingCart() {
        productPage.clickOnShoppingCart();
    }


}
