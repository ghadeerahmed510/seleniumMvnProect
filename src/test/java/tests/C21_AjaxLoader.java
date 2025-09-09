package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C21_AjaxLoader {
    /*
        Given: Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        When: Click on Ajax Loader
        And: Click "Click Me!" button
        Then: Assert button is clicked
     */

    @Test
    void ajaxLoaderTest() {
//        Given: Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
//        When: Click on Ajax Loader
        driver.findElement(By.xpath("//a[@href='../Ajax-Loader/index.html']")).click();
//        And: Click "Click Me!" button
        WebElement element = driver.findElement(By.xpath("//p[.='CLICK ME!']"));
        element.click();
//        Then: Assert button is clicked

    }


    WebDriver driver;

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