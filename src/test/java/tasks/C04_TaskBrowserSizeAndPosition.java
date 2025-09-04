package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C04_TaskBrowserSizeAndPosition {
    WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    void setBrowserSize(){
        driver.get("https://www.bbc.com");

   //     Dimension dimension =new Dimension(800,600);
    //    driver.manage().window().getSize(dimension);

        Dimension actualSize = driver.manage().window().getSize();
        assertEquals(800,actualSize.getWidth(),"Width should be 800");
        assertEquals(600,actualSize.getHeight(),"Height should be 600");
    }

    @Test
    void setBrowserPosition(){
        Point point = new Point(100,100);
        driver.manage().window().setPosition(point);

        Point actualPosition = driver.manage().window().getPosition();
        assertEquals(100,actualPosition.getX(),"X position should be 100");
        assertEquals(100,actualPosition.getY(),"Y position should be 100");
    }

    @AfterEach
    void tearDown(){
        if (driver !=null){
            driver.quit();
        }
    }
}
