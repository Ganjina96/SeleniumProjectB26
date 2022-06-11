package com.cydeo.test.aysun_hw.day9_hw;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class IframePractice extends TestBase {

    @Test
    public void alertTest() throws InterruptedException {
//2- Go to: https://practice.cydeo.com/iframe
        driver.get("https://login2.nextbasecrm.com/");

//        1.  Users are on the homepage (Login with valid username and password)
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk1@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//        2.  Users click the MESSAGE tab
        driver.findElement(By.id("feed-add-post-form-tab-message")).click();

//        3.  Users write test message
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys("Test message 113");

        Thread.sleep(3000);

//        4.  Users click the SEND button
        driver.switchTo().parentFrame();
        driver.findElement(By.id("blog-submit-button-save")).click();

        // Verify the message is displayed on the feed
        List<WebElement> message = driver.findElements(By.xpath("//div[@class='feed-post-text-block-inner-inner']"));
        String expectedMessage = "Test message 113";
        List<String> actualMessage = new ArrayList<>();

        for (WebElement each: message){
            actualMessage.add(each.getText());
        }

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }



}
