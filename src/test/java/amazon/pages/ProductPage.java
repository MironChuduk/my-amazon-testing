package amazon.pages;

import amazon.common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class ProductPage extends BasePage {

    private final By addToCartButton = By.id("add-to-cart-button");
    private final By productPicture = By.xpath("//div[@id='add-to-cart-confirmation-image']//img");
    private final By checkMark = By.xpath("//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']//i");
    private final By successMessage = By.xpath("//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']//span");
    private final By cartCount = By.id("nav-cart-count");
    private final By cartButton = By.xpath("//span[@id='attach-sidesheet-view-cart-button']//input[@class='a-button-input']");

    public ProductPage() {
        super();
    }

    public void clickOnAddToCartButton() {
        CommonActions.waitElementIsVisible(addToCartButton);
        driver.findElement(addToCartButton).click();
    }

    public boolean isProductPictureDisplayed() {
        CommonActions.waitElementIsVisible(productPicture);
        return driver.findElement(productPicture).isDisplayed();
    }

    public boolean isCheckMarkDisplayed() {
        CommonActions.waitElementIsVisible(checkMark);
        return driver.findElement(checkMark).isDisplayed();
    }

    public String successMessage() {
        CommonActions.waitElementIsVisible(successMessage);
        return driver.findElement(successMessage).getText();
    }

    public int valueOfCountProductsInCart() {
        CommonActions.waitElementIsVisible(cartCount);
        return Integer.parseInt(driver.findElement(cartCount).getText());
    }

    public CartPage clickOnShoppingCart() {
        try {
            CommonActions.waitElementIsVisible(cartButton);
            driver.findElement(cartButton).click();
        } catch (TimeoutException exe) {
            CommonActions.waitElementIsVisible(cartCount);
            driver.findElement(cartCount).click();
        }
        return new CartPage();
    }
}
