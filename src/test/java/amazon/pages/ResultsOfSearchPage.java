package amazon.pages;

import org.openqa.selenium.By;

public class ResultsOfSearchPage extends BasePage {

    private final By productTitle = By.xpath("//div[contains(@class, 's-title-instructions-style')]");

    public ResultsOfSearchPage() {
        super();
    }

    public boolean productTitleIsDisplayed() {
        return driver.findElement(productTitle).isDisplayed();
    }

    public ProductPage clickOnProductTitle() {
        driver.findElement(productTitle).click();
        return new ProductPage();
    }

}
