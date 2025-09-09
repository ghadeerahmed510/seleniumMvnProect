package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C11_TaskFakerDataFormFiling {

    /*
     Use Java Faker to:
      Generate and enter a fake full name
    Generate and enter a fake email address
    Generate and enter a fake current address
    Generate and enter a fake permanent address
    Submit the form and verify the output contains the entered data
     */

    WebDriver driver;
    Faker faker;
    private static String fullName;
    private static String email;
    private static String currentAddress;
    private static String permanentAddress;

@Test
public void fakerDataForm(){
    driver.findElement(By.id("userName")).sendKeys(fullName);
    driver.findElement(By.id("userEmail")).sendKeys(email);
    driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
    driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);

    driver.findElement(By.id("submit")).click();

    WebElement output = driver.findElement(By.id("output"));
    String outputText = output.getText();

    assertTrue(outputText.contains(fullName),"Full name not found in output!");
    assertTrue(outputText.contains(email),"Email not found in output");
    assertTrue(outputText.contains(currentAddress),"current Address not found in output");
    assertTrue(outputText.contains(permanentAddress),"permanent Address not found in output");
//permanentAddress-wrapper
    System.out.println("All data matched in the output");
}

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Go to "https://demoqa.com/text-box".
        driver.get( "https://demoqa.com/text-box");

        faker = new Faker();
        fullName= faker.name().fullName();
        email = faker.internet().emailAddress();
        currentAddress = faker.address().fullAddress();
        permanentAddress = faker.address().secondaryAddress();

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}
