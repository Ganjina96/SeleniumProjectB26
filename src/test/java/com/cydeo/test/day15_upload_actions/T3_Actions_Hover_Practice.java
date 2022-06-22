package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class T3_Actions_Hover_Practice {

    @Test
    public void google_actions_hover_test(){
        //    1. Go to https://www.google.com
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));


//    2. Hover over on Search button
        WebElement googleSearch = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input"));
        Actions action = new Actions(Driver.getDriver());
        // hover over method is moveToElement() and at the end you have to chain perform() method to actually perform the action
        action.moveToElement(googleSearch).perform();

//    3. Hover over on Feeling Lucky button
        WebElement luckyBtn = Driver.getDriver().findElement(By.id("gbqfbb"));
        action.moveToElement(luckyBtn).perform();

        Driver.closeDriver();

    }
}
