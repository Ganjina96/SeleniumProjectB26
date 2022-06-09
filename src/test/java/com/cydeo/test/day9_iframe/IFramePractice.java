package com.cydeo.test.day9_iframe;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFramePractice extends TestBase {


    @Test
    public void iframe() throws InterruptedException {
//        TC #6: Iframe Task

//        2- Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");

        // NoSuchElementException comes with reasons:
        // 1--> not locating correctly element
        // 2--> there is an iframe and you have to switch to frame to reach this element
//        3- Clear text from comment body

        // we can use frame(id) method with id arg. of the iframe, not the element
        driver.switchTo().frame("mce_0_ifr");
//        // we can use frame(locator)
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
//        // we can use frame(index): index starts from 0
//        // we can find iframe tags from html with using xpath "//iframe"
//        driver.switchTo().frame(0);

        WebElement commentBody = driver.findElement(By.id("tinymce"));

//        // clear() method: deletes the text from the comment  body
        commentBody.clear();


//        4- Type "Hello World" in comment body
        commentBody.sendKeys("Hello World");

//        5- Verify "Hello World" text is written in comment body
        Assert.assertEquals(commentBody.getText(), "Hello World");

        driver.switchTo().parentFrame();
       // driver.switchTo().defaultContent();

//        6- Verify header "An iFrame containing the TinyMCE
//        WYSIWYG Editor" is displayed
        WebElement headerText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(headerText.isDisplayed(), "failed");

    }

}
