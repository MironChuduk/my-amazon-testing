package amazon.services;

import amazon.pages.CartPage;

public class CartService {

    private CartPage cartPage;

    public boolean isProductTitleDisplayed() {
        cartPage = new CartPage();
        return cartPage.isProductTitleDisplayed();
    }
}
