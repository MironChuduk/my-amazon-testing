package amazon.services;

import amazon.pages.HomePage;

public class HomePageService {

    HomePage homePage;

    public ResultsOfSearchService searchProduct(String productName) {
        homePage = new HomePage();
        homePage.fillSearchBox(productName);
        homePage.clickOnSearchButton();
        return new ResultsOfSearchService();
    }

}
