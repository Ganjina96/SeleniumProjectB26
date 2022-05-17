package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2_CydeoVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");

        String expectedURL = "cydeo"; // comes from requirement
        String actualURL = driver.getCurrentUrl(); // comes from selenium

        if (actualURL.contains(expectedURL)){
            System.out.println("URL verification passed");
        }else {
            System.out.println("URL verification failed");
        }

        String expectedTitle = "practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Title verification passed");
        }else {
            System.out.println("Title verification failed");
        }



        driver.quit();
    }
}
