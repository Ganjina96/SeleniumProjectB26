package com.cydeo.test.aysun_hw.day6_hw;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EtsyRadioButton {

    @Test
    public void etsyTest(){
//        TC: Etsy checkbox and radio button

//        1. Go to https://www.etsy.com
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.etsy.com");

//        2. Search for “wooden spoon”
        WebElement woodenSpoon = driver.findElement(By.xpath("//input[contains(@id,'global-enhancements')]"));
        woodenSpoon.sendKeys("wooden spoon" + Keys.ENTER);

//        3. Click on filters
        WebElement filterBtn = driver.findElement(By.xpath("//span[.='All Filters']"));
        filterBtn.click();

//        4. Select free shipping, on sale
        WebElement freeShip = driver.findElement(By.xpath(("//label[contains(.,'FREE shipping')]")));
        WebElement onSale = driver.findElement(By.xpath("//label[contains(.,'On sale')]"));
        freeShip.click();
        onSale.click();

//        5. Select under $25 Click on apply filters
        WebElement under25 = driver.findElement(By.xpath("//label[contains(.,'Under $25')]"));
        under25.click();

//        6. Print count of results
        WebElement applyBtn = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
        applyBtn.click();
        // explicit wait - to wait for the  visibility of "Remove At Most $25 Filter" element

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Remove At Most $25 Filter']")));

        WebElement results = driver.findElement(By.xpath("//span[@class='wt-display-inline-flex-sm']/span[1]"));
        System.out.println("results.getText() = " + results.getText());

        driver.quit();
    }
}
