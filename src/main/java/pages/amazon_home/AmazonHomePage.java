package pages.amazon_home;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.base.BasePage;

import java.util.List;

public class AmazonHomePage extends BasePage {

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    private final By signInButton = By.xpath("//a[@id='nav-link-accountList']");
    private final By searchBoxInput = By.id("twotabsearchtextbox");

    // The method allows you to go to the SignIn page
    public AmazonHomePage clickToSignIn(){
        driver.findElement(signInButton).click();

        return this;
    }


}
