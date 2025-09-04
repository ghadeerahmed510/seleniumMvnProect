package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_MinimizeWindow {

    public static void main(String[] args) throws InterruptedException {

        // Invoke Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open URL: https: https://www.google.com/
        driver.get("https://www.google.com/");
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        // Maximize the window.
        driver.manage().window().maximize();
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        // Print the position and size of the page.
        // Minimize the page.
        // Wait 7 seconds in the icon state and maximize the page.
        // Print the position and dimensions of the page in maximized state.
        // Make the page fullscreen.

        // Close the Browser.
        Thread.sleep(3000);
        driver.quit();


    }
}