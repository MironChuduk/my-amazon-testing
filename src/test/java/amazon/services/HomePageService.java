package amazon.services;

import amazon.pages.HomePage;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageService {

    private HomePage homePage;

    public ResultsOfSearchService searchProduct(String productName) {
        homePage = new HomePage();
        homePage.fillSearchBox(productName);
        homePage.clickOnSearchButton();
        return new ResultsOfSearchService();
    }

    public List<String> listOfItemTitles() {
        homePage = new HomePage();
        return homePage.findMenuItems().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getSelectedLanguage() {
        homePage = new HomePage();
        return homePage.getSelectedLanguage().getText();
    }

    public String getSelectedCurrency() {
        homePage = new HomePage();
        return homePage.getSelectedCurrency().getText();
    }

    public void goToGiftCardsPage() {
        homePage = new HomePage();
        homePage.clickOnGiftCardsButton();
    }
}
