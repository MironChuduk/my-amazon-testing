package amazon.pages.giftCardsPage;

import amazon.common.CommonActions;
import amazon.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GiftCardsPage extends BasePage {
    private final By sortButton = By.xpath("//span[text()='Sort by:']");
    private final By resultItems = By.xpath("//div[contains(@class, 'a-spacing-base')]");

    public GiftCardsPage() {
        super();
    }

    public void clickOnFormatCheckbox(String formatName) {
        driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", formatName))).click();
    }

    public void clickOnBrandName(String brandName) {
        driver.findElement(By.xpath(String.format("//li[@id='p_89/%s']/span", brandName))).click();
    }

    public void clickOnPrice(String price) {
        driver.findElement(By.xpath(String.format("//span[text()='%s']", price))).click();
    }

    public void clickToSort() {
        driver.findElement(sortButton).click();
    }

    public void sort(String sortArgument) {
        driver.findElement(By.xpath(String.format("//ul[@tabindex='-1']//a[text()='%s']", sortArgument))).click();
    }

    public List<WebElement> getResultItems() {
        return driver.findElements(resultItems);
    }

    public String getTitle(WebElement parentElement) {
        By title = By.xpath(".//h2");
        CommonActions.waitElementIsVisible(title);
        return parentElement.findElement(title).getText();
    }

    public String getMinPrice(WebElement parentElement) {
        By priceRange = By.xpath(".//span[@class='a-price-whole']");
        CommonActions.waitElementIsVisible(priceRange);
        return parentElement.findElement(priceRange).getText();
    }
}
