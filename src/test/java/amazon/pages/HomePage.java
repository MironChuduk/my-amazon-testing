package amazon.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By searchBox = By.id("twotabsearchtextbox");
    private final By searchButton = By.id("nav-search-submit-button");

    public HomePage() {
        super();
    }

    public void fillSearchBox(String nameOfProduct) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(nameOfProduct);
    }

    public ResultsOfSearchPage clickOnSearchButton() {
        driver.findElement(searchButton).click();

        return new ResultsOfSearchPage();
    }

}
