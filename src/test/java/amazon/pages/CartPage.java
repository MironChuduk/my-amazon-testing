package amazon.pages;

import amazon.common.CommonActions;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By productTitle = By
            .xpath("//div[@data-name='Active Items']//span[@class='a-truncate-cut']");
    private final By productPrice = By
            .xpath("//span[contains(@class, 'sc-product-price')]");

    public CartPage() {
        super();
    }

    public boolean isProductTitleDisplayed() {
        CommonActions.waitElementIsVisible(productTitle);
        return driver.findElement(productTitle).isDisplayed();
    }

    public String getProductTitle() {
        CommonActions.waitElementIsVisible(productTitle);
        return driver.findElement(productTitle).getText();
    }

    public String getProductPrice() {
        CommonActions.waitElementIsVisible(productPrice);
        return driver.findElement(productPrice).getText();
    }
}
