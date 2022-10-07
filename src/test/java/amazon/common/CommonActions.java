package amazon.common;

import amazon.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static amazon.constants.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class CommonActions {

    public static void waitElementIsVisible(By locator) {
        new WebDriverWait(BaseTest.getWebDriverInstance(), EXPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
