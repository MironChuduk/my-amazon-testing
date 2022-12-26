package amazon.services;

import amazon.pages.ResultsOfSearchPage;

public class ResultsOfSearchService {
    private ResultsOfSearchPage resultsOfSearchPage;

    public boolean isProductTitleDisplayed() {
        resultsOfSearchPage = new ResultsOfSearchPage();
        return resultsOfSearchPage.isProductTitleDisplayed();
    }

    public ProductService clickOnProductTitle() {
        resultsOfSearchPage = new ResultsOfSearchPage();
        resultsOfSearchPage.clickOnProductTitle();
        return new ProductService();
    }
}
