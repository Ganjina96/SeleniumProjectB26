package com.cydeo.test.aysun_hw.day2_hw;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EtsyTitleVerification {

    /*
    TC #1: Etsy Title Verification
     */

    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        // 3. Search for “wooden spoon”
        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        // 4. Verify title:
        //Expected: “Wooden spoon | Etsy”
        String title = driver.getTitle();
        if (title.equals("Wooden spoon | Etsy")){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        driver.quit();
    }
}
