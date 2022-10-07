package amazon.pages;

import amazon.common.CommonActions;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By addedProductTitle = By
            .xpath("//div[@data-name='Active Items']//span[@class='a-truncate-cut']");

    public CartPage() {
        super();
    }

    public boolean productTitleIsDisplayed() {
        CommonActions.waitElementIsVisible(addedProductTitle);
        return driver.findElement(addedProductTitle).isDisplayed();
    }


}
