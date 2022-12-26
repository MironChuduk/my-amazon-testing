package amazon.tests;

import amazon.products.Iphone;
import amazon.products.Product;
import amazon.products.Television;
import amazon.services.CartService;
import amazon.services.HomePageService;
import amazon.services.ProductService;
import amazon.services.ResultsOfSearchService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GenericsTest extends BaseTest {
    private HomePageService homePageService;
    private ResultsOfSearchService resultsOfSearchService;
    private ProductService productService;
    private CartService cartService;

    @Test
    public void genericsTest() {
        homePageService = new HomePageService();
        String IPHONE = "iPhone 11 pro";
        resultsOfSearchService = homePageService.searchProduct(IPHONE);
        Assert.assertTrue(resultsOfSearchService.isProductTitleDisplayed());
        productService = resultsOfSearchService.clickOnProductTitle();
        productService.addProductToCart();
        cartService = productService.clickOnShoppingCart();
        Assert.assertTrue(cartService.isProductTitleDisplayed());
        Product expectedIphone = Iphone.getExpectedObject("iPhone");
        Product actualIphone = cartService.getObjectFromPage(Iphone.class);
        System.out.println(expectedIphone);
        System.out.println(actualIphone);
        System.out.println(expectedIphone.getClass());
        System.out.println(actualIphone.getClass());
        Assert.assertTrue(cartService.verifyProduct(expectedIphone, actualIphone));
        String TELEVISION = "SANSUI ES24T1H, 24 inch LED TV HD 720P with HDMI USB AV in Optical Ports (Packed with HDMI Cable)";
        resultsOfSearchService = homePageService.searchProduct(TELEVISION);
        productService = resultsOfSearchService.clickOnProductTitle();
        productService.addProductToCart();
        cartService = productService.clickOnShoppingCart();
        Assert.assertTrue(cartService.isProductTitleDisplayed());
        Product actualTelevision = cartService.getObjectFromPage(Television.class);
        Product expectedTelevision = Television.getExpectedObject("television");
        System.out.println(expectedTelevision);
        System.out.println(actualTelevision);
        System.out.println(expectedTelevision.getClass());
        System.out.println(actualTelevision.getClass());
        Assert.assertTrue(cartService.verifyProduct(expectedTelevision, actualTelevision));
    }
}
