package pages.signin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

import static constants.Constant.User.*;

public class SignIn extends BasePage {
    public SignIn(WebDriver driver) { super(driver); }

    private final By emailInput = By.id("ap_email");
    private final By passwordInput = By.id("ap_password");
    private final By continueButton = By.id("continue");
    private final By signInButton = By.id("signInSubmit");
    private final By welcomeLine = By.id("nav-link-accountList-nav-line-1");

    public SignIn signIn(){
        driver.findElement(emailInput).sendKeys(USER_EMAIL);
        driver.findElement(continueButton).click();
        driver.findElement(passwordInput).sendKeys(USER_PASSWORD);
        driver.findElement(signInButton).click();

        return this;
    }

    public SignIn checkSuccessfulLogin(){
        String accountName = driver.findElement(welcomeLine).getText();
        Assert.assertEquals(accountName, "Hello, " + USER_NAME);
        return this;

    }

}
