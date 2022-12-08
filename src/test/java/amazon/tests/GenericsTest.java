package amazon.tests;

import amazon.products.Iphone;
import amazon.products.Television;
import amazon.services.CartService;
import amazon.services.HomePageService;
import amazon.services.ProductService;
import amazon.services.ResultsOfSearchService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static amazon.constants.Constant.IPHONE;
import static amazon.constants.Constant.TELEVISION;

public class GenericsTest extends BaseTest {
    private HomePageService homePageService;
    private ResultsOfSearchService resultsOfSearchService;
    private ProductService productService;
    private CartService cartService;

    @Test
    public void genericsTest() {
        homePageService = new HomePageService();
        resultsOfSearchService = homePageService.searchProduct(IPHONE);
        Assert.assertTrue(resultsOfSearchService.isProductTitleDisplayed());
        productService = new ProductService();
        productService.addProductToCart();
        cartService = productService.clickOnShoppingCart();
        Assert.assertTrue(cartService.isProductTitleDisplayed());
        Iphone expectedIphone = Iphone.getExpectedIphone("iPhone");
        Iphone actualIphone = new Iphone.IphoneBuilder()
                .setIphoneTitle(cartService.getLastTitle())
                .setPrice(cartService.getLastPrice())
                .build();
        Assert.assertTrue(cartService.verifyProduct(expectedIphone, actualIphone));
        resultsOfSearchService = homePageService.searchProduct(TELEVISION);
        productService.addProductToCart();
        cartService = productService.clickOnShoppingCart();
        Assert.assertTrue(cartService.isProductTitleDisplayed());
        Television expectedTelevision = Television.getExpectedTelevision("television");
        Television actualTelevision = new Television.TelevisionBuilder()
                .setTelevisionTitle(cartService.getLastTitle())
                .setPrice(cartService.getLastPrice())
                .build();
        Assert.assertTrue(cartService.verifyProduct(expectedTelevision, actualTelevision));

    }
}
