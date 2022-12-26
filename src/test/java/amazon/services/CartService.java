package amazon.services;

import amazon.pages.CartPage;

public class CartService<T> {

    private CartPage cartPage;

    public boolean isProductTitleDisplayed() {
        cartPage = new CartPage();
        return cartPage.isProductTitleDisplayed();
    }

    public String getLastTitle() {
        return cartPage.getProductTitle();
    }

    public String getLastPrice() {
        return cartPage.getProductPrice();
    }

    public boolean verifyProduct(T expectedProduct, T actualProduct) {
        return expectedProduct.equals(actualProduct);
    }
}
