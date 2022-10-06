package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.AMAZON_HOME_PAGE;

public class TestCase_1_1 extends BaseTest {

    @Test(enabled = false)
    public void checkAuthorization(){
        basePage.open(AMAZON_HOME_PAGE);

        amazonHomePage.clickToSignIn();

        signIn
                .signIn();
                //.checkSuccessfulLogin();

    }


}
