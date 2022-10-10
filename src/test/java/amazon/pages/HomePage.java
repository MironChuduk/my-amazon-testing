package amazon.pages;

import org.openqa.selenium.By;
import amazon.common.CommonActions;

public class HomePage extends BasePage {

    private final By searchBox = By.id("twotabsearchtextbox");
    private final By searchButton = By.id("nav-search-submit-button");

    public HomePage() {
        super();
    }

    public void fillSearchBox(String nameOfProduct) {
        CommonActions.waitElementIsVisible(searchBox);
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(nameOfProduct);
    }

    public ResultsOfSearchPage clickOnSearchButton() {
        CommonActions.waitElementIsVisible(searchButton);
        driver.findElement(searchButton).click();
        return new ResultsOfSearchPage();
    }
}
