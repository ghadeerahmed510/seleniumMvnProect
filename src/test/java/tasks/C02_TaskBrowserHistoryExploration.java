package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C02_TaskBrowserHistoryExploration {

    WebDriver driver;

    // Use @BeforeEach to launch Chrome and maximize.
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testForward() {
        // Navigate to https://www.wikipedia.org.
        driver.get("https://wikipedia.org");
        assertEquals("Wikipedia", driver.getTitle(), "Title should be Wikipedia");

        // Navigate to https://www.google.com.
        driver.get("https://google.com");
        assertEquals("Google", driver.getTitle(), "Title should be Google");

        // Navigate back and forward multiple times, asserting the correct title at each step.
        driver.navigate().back();
        assertEquals("Wikipedia", driver.getTitle(), "should be back on wikipedia");

        driver.navigate().forward();
        assertEquals("Google", driver.getTitle(), "Should be forward to Google");

        driver.navigate().back();
        assertEquals("Wikipedia", driver.getTitle(), "Back again on Wikipedia");

        driver.navigate().forward();
        assertEquals("Google", driver.getTitle(), "Forward again to Google");
    }


    @Test
    void testRefresh() {
        // Use driver.navigate().refresh() on Google
        driver.get("https://Google.com");
        String titleBeforeRefresh = driver.getTitle();

        driver.navigate().refresh();
        String titleAfterRefresh = driver.getTitle();

        // assert the title still contains "Google".
        assertEquals(titleBeforeRefresh, titleAfterRefresh, "Title should remain same after refresh");
    }

    // Use @AfterEach to close the browser.
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
