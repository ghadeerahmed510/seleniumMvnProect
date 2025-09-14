package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C16_OldStyleSelectMenu extends TestBase {
/*
Launch browser Open https://demoqa.com/select-menu
Select Old Style Select Menu using element id
Print all dropdown options
Select 'Purple' using index
Select 'Magenta' using visible text
Select an option using value
Close browser
 */
    @Test
    void oldStyleSelectMenu(){

        //Launch browser Open https://demoqa.com/select-menu
        driver.get("https://demoqa.com/select-menu");

        //Select Old Style Select Menu using element id
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));

        //Print all dropdown options
        List<WebElement> options = select.getOptions();
        for (WebElement option : options){
            System.out.println(option.getText());
        }

        //Select 'Purple' using index
        select.selectByIndex(5);

        //Select 'Magenta' using visible text
        select.selectByVisibleText("Magenta");

        //Select an option using value
        select.selectByValue("7");
        System.out.println("Selected by value: "+select.getFirstSelectedOption().getText());

    }
}
