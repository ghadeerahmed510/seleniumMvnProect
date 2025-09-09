package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C09_TaskCheckboxIntraction {

    WebDriver driver;

    /*
    : Checkbox Interaction
. Write a method that:
 Checks the current state of both checkboxes
 Ensures both checkboxes are selected (click only if not already selected)
 Verify both checkboxes are checked after the operations
 Print the status of each checkbox to console
     */
    @Test
    public void checkboxInteraction() {
        // driver=new ChromeDriver();
        //  Go to "https://the-internet.herokuapp.com/checkboxes"
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Checks the current state of both checkboxes
        WebElement checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));


        // Ensures both checkboxes are selected (click only if not already selected)
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }

        boolean status1 = checkBox1.isSelected();
        boolean status2 = checkBox2.isSelected();

        // Print the status of each checkbox to console
        System.out.println("checkbox 1 selected: " + status1);
        System.out.println("checkbox 2 selected: " + status1);

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
