package amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static amazon.constants.Constant.MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART;
import static amazon.constants.Constant.NAME_OF_PRODUCT;

public class TestCase1 extends BaseTest {

    @Test
    public void testCase2to4() {
        homePageService.searchProduct(NAME_OF_PRODUCT);
        Assert.assertTrue(resultsOfSearchService.productTitleIsDisplayed());
        productService.addProductToCart();
        Assert.assertTrue(productService.productPictureIsDisplayed());
        Assert.assertTrue(productService.checkMarkIsDisplayed());
        Assert.assertEquals(productService.successMessage(), MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART);
        Assert.assertEquals(productService.valueOfCountProductsInCart(), 1);
        productService.clickOnShoppingCart();
        Assert.assertTrue(cartService.productTitleIsDisplayed());

    }


}
