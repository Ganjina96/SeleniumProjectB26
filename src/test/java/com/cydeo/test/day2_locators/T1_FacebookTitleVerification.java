package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_FacebookTitleVerification {
    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to facebook url
        driver.get("https://www.facebook.com");

        // 3. Verify title: Expected result vs Actual result
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title Verification Passed");
        }else {
            System.out.println("Title Verification Failed");
        }

        driver.quit();



    }
}
