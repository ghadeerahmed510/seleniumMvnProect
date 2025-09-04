package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class C02_BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
//
//        //navigate to w3school
        driver.get("https://www.w3schools.com");
//
//        //navigate to stackoverflow
        driver.get("https://www.stackoverflow.com");
//
//        //come back to the w3schools
        Thread.sleep(3000);
        driver.navigate().back();
//
//        //Again go back to the stackoverflow website using forward command
        Thread.sleep(3000);
        driver.navigate().forward();
//
//        //Refresh the Browser using refresh command.
        Thread.sleep(3000);
        driver.navigate().refresh();
//         Close the Browser.
        Thread.sleep(3000);
        driver.close();

    }
}
