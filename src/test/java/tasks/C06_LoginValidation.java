package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_LoginValidation {

    WebDriver driver;

    @Test
    public void testInvalidLogin(){
        driver = new ChromeDriver();

        // TODO: Navigate to Heroku login
        driver.get("https://id.heroku.com/login");


        // TODO: Enter test email
        driver.findElement(By.id("email")).sendKeys("test@example.com");

        // TODO: Enter test password
        driver.findElement(By.id("password")).sendKeys("wrongpassword");


        // TODO: Click login button
        driver.findElement(By.name("commit")).click();

        // TODO: Check for error message
        try{
            WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'There was a problem')]"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Registration Failed");
            }
        } catch (NoSuchElementException e){
            System.out.println("Registered");
        }

        // TODO: Print appropriate success/failure message

        driver.quit();
    }
}
