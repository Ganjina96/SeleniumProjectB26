package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Guru99_Upload_Test {

    @Test
    public void upload_file_test(){
        //    1. Go to “http://demo.guru99.com/test/upload”
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.upload.url"));
//    2. Upload file into Choose File
        WebElement fileUpload = Driver.getDriver().findElement(By.id("uploadfile_0"));
        // We do not click on Choose File element because it will open out of browser
        // window which is coming from machine and selenium can not handle it
        // that is why after we locate choose file element we just use sendKeys method to send path
        fileUpload.sendKeys("/Users/Ganjina/Downloads/some-file.txt");
//    3. Click terms of service checkbox
        WebElement terms = Driver.getDriver().findElement(By.id("terms"));
        terms.click();
//    4. Click Submit File button
        WebElement submit = Driver.getDriver().findElement(By.id("submitbutton"));
        submit.click();
//    5. Verify expected message appeared.
//    Expected: “1 file
//    has been successfully uploaded.”
        String expected = "1 file\n" + "has been successfully uploaded.";
        WebElement result = Driver.getDriver().findElement(By.xpath("//h3[@id='res']//center"));
        String actual = result.getText();
        Assert.assertEquals(actual,expected);

        Driver.closeDriver();
    }
}
