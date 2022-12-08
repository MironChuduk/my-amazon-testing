package amazon.pages;

import amazon.common.CommonActions;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By addedProductTitle = By
            .xpath("//div[@data-name='Active Items']//span[@class='a-truncate-cut']");
    private final By addedProductPrice = By
            .xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']");

    public CartPage() {
        super();
    }

    public boolean isProductTitleDisplayed() {
        CommonActions.waitElementIsVisible(addedProductTitle);
        return driver.findElement(addedProductTitle).isDisplayed();
    }

    public String getAddedProductTitle() {
        CommonActions.waitElementIsVisible(addedProductTitle);
        return driver.findElement(addedProductTitle).getText();
    }

    public String getAddedProductPrice() {
        CommonActions.waitElementIsVisible(addedProductPrice);
        return driver.findElement(addedProductPrice).getText();
    }
}
