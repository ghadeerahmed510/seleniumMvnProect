package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_BasicNavigation2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Go to www.yahoo.com
        driver.get("https://www.yaho.com");
        Thread.sleep(3000);
// Maximize Window
        driver.manage().window().maximize();
        Thread.sleep(3000);

        String title1 = driver.getTitle();
        if (title1.contains("yahoo")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
// Go to www.amazon.com
        driver.get("https://www.amazon.com");

// Maximize Window
        driver.manage().window().maximize();


        Thread.sleep(3000);
        String title2 = driver.getTitle();
        if(title2.contains("amazon")) {
            System.out.println("PASS");
        } else{
            System.out.println("FAIL");
        }


// Navigate Back
        driver.navigate().back();

// Navigate Forward
        Thread.sleep(3000);
        driver.navigate().forward();

// Refresh The Page
        Thread.sleep(3000);
        driver.navigate().refresh();

    }
}

