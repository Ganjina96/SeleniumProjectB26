package com.cydeo.test.aysun_hw.day7_hw;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectDate_Dropdown {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void dateDropdownTest(){
        // 3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.id("year")));
        Select monthDropDown = new Select(driver.findElement(By.id("month")));
        Select dayDropdown = new Select(driver.findElement(By.id("day")));

        for (WebElement eachYearOption : yearDropdown.getOptions()){
            System.out.println(eachYearOption.getText());
        }

        //Select year using   : visible text
        yearDropdown.selectByVisibleText("1923");
        //Select month using  : value attribute Select
        monthDropDown.selectByValue("11");
        //day using : index number
        dayDropdown.selectByIndex(0);

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropDown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        Assert.assertEquals(actualYear,expectedYear, "Wrong year");
        Assert.assertEquals(actualMonth,expectedMonth, "Wrong month");
        Assert.assertEquals(actualDay,expectedDay,"Wrong day");
                                   // OR
        Assert.assertTrue(actualYear.equals(expectedYear), "Wrong year");
        Assert.assertTrue(actualMonth.equals(expectedMonth), "Wrong month");
        Assert.assertTrue(actualDay.equals(expectedDay), "Wrong day");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
