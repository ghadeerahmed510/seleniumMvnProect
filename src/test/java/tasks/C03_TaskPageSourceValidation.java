package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C03_TaskPageSourceValidation {
    WebDriver driver;

//    @BeforeEach to open Chrome and maximize.
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }



    @Test
    void seleniumPageSource() {

        //Navigate to https://www.selenium.dev.
        driver.get("https://selenium.dev");

        //Verify that the page source contains the word "WebDriver".
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("WebDriver"), "Page source should contain the word 'WebDriver'");
    }

    @Test
    void pythonPageSource() {
        //Navigate to https://www.python.org.
        driver.get("https://python.org");

        //Assert the page source contains "Python".
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Python"), "Page source should contain the word 'Python' ");
    }

    //Close the browser with @AfterEach.
    @AfterEach
    void teaDown() {
        if (driver != null) {
            driver.quit();

        }
    }
}
