package com.cydeo.test.aysun_hw.day4_hw;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PracticeCydeoForgotPasswordURLVerification {
    public static void main(String[] args) {

//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

//        3. Enter any email into input box
        WebElement inputBox = driver.findElement(By.xpath("//input[@name='email']"));
        inputBox.sendKeys("gnagzibe@gmail.com");

//        4. Click on Retrieve password
        WebElement retrievePassBtn = driver.findElement(By.xpath("//i[.='Retrieve password']"));
        retrievePassBtn.click();

//        5. Verify URL contains:
//        Expected: “email_sent”
        String actualUrl = driver.getCurrentUrl();
        String expected = "email_sent";
        if (actualUrl.contains(expected)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }
//        6. Verify textbox displayed the content as expected.
//                Expected: “Your e-mail’s been sent!”
//        Hint: You need to use getText method for this practice.

        WebElement emailText = driver.findElement(By.xpath("//h4[@name='confirmation_message']"));
        String actualText = emailText.getText();
        String expectedText = "Your e-mail's been sent!";
        if (actualText.equals(expectedText)){
            System.out.println("Passed");
        }else {
            System.out.println("FAILED");
        }

        driver.quit();

    }
}
