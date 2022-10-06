package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) { super(driver); }

    private final By addToCartBtn = By.id("add-to-cart-button");
    private final By addedProductToCartImg = By
            .xpath("//div[@id='add-to-cart-confirmation-image']//img");
    private final By checkMark = By.xpath("//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']//i");
    private final By successMessage = By.xpath("//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']//span");
    private final By cartCount = By.id("nav-cart-count");

    /**
     * The method adds the product to the cart
     */
    public ProductPage addToCart(){
        WebElement btnAddToCart = driver.findElement(addToCartBtn);
        waitElementIsVisible(btnAddToCart).click();

        return this;
    }

    public ProductPage checkProductAddedToCart(String expectedMessage){
        WebElement imgOfAddedProductToCart = driver.findElement(addedProductToCartImg);
        waitElementIsVisible(imgOfAddedProductToCart);

        WebElement greenIcon = driver.findElement(checkMark);
        waitElementIsVisible(greenIcon);

        String actualMessage = driver.findElement(successMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        int countOfProductsInCart = Integer.parseInt(driver.findElement(cartCount).getText());
        Assert.assertEquals(countOfProductsInCart, 1);

        return this;
    }

}
