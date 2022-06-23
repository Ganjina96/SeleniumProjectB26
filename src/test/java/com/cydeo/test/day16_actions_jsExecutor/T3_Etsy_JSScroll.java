package com.cydeo.test.day16_actions_jsExecutor;

import com.cydeo.test.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Etsy_JSScroll {

    @Test
    public void etsy_js_scroll() throws InterruptedException {
         //Goto Etsy homepage
         Driver.getDriver().get("https://www.etsy.com/");

         //Scroll down
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // the 2 parameters are x and y coordinates. X stands for horizontal line, in case you wanna scroll right and left, and the Y is for vertical line in case you wanna scroll up and down

        //js.executeScript("window.scrollBy(0, 3000)");

         //Generate random email and enter into subscribe box
        Faker faker = new Faker();
        WebElement email = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));
        js.executeScript("arguments[0].scrollIntoView(true)", email);
        email.sendKeys(faker.internet().emailAddress());

         //Click on Subscribe
        Driver.getDriver().findElement(By.cssSelector("button[class='wt-btn wt-input-btn-group__btn']")).click();

         //Verify "Great! We've sent you an email to confirm your subscription." is displayed
        Thread.sleep(3000);
        WebElement msg = Driver.getDriver().findElement(By.cssSelector("div[class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']"));
        Assert.assertTrue(msg.isDisplayed());
        Assert.assertEquals(msg.getText(),"Great! We've sent you an email to confirm your subscription.");

        Driver.closeDriver();
    }
}







