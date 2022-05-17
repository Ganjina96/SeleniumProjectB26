package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.yahoo.com");

        // actual title from Selenium
        String actualTitle = driver.getTitle();
        System.out.println("Actual title of Yahoo page: " + actualTitle);

        // expected title comes from requirements
        String expectedTitle = "Yahoo";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification passed");
        }else {
            System.out.println("Title verification failed");
        }

        driver.quit();

    }
}
