package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    WebDriver driver; // have to set it up globally not locally

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running");
        // set up chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running");
        driver.close();
    }

    @Test
    public void googleTitle(){
        // Get "https://google.com/"
        driver.get("https://google.com/");

        // Assert: title is  "Google"
        String actual = driver.getTitle();
        String expected = "Google";
        // 3rd argument is optional for failed message only will appear if test fails
        Assert.assertEquals(actual,expected, "Test failed");

    }

}
