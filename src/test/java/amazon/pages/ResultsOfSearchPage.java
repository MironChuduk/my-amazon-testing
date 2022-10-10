package amazon.pages;

import amazon.common.CommonActions;
import org.openqa.selenium.By;

public class ResultsOfSearchPage extends BasePage {

    private final By productTitle = By.xpath("//div[contains(@class, 's-title-instructions-style')]");

    public ResultsOfSearchPage() {
        super();
    }

    public boolean isProductTitleDisplayed() {
        return driver.findElement(productTitle).isDisplayed();
    }

    public ProductPage clickOnProductTitle() {
        CommonActions.waitElementIsVisible(productTitle);
        driver.findElement(productTitle).click();
        return new ProductPage();
    }
}
