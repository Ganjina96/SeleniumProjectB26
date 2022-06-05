package com.cydeo.test.day7_testNG_dropdown_alert_iframe;
import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T2_StateDropdown {
    //TC #2: Selecting state from State dropdown and verifying result
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void stateDropdownTest() throws InterruptedException {
        Select stateDropdown = new Select(driver.findElement(By.id("state")));

        //3. Select Illinois
        Thread.sleep(3000);
       stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        Thread.sleep(3000);
        stateDropdown.selectByValue("VA");

        //5. Select California
        Thread.sleep(3000);
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        String actual = stateDropdown.getFirstSelectedOption().getText();
        String expected = "California";
        Assert.assertEquals(actual,expected,"Wrong state selected");
        //Use all Select options. (visible text, value, index)
    }

    @Test
    public void multipleSelect() throws InterruptedException {
//        TC #3: Selecting value from multiple select dropdown
//        3.Select all the options from multiple select dropdown.
        Select allOptions = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        // isMultiple() method will be true if dropdown menu is multiselect option
        System.out.println("allOptions.isMultiple() = " + allOptions.isMultiple());

//        allOptions.selectByValue("java");
//        allOptions.selectByVisibleText("C#");
//        allOptions.selectByIndex(3);

//        4. Print out all selected values.
        // getOptions() method will return to all options
        List<WebElement> languages = allOptions.getOptions();

        for(WebElement each : allOptions.getOptions()){
            each.click();
            Thread.sleep(3000);
            System.out.println(each.getText());
        }

//        5. Deselect all values.
        Thread.sleep(3000);
        allOptions.deselectAll();

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
