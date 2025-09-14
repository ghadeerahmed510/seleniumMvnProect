package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C18_FreePracticeTask extends TestBase {

    /*
    Practice on https://demo.guru99.com/test/newtours/register.php
Apply dropdown and form handling techniques
     */
    @Test
    void freePractice(){

        driver.get("https://demo.guru99.com/test/newtours/register.php");


        driver.findElement(By.name("firstName")).sendKeys("Ali");
        driver.findElement(By.name("lastName")).sendKeys("Ahmed");
        driver.findElement(By.name("phone")).sendKeys("123456789");
        driver.findElement(By.id("userName")).sendKeys("ali@test.com");

        driver.findElement(By.name("address1")).sendKeys("123 Street");
        driver.findElement(By.name("city")).sendKeys("Riyadh");
        driver.findElement(By.name("state")).sendKeys("Central");
        driver.findElement(By.name("postalCode")).sendKeys("11411");

        WebElement countryDropdown = driver.findElement(By.name("country"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText("SAUDI ARABIA"); // أو selectByValue("SAUDI ARABIA")

        driver.findElement(By.id("email")).sendKeys("ali_user");
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.name("confirmPassword")).sendKeys("12345");

        driver.findElement(By.name("submit")).click();

    }
}
