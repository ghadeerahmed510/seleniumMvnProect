package tasks;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class C01_Task {
    public static void main(String[] args) throws InterruptedException {

        // Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

// Go to https://www.youtube.com/
        driver.get("https://www.youtube.com");

// Maximize the window
        driver.manage().window().maximize();


// Verify the page title contains the word video.
        @Nullable
        String titlePage = driver.getTitle();
        System.out.println("title Of The Page = " + titlePage);
        if (titlePage.contains("video")) System.out.println("It contains the word 'video'");
        else System.out.println("It does not contain the word 'video' ");

// Minimize the window
        driver.manage().window().minimize();

// Verify the page title contains the word video.
        titlePage = driver.getTitle();
        System.out.println("titleOfThePage = " + titlePage);

        if (titlePage.contains("video"))
            System.out.println("It contains the word 'video'");
        else System.out.println("It does not contain the word 'video'");

// Make the page fullscreen
        driver.manage().window().fullscreen();

        // Close the driver.
        Thread.sleep(2000);
        driver.close();
    }
}
