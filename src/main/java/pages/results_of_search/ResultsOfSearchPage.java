package pages.results_of_search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

public class ResultsOfSearchPage extends BasePage {

    public ResultsOfSearchPage(WebDriver driver) { super(driver); }

    private final By titlesOfProducts = By.xpath("//div[contains(@class, 's-title-instructions-style')]");

    // The method checks if the searched product is in the product name on the search results page
    public ResultsOfSearchPage checkTitle(String nameOfProduct){
        String titleOfTheFirstProduct = driver.findElement(titlesOfProducts).getText();
        Boolean result = titleOfTheFirstProduct.contains(nameOfProduct);
        Assert.assertEquals(result, true);

        return this;
    }

}
