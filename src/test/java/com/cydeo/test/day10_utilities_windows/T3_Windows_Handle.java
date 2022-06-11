package com.cydeo.test.day10_utilities_windows;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class T3_Windows_Handle extends TestBase {

    @Test
    public void windowHandleTest(){

//        2. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");

        String mainWindow = driver.getWindowHandle(); // will be unique ID each time you refresh or run the program, because the olf one goes to garbage
        System.out.println("mainWindow = " + mainWindow);

//        3. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(actualTitle,expectedTitle,"Wrong title");

//        4. Click to: “Click Here” link
        WebElement clickBtn = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickBtn.click();

//        5. Switch to new Window.
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String eachWindow : allWindowHandles){
            driver.switchTo().window(eachWindow);
            System.out.println(driver.getTitle());
        }

//        6. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitleAfterClick,"Wrong new window");

    }
}
