package amazon.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import static amazon.constants.Constant.MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART;
import static amazon.constants.Constant.NAME_OF_PRODUCT;

public class TestCase1 extends BaseTest {

    @Test
    public void testCase2to4() {
        resultsOfSearchService = homePageService.searchProduct(NAME_OF_PRODUCT);
        Assert.assertTrue(resultsOfSearchService.isProductTitleDisplayed());
        productService.addProductToCart();
        Assert.assertTrue(productService.isProductPictureDisplayed());
        Assert.assertTrue(productService.isCheckMarkDisplayed());
        Assert.assertEquals(productService.successMessage(), MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART);
        Assert.assertEquals(productService.valueOfCountProductsInCart(), 1);
        cartService = productService.clickOnShoppingCart();
        Assert.assertTrue(cartService.isProductTitleDisplayed());

    }
}
