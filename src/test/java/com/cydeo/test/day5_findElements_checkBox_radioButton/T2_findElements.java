package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T2_findElements {
    public static void main(String[] args) {

//        1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // not using the whole 15 secs, just until the driver will find an element. Provides extra time for our driver before it throws NoSuchElementException

//        2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

//        3- Locate all the links in the page.
        List<WebElement> links = driver.findElements(By.tagName("a"));

//        4- Print out the number of the links on the page.
        System.out.println("the number of links on the site is " + links.size());

//        5- Print out the texts of the links.
        for (WebElement eachLink : links){
            System.out.println("eachLink.getText() = " + eachLink.getText());
        }

//        6- Print out the HREF attribute values of the links
        for (WebElement eachLink : links){
            System.out.println("eachLink.getAttribute(\"href\") = " + eachLink.getAttribute("href"));

        }

        driver.quit();


    }
}
