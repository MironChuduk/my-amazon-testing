package amazon.services;

import amazon.pages.CartPage;
import amazon.products.Iphone;
import amazon.products.Product;
import amazon.products.Television;

public class CartService<T> {

    private CartPage cartPage;

    public boolean isProductTitleDisplayed() {
        cartPage = new CartPage();
        return cartPage.isProductTitleDisplayed();
    }

    public <T extends Product> T getObjectFromPage(Class<T> name) {
        if (name == Iphone.class) {
            return (T) new Iphone.Builder()
                    .title(cartPage.getProductTitle())
                    .price(cartPage.getProductPrice())
                    .size(cartPage.getProductSize())
                    .build();
        } else {
            return (T) new Television.Builder()
                    .title(cartPage.getProductTitle())
                    .price(cartPage.getProductPrice())
                    .qty(cartPage.getProductQty())
                    .build();
        }
    }

    public boolean verifyProduct(T expectedProduct, T actualProduct) {
        return expectedProduct.equals(actualProduct);
    }
}
