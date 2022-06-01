package com.cydeo.test.aysun_hw.day2_hw;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CydeoPractice {

    /*
    TC #4: Practice Cydeo – Class locator practice

PS: Locate “Home” link using “className” locator
     */

    public static void main(String[] args) {

        // 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        // 3- Click to “Home” link
        WebElement homeBtn = driver.findElement(By.className("nav-link"));
        homeBtn.click();

        // 4- Verify title is as expected:
        //Expected: Practice
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Practice")){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        driver.quit();


    }
}
