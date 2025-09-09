package tasks;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C12_DynamicListManagement {
    /*
    Go to "
 http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:
 Uses Faker to generate 5 random task names
 Adds all tasks to the todo list
 Marks every other task as completed (strikethrough)
Deletes all completed tasks
 Verifies only incomplete tasks remain
     */
    static WebDriver driver;
    static Faker faker;

    @Test
    public void todoList() {
        List<String> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tasks.add(faker.book().title());
        }

        WebElement inputBox = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));
        WebElement addButton = driver.findElement(By.id("plus-icon"));

        for (String task : tasks) {
            inputBox.sendKeys(task);
            addButton.click();
        }

        List<WebElement> allTasks = driver.findElements(By.cssSelector("#container li"));
        assertEquals(5, allTasks.size(), "Expected 5 tasks in the list");

        for (int i = 0; i < allTasks.size(); i++) {
            if (i % 2 == 0) {
                allTasks.get(i).click();
            }
        }


        allTasks = Collections.singletonList(driver.findElement(By.cssSelector("#container li")));
        for (WebElement task : allTasks) {
            if (task.getAttribute("class").contains("completed")) {

                task.findElement(By.tagName("span")).click();
            }
        }
        List<WebElement> remainingTasks = driver.findElements(By.cssSelector("#container li"));
        assertEquals(2, remainingTasks.size(), "Only 2 incomplete tasks should remain");
        System.out.println("Only incomplete tasks remain in the list");
    }

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Go to "https://demoqa.com/text-box".
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        faker = new Faker();
    }

    @AfterAll
    static void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

}