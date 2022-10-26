package amazon.pages;

import amazon.pages.giftCardsPage.GiftCardsPage;
import org.openqa.selenium.By;
import amazon.common.CommonActions;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    private final By searchBox = By.id("twotabsearchtextbox");
    private final By searchButton = By.id("nav-search-submit-button");
    private final By menuItems = By.xpath("//div[@id='nav-xshop']/a[@class='nav-a  ']");
    private final By selectedLanguage = By.id("icp-touch-link-language");
    private final By selectedCurrency = By.id("icp-touch-link-cop");
    private final By giftCardsButton = By.xpath("//a[@data-csa-c-slot-id='nav_cs_3']");
    private final By dontChangeButton = By.xpath("//div[@class='glow-toaster-content']" +
            "//span[@class='a-button-inner']");

    public HomePage() {
        super();
    }

    public void fillSearchBox(String nameOfProduct) {
        CommonActions.waitElementIsVisible(searchBox);
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(nameOfProduct);
    }

    public List<WebElement> findMenuItems() {
        return driver.findElements(menuItems);
    }

    public ResultsOfSearchPage clickOnSearchButton() {
        CommonActions.waitElementIsVisible(searchButton);
        driver.findElement(searchButton).click();
        return new ResultsOfSearchPage();
    }

    public WebElement getSelectedLanguage() {
        return driver.findElement(selectedLanguage);
    }

    public WebElement getSelectedCurrency() {
        return driver.findElement(selectedCurrency);
    }

    public GiftCardsPage clickOnGiftCardsButton() {
        driver.findElement(dontChangeButton).click();
        driver.findElement(giftCardsButton).click();
        return new GiftCardsPage();
    }
}
