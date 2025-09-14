package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C15_BasicDropDownOpreration extends TestBase {

    /*
    Go to https://the-internet.herokuapp.com/dropdown
Create selectByIndexTest method - Select Option 1 using index
Create selectByValueTest method - Select Option 2 by value
Create selectByVisibleTextTest method - Select Option 1 by visible text
Create printAllTest method - Print all dropdown values
Verify dropdown has Option 2 text
Create printFirstSelectedOptionTest - Print first selected option
Verify dropdown size equals 3 elements
     */
    @Test
    void basicDropDownOpreration() throws InterruptedException {

        //Go to https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //WebElement dropdown = driver.findElement(By.id("dropdown"));
        WebElement dropdowns = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

        //Create selectByIndexTest method - Select Option 1 using index
        dropdown.selectByIndex(1);

        //Create selectByValueTest method - Select Option 2 by value
        dropdown.selectByValue("2");

        //Create selectByVisibleTextTest method - Select Option 1 by visible text
        dropdown.selectByVisibleText("Option 1");


        //Create printAllTest method - Print all dropdown values

        //System.out.println(selectedOption);

        //Verify dropdown has Option 2 text

        // new Select(driver.findElement(By.id("dropdown"))).selectByVisibleText("Option 2");
        //  assert driver.findElement(By.id("dropdown")).se

        // String ff = String.valueOf(driver.findElement(By.xpath("//option[@value='2']")));
        //Assertions.assertEquals("Option 2",ff);

        //Create printFirstSelectedOptionTest - Print first selected option
        WebElement firstOption = dropdown.getFirstSelectedOption();
        System.out.println(firstOption.getText());

        //Verify dropdown size equals 3 elements
        //    WebElement allSelected = dropdown.getAllSelectedOptions();
        List<WebElement> selectedOption = dropdown.getAllSelectedOptions();
        int actualSize = selectedOption.size();
        System.out.println("All dropdown values: " + actualSize);
        //System.out.println(selectedOption.size());
    }
}
