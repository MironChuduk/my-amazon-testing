package amazon.tests;

import amazon.listeners.TestListener;
import amazon.services.CartService;
import amazon.services.HomePageService;
import amazon.services.ProductService;
import amazon.services.ResultsOfSearchService;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static amazon.constants.Constant.MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART;
import static amazon.constants.Constant.NAME_OF_PRODUCT;

@Listeners(TestListener.class)
public class TestCase1 extends BaseTest {

    private HomePageService homePageService;
    private ResultsOfSearchService resultsOfSearchService;
    private ProductService productService;
    private CartService cartService;

    @Test
    public void testCase2to4() {
        homePageService = new HomePageService();
        resultsOfSearchService = homePageService.searchProduct(NAME_OF_PRODUCT);
        Assert.assertTrue(resultsOfSearchService.isProductTitleDisplayed());
        productService = new ProductService();
        productService.addProductToCart();
        Assert.assertTrue(productService.isProductPictureDisplayed());
        Assert.assertTrue(productService.isCheckMarkDisplayed());
        Assert.assertEquals(productService.successMessage(), MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART);
        Assert.assertEquals(productService.valueOfCountProductsInCart(), 1);
        cartService = productService.clickOnShoppingCart();
        Assert.assertTrue(cartService.isProductTitleDisplayed());
    }
}
