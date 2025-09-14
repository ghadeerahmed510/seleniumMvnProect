package tasks;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C14_GrowingClickableElement extends TestBase {
/*
Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
Click "click me" button
Verify "Event Triggered" appears
 */
    @Test
    void growingClickableElementTest(){

        //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

        //Click "click me" button
        driver.findElement(By.id("growbutton")).click();

        //Verify "Event Triggered" appears
        String dd = driver.findElement(By.id("growbuttonstatus")).getText();

        Assertions.assertTrue(dd.contains("Event Triggered"));
    }
}
