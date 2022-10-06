package pages.amazon_home;

import org.openqa.selenium.*;
import pages.base.BasePage;

public class AmazonHomePage extends BasePage {

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    private final By signInButton = By.xpath("//a[@id='nav-link-accountList']");
    private final By searchBoxInput = By.id("twotabsearchtextbox");
    private final By btnSearch = By.id("nav-search-submit-button");

    // The method allows you to go to the SignIn page
    public AmazonHomePage clickToSignIn(){
        driver.findElement(signInButton).click();

        return this;
    }

    public AmazonHomePage searchProductOnAmazon(String searchProduct){
        driver.findElement(searchBoxInput).sendKeys(searchProduct);
        driver.findElement(btnSearch).click();

        return this;
    }


}
