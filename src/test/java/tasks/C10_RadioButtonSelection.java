package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;

public class C10_RadioButtonSelection {
    /*
     Navigate to "https://demoqa.com/radio-button". Create a test that:
 Attempts to select each radio button (Yes, Impressive, No)
 Prints whether each option is enabled/disabled
 For enabled options, select them and verify selection
 Print confirmation message for each successful selection
     */
    static WebDriver driver;

    @Test
    public void radioButtonSelection() {
        //Navigate to "https://demoqa.com/radio-button"


        driver.get("https://demoqa.com/radio-button");


        WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        WebElement impressiveRadio = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        WebElement noRadio = driver.findElement(By.xpath("//label[@for='noRadio']"));

          //handleRadioButton("yesRadio","Yes");

    }


    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}
