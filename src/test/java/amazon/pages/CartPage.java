package amazon.pages;

import amazon.common.CommonActions;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By productTitle = By
            .xpath("//div[@data-name='Active Items']//span[@class='a-truncate-cut']");
    private final By productPrice = By
            .xpath("//span[contains(@class, 'sc-product-price')]");
    private final By productSize = By
            .xpath("//li[@class='sc-product-variation']//span[@class='a-size-small']");
    private final By productQty = By.xpath("//span[@class='a-dropdown-prompt']");

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

    public String getProductSize() {
        CommonActions.waitElementIsVisible(productSize);
        return driver.findElement(productSize).getText();
    }

    public String getProductQty() {
        CommonActions.waitElementIsVisible(productQty);
        return driver.findElement(productQty).getText();
    }
}
