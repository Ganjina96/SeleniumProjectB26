package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_radioButton {
    public static void main(String[] args) {

//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

//        3. Click to “Hockey” radio button
        WebElement hockeyBtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyBtn.click();

//        4. Verify “Hockey” radio button is selected after clicking.
        System.out.println("hockeyBtn.isSelected() = " + hockeyBtn.isSelected());

//        5. Locate Green Button
        WebElement greenBtn = driver.findElement(By.xpath("//input[@id='green']"));

//        6. Verify if it is enabled
        System.out.println("greenBtn.isEnabled() = " + greenBtn.isEnabled());


        driver.quit();
    }
}
