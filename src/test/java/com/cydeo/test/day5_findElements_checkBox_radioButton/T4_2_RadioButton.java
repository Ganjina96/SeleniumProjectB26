package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_2_RadioButton {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> allSportElements = driver.findElements(By.xpath("//input[@name='sport']"));
        for (WebElement eachSport : allSportElements) {
            Thread.sleep(3000);
            eachSport.click();
        }

    }
}
