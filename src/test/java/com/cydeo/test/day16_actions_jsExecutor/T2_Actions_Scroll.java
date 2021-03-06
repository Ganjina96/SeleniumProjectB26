package com.cydeo.test.day16_actions_jsExecutor;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T2_Actions_Scroll {

    @Test
    public void actions_scroll_test(){

        //    1- Open a chrome browser
//    2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");
        Actions actions = new Actions(Driver.getDriver());

//    3- Scroll down to “Powered by CYDEO”
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

//    4- Scroll using Actions class “moveTo(element)” method
        // there are 2 ways to do the scrolling in Actions class:
        // first is moveToElement(element)
        // second is sendKeys(Keys.PAGE_UP) and (Keys.PAGE_DOWN)
        actions.moveToElement(cydeoLink).perform();

//    1- Continue from where previous task left in the same test.
//    2- Scroll back up to “Home” link using PageUP button
        WebElement homeBtn = Driver.getDriver().findElement(By.linkText("Home"));
        actions.moveToElement(homeBtn).perform();
        // this one doesnt work by just one time, you have to figure out how many times to scroll to get to your element
        //actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();

        Driver.closeDriver();



    }
}
