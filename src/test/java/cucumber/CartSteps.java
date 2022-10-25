package cucumber;

import amazon.services.CartService;
import amazon.services.ProductService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static amazon.constants.Constant.MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART;

public class CartSteps {
    private ProductService productService;
    private CartService cartService;

    @And("I add product to cart")
    public void addProductToCart() {
        productService = new ProductService();
        productService.addProductToCart();
    }

    @Then("Verify if product is added to cart")
    public void productIsAddedToCart() {
        Assert.assertTrue(productService.isProductPictureDisplayed());
        Assert.assertTrue(productService.isCheckMarkDisplayed());
        Assert.assertEquals(productService.successMessage(), MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART);
        Assert.assertEquals(productService.valueOfCountProductsInCart(), 1);
    }

    @And("I open cart page")
    public void openCartPage() {
        cartService = productService.clickOnShoppingCart();
    }

    @Then("Verify is product displayed on cart page")
    public void productIsInCart() {
        Assert.assertTrue(cartService.isProductTitleDisplayed());
    }
}
