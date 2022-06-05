package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Simple_DropDown {
//    TC #1: Verifying “Simple dropdown” and “State selection” dropdown default values

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
    public void simpleDropdownTest(){
        //3. Verify “Simple dropdown” default selected value is correct
//           Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));
        String actualDefault = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefault = "Please select an option!";
        Assert.assertEquals(actualDefault,expectedDefault,"Test failed");
    }

    @Test
    public void stateDropdownTest(){

        //4. Verify “State selection” default selected value is correct
//           Expected: “Select a State”
        Select stateSelection = new Select(driver.findElement(By.id("state")));
        String actualState = stateSelection.getFirstSelectedOption().getText();
        String expectedState = "Select a State";
        Assert.assertEquals(actualState,expectedState, "Test failed");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();

    }

}
