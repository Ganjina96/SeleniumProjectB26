package com.cydeo.test.aysun_hw.extra_practice;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileage extends TestBase {
    @Test
    public void gasMileageTest(){
        //2. Go to https://www.calculator.net
        driver.get("https://www.calculator.net ");

        //3. Search for “gas mileage” using search box
        driver.findElement(By.cssSelector("input[id='calcSearchTerm']")).sendKeys("gas mileage");

        //4. Click on the “Gas Mileage Calculator” link
        driver.findElement(By.xpath("//a[text()='Gas Mileage Calculator']")).click();

        //5. On Next page verify:
        //    a. Title equals: “Gas Mileage Calculator”
        //    b. “Gas Mileage Calculator” label is displayed

        Assert.assertEquals(driver.getTitle(),"Gas Mileage Calculator");
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Gas Mileage Calculator']")).isDisplayed());

        //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement odometer = driver.findElement(By.cssSelector("input[id='uscodreading']"));
        odometer.clear();
        odometer.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometer = driver.findElement(By.cssSelector("input[id='uspodreading']"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");

        //8.Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded = driver.findElement(By.cssSelector("input[id='usgasputin']"));
        gasAdded.clear();
        gasAdded.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice = driver.findElement(By.cssSelector("input[id='usgasprice']"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        //10. Click on Calculate button
        driver.findElement(By.xpath("(//input[@value='Calculate'])[1]")).click();

        //11. Verify mpg value is as expected: Expected value: “23.44 mpg”
        String actualMpg = driver.findElement(By.xpath("//b[.='23.44 mpg']")).getText();
        String expectedMpg = "23.44 mpg";
        Assert.assertEquals(expectedMpg,actualMpg,"MPG verification failed");





    }

}



