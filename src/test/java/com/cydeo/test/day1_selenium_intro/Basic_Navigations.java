package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_Navigations {
    public static void main(String[] args) throws InterruptedException {

        // 1- Setting up webdriver manager
        WebDriverManager.chromedriver().setup();

        // 2- Create instance of Webdriver
        WebDriver driver = new ChromeDriver();

        // 3- Make our page full screen
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");

        //driver.navigate().to("https://www.etsy.com");

        Thread.sleep(3000); // milliseconds, 3 seconds

        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.navigate().refresh();

        System.out.println(" Etsy page driver.getTitle() = " + driver.getTitle());
        //String currentTitle = driver.getTitle();

        driver.get("https://www.tesla.com");

        System.out.println("Tesla page driver.getTitle() = " + driver.getTitle());

        // getting the current url of the page you are on
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.close();
        driver.quit();

    }
}
