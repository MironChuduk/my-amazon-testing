package pages.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) { super(driver); }

    private final By addedProductTitle = By
            .xpath("//div[@data-name='Active Items']//span[@class='a-truncate-cut']");

    /**
     * The method checks whether the item added to the cart is displayed on the screen
     */
    public CartPage checkAddedProduct(){
        WebElement titleOfAddedToCartProduct = driver.findElement(addedProductTitle);
        waitElementIsVisible(titleOfAddedToCartProduct);

        return this;
    }

}
