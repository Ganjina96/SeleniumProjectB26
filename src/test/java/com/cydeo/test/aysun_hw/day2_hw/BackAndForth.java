package com.cydeo.test.aysun_hw.day2_hw;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackAndForth {
    /*
    TC #3: Back and forth navigation
     */

    public static void main(String[] args) throws InterruptedException {

        // 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://google.com
        driver.get("https://google.com");

        // 3- Click to Gmail from top right.
        WebElement gmail = driver.findElement(By.linkText("Gmail"));
        gmail.click();

        // 4- Verify title contains:
        //  Expected: Gmail
        String actualTitle = driver.getTitle();

        if (actualTitle.contains("Gmail")){
            System.out.println("Title verified");
        } else {
            System.out.println("Title is wrong");
        }

        Thread.sleep(3000);

        // 5- Go back to Google by using the .back();
        driver.navigate().back();

        // 6- Verify title equals:
        //  Expected: Google
        String title = driver.getTitle();
        if (title.equals("Google")){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }

        driver.quit();




    }
}
