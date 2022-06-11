package com.cydeo.test.day10_utilities_windows;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Iframe_CRM_AppreciationTest extends TestBase {

    @Test
    public void sendAppreciation() throws InterruptedException {
        // 2 - Go to: https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");

        // 3 - Login Homepage ( Login with valid username and password)
        CRM_Utilities.login_crm(driver);
//        WebElement username = driver.findElement(By.name("USER_LOGIN"));
//        username.sendKeys("helpdesk1@cybertekschool.com");
//        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
//        password.sendKeys("UserUser");
//        WebElement loginBtn = driver.findElement(By.className("login-btn"));
//        loginBtn.click();
        Thread.sleep(3000);

        // 4 - Click the MORE tab and select APPRECIATION
        WebElement moreBtn = driver.findElement(By.cssSelector("span[id*='link-text']"));
        // by xpath: //span[contains(@id,'link-text')]
        moreBtn.click();
        WebElement appreciationBtn = driver.findElement(By.xpath("//span[.='Appreciation'][@class='menu-popup-item-text']"));
        appreciationBtn.click();
        Thread.sleep(3000);

        // 5 - Write an Appreciation message
        driver.switchTo().frame(driver.findElement(By.className("bx-editor-iframe")));
        WebElement body = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        body.sendKeys("Hello World");
        Thread.sleep(3000);

        // 6 - Click the SEND button
        driver.switchTo().defaultContent();
        WebElement sendBtn = driver.findElement(By.xpath("//button[contains(@id,'button-save')]"));
        sendBtn.click();
        Thread.sleep(3000);


        // 7 - Verify the Appreciation message is displayed on the feed
        WebElement message = driver.findElement(By.xpath("//div[contains(@id,'blog_post_body')]"));
        String actual = message.getText();
        String expected = "Hello World";
        Assert.assertEquals(actual,expected,"Test failed");


    }

}
