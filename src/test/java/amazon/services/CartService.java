package amazon.services;

import amazon.pages.BasePage;
import amazon.pages.CartPage;
import amazon.pages.ProductPage;

public class CartService {

    BasePage basePage;
    CartPage cartPage;
    ProductPage productPage;

    public boolean productTitleIsDisplayed() {
        basePage = new BasePage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        return cartPage.productTitleIsDisplayed();
    }

}
