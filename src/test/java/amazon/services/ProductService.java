package amazon.services;

import amazon.pages.ProductPage;
import amazon.pages.ResultsOfSearchPage;

public class ProductService {
    private ResultsOfSearchPage resultsOfSearchPage;
    private ProductPage productPage;

    public void addProductToCart() {
        productPage = new ProductPage();
        resultsOfSearchPage = new ResultsOfSearchPage();
        resultsOfSearchPage.clickOnProductTitle();
        productPage.clickOnAddToCartButton();
    }

    public boolean isProductPictureDisplayed() {
        return productPage.isProductPictureDisplayed();
    }

    public boolean isCheckMarkDisplayed() {
        return productPage.isCheckMarkDisplayed();
    }

    public String successMessage() {
        return productPage.successMessage();
    }

    public int valueOfCountProductsInCart() {
        return productPage.valueOfCountProductsInCart();
    }

    public CartService clickOnShoppingCart() {
        productPage.clickOnShoppingCart();
        return new CartService();
    }
}
