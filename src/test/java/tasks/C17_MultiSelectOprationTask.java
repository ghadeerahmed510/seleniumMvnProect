package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C17_MultiSelectOprationTask extends TestBase {
    /*
    Launch browser
Open https://demoqa.com/select-menu
Select Standard Multi-Select using element id
Verify element is multi-select
Select 'Opel' using index, then deselect using index
Select 'Saab' using value, then deselect using value
Deselect all options
Close browser
     */

    @Test
    void mMultiSelectOprationTask(){

        //Open https://demoqa.com/select-menu
        driver.get("https://demoqa.com/select-menu");

        //Select Standard Multi-Select using element id
        Select select = new Select(driver.findElement(By.id("cars")));

        //Verify element is multi-select
        Assertions.assertTrue(select.isMultiple(),"Dropdown allow multiple selections");

        //Select 'Opel' using index, then deselect using index
        select.selectByIndex(2);
        select.deselectByIndex(2);

        //Select 'Saab' using value, then deselect using value
        select.selectByValue("saab");
        select.deselectByValue("saab");

        //Deselect all options
        select.deselectAll();
    }
}
