package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C14_PopupAlert extends TestBase {
    /*
    Given: Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
 When: Click on Ajax Loader
 And: Click "Click Me!" button
 Then: Assert button is clicked
     */
    @Test
    public void testAjaxLoaderClickMeButton() {
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        // 1. اضغط على Ajax Loader
        WebElement ajaxLoaderLink = driver.findElement(By.id("button3"));
        ajaxLoaderLink.click();

        // 🔄 التحويل على النافذة الجديدة
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // 2. انتظر حتى يظهر زر Click Me!
        WebElement clickMeButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("button1"))
        );

        // 3. اضغط الزر
        clickMeButton.click();

        // 4. تحقق أن alert ظهر بعد الضغط
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert appeared with text: " + alertText);

        assertTrue(alertText.contains("Well Done"), "Alert text should confirm button click!");

        // إغلاق الـ alert
        driver.switchTo().alert().accept();
    }
}
