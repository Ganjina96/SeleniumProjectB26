package com.cydeo.test.aysun_hw.day15_hw;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW15_UploadTest {

    @Test
    public void upload_test() throws InterruptedException {
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.practice.url"));

        //2. Find some small file from your computer, and get the path of it.
        String filePath = "/Users/Ganjina/Downloads/some-file.txt";

        //3. Upload the file.
        Driver.getDriver().findElement(By.xpath("//input[@id ='file-upload']")).sendKeys(filePath);
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//input[@id ='file-submit']")).click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement msg = Driver.getDriver().findElement(By.xpath("//h3"));
        Assert.assertTrue(msg.isDisplayed());

        Driver.closeDriver();

    }
}
/*
TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page
 */











