package amazon.services;

import amazon.pages.BasePage;
import amazon.pages.HomePage;

public class HomePageService {

    BasePage basePage;
    HomePage homePage;

    public void searchProduct(String productName) {
        basePage = new BasePage();
        homePage = new HomePage();
        homePage.fillSearchBox(productName);
        homePage.clickOnSearchButton();

    }


}
