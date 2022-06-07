package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // 1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void informationAlertTest(){
//        TC #1: Information alert practice
//        3. Click to “Click for JS Alert” button
        WebElement jsAlertBtn = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        jsAlertBtn.click();

//        4. Click to OK button from the alert
        // switching from HTML format to alert format
        Alert alert = driver.switchTo().alert();
        alert.accept();

//        5. Verify “You successfully clicked an alert” text is displayed.
        WebElement text = driver.findElement(By.id("result"));
        Assert.assertTrue(text.isDisplayed());
        String actual = text.getText();
        String expected = "You successfully clicked an alert";
        Assert.assertEquals(actual,expected,"Test failed");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
