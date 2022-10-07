package amazon.services;

import amazon.pages.BasePage;
import amazon.pages.ResultsOfSearchPage;

public class ResultsOfSearchService {

    BasePage basePage;
    ResultsOfSearchPage resultsOfSearchPage;

    public boolean productTitleIsDisplayed() {
        basePage = new BasePage();
        resultsOfSearchPage = new ResultsOfSearchPage();
        return resultsOfSearchPage.productTitleIsDisplayed();
    }

}
