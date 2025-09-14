package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C13_TaskCalculatorOprations extends TestBase {
/*
Go to https://testpages.eviltester.com/styled/calculator
 Type any number in first and second input
 Click Calculate for each operation
 Get and verify results for all operations

    public void calculatorOprations(){
        driver.get("https://testpages.eviltester.com/styled/calculator");


    }

 */

    private void performCalculation(String operation, int num1, int num2, double expected) {
        driver.get("https://testpages.eviltester.com/styled/calculator");
        // تحديد عناصر الإدخال
        WebElement firstInput = driver.findElement(By.id("number1"));
        WebElement secondInput = driver.findElement(By.id("number2"));
        WebElement calculateButton = driver.findElement(By.id("calculate"));

        // إدخال الأرقام
        firstInput.clear();
        firstInput.sendKeys(String.valueOf(num1));
        secondInput.clear();
        secondInput.sendKeys(String.valueOf(num2));

        // اختيار العملية من القائمة
        WebElement select = driver.findElement(By.id("function"));
        select.findElement(By.xpath("//option[@value='" + operation + "']")).click();

        // الضغط على زر Calculate
        calculateButton.click();

        // قراءة النتيجة
        WebElement answer = driver.findElement(By.id("answer"));
        double actualResult = Double.parseDouble(answer.getText());//Integer.parseInt(answer.getText());

        // تحقق
        assertEquals(expected, actualResult, "❌ " + operation + " calculation failed!");
        System.out.println("✅ " + operation + " passed: " + num1 + " and " + num2 + " = " + actualResult);
    }

    @Test
    public void testAllOperations() {
        performCalculation("plus", 10, 5, 15);      // 10 + 5 = 15
        performCalculation("minus", 10, 5, 5);      // 10 - 5 = 5
        performCalculation("times", 10, 5, 50);     // 10 * 5 = 50
        performCalculation("divide", 10, 5, 2);
    }
}