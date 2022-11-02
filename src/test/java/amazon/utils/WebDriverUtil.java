package amazon.utils;

import amazon.tests.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class WebDriverUtil {
    public static void takeScreenshot(String nameOfTest) {
        try {
            WebDriver driver = BaseTest.getWebDriverInstance();

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target/screenshots/screenshot" + nameOfTest + ".png"));
            System.out.println("Screenshot is taken");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
