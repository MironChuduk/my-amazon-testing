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
    private final By goToCart = By.xpath("//span[@id='sw-gtc']//span");

    /**
     * The method adds the product to the cart
     */
    public ProductPage addToCart(){
        WebElement btnAddToCart = driver.findElement(addToCartBtn);
        waitElementIsVisible(btnAddToCart).click();

        return this;
    }

    /**
     * The method checks if the product picture, green icon, has appeared on the screen.
     * The method also checks correct value of count shopping cart in the top right corner of the page.
     */
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

    /**
     * The method allows you to go to the cart page.
     */
    public ProductPage goTnCart(){
        driver.findElement(goToCart).click();

        return this;
    }

}
