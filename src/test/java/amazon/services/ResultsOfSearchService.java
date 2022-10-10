package amazon.services;

import amazon.pages.ResultsOfSearchPage;

public class ResultsOfSearchService {
    ResultsOfSearchPage resultsOfSearchPage;

    public boolean isProductTitleDisplayed() {
        resultsOfSearchPage = new ResultsOfSearchPage();
        return resultsOfSearchPage.isProductTitleDisplayed();
    }
}
