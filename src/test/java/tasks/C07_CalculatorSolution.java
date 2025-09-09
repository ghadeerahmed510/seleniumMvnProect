package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_CalculatorSolution {
    WebDriver driver;

    @Test
    public void calculator() {
        driver = new ChromeDriver();

        // TODO: Navigate to test pages
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // TODO: Click on Simple Calculator
        driver.findElement(By.linkText("Simple Calculator")).click();

        // TODO: Enter first number
        driver.findElement(By.id("number1")).sendKeys("10");

        // TODO: Enter second number
        driver.findElement(By.id("number2")).sendKeys("5");

        // TODO: Click Calculate
        driver.findElement(By.id("calculate")).click();

        // TODO: Get and print result
        WebElement result = driver.findElement(By.id("answer"));
        System.out.println("Result: " + result.getAttribute("value"));

        driver.quit();
    }
}
