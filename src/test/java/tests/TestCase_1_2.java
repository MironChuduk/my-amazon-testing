package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.AMAZON_HOME_PAGE;

public class TestCase_1_2 extends BaseTest {

    @Test
    public void checkSearchProducts(){
        basePage.open(AMAZON_HOME_PAGE);

        amazonHomePage.searchProductOnAmazon("iPhone");
        resultsOfSearchPage.checkTitle("iPhone");

    }

}
