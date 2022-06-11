package com.cydeo.test.aysun_hw.day9_hw;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class SimpleIframe extends TestBase {

    @Test
    public void iframe(){
        //1. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        //2.Assert: “Your content goes here.” Text is displayed.
        WebElement commentBody = driver.findElement(By.id("tinymce"));
        assertEquals(commentBody.getText(),"Your content goes here.");

        //3. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        WebElement headerText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(headerText.isDisplayed(), "failed");

        String actualHeader = headerText.getText();
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHeader,expectedHeader,"failed");
    }




}
