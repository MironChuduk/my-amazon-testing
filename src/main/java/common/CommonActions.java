package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

import static common.Config.INCOGNITO_MODE;
import static common.Config.PLATFORM_AND_BROWSER;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {

    public static WebDriver createDriver () {

        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) {
            case "mac_chrome":
                if (INCOGNITO_MODE){
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--incognito");
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                    driver = new ChromeDriver(options);
                } else {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                    driver = new ChromeDriver();
                }
                break;
            default:
                Assert.fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }

}
