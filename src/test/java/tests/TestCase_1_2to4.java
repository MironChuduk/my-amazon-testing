package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART;
import static constants.Constant.NAME_OF_PRODUCT;
import static constants.Constant.Urls.AMAZON_HOME_PAGE;

public class TestCase_1_2to4 extends BaseTest {

    @Test
    public void checkSearchProducts(){
        basePage.open(AMAZON_HOME_PAGE);

        amazonHomePage.searchProductOnAmazon(NAME_OF_PRODUCT);
        resultsOfSearchPage
                .checkTitle(NAME_OF_PRODUCT)
                .clickOnProduct();
        productPage
                .addToCart()
                .checkProductAddedToCart(MESSAGE_OF_SUCCESS_ADDITION_PRODUCT_TO_CART)
                .goTnCart();
        cartPage.checkAddedProduct();

    }

}
