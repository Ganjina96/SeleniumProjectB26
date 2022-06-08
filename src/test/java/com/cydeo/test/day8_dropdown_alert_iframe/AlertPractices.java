package com.cydeo.test.day8_dropdown_alert_iframe;

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

public class AlertPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // 1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void confirmationAlert(){
//        TC #2: Confirmation alert practice
//        3. Click to “Click for JS Confirm” button
        WebElement confirmBtn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmBtn.click();

//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

//        5. Verify “You clicked: Ok” text is displayed.
        WebElement okBtn = driver.findElement(By.id("result"));

        Assert.assertTrue(okBtn.isDisplayed(), "failed");

        String expected = "You clicked: Ok";
        String actual = okBtn.getText();
        Assert.assertEquals(actual,expected,"Failed");

    }

    @Test
    public void promptAlert(){
//        3. Click to “Click for JS Prompt” button
        WebElement promptBtn = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptBtn.click();

//        4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

//        5. Click to OK button from the alert
        alert.accept();

//        6. Verify “You entered:  hello” text is displayed.
        WebElement msg = driver.findElement(By.id("result"));

        Assert.assertTrue(msg.isDisplayed(), "failed");

        String expected = "You entered: hello";
        String actual = msg.getText();
        Assert.assertEquals(actual,expected,"Failed");



    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
