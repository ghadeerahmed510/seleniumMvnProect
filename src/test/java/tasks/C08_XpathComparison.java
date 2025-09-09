package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08_XpathComparison {
    WebDriver driver;

    @Test
    public void xPathComparison(){
        driver = new ChromeDriver();

        // Navigate to: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // TODO: Locate username using absolute XPath
        String absoluteUsernameXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input";// Fill absolute path
        String absolutePasswordXPath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input";

        // TODO: Locate username using relative XPath
        String relativeUsernameXPath =  "//input[@name='username']";// Fill relative path

        // TODO: Locate password using both methods
        String relativePasswordXPath = "//input[@name='password']";

        // TODO: Locate login button using both methods
        String relativeLoginXPath = "//button[@type='submit']";

        // TODO: Test both approaches work
        WebElement usernameAbsolute = driver.findElement(By.xpath(absoluteUsernameXPath));
        WebElement usernameRelative = driver.findElement(By.xpath(relativeUsernameXPath));

        Assertions.assertTrue(usernameAbsolute.isDisplayed());
        Assertions.assertTrue(usernameRelative.isDisplayed());

        driver.quit();
    }
}

