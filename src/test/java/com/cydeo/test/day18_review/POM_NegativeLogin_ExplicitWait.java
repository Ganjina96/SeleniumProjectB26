package com.cydeo.test.day18_review;

import com.cydeo.pages.DynamicallyLoadedLogin;
import com.cydeo.test.utilities.BrowserUtils;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POM_NegativeLogin_ExplicitWait {

    @Test
    public void negative_login(){
//        1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

//        2. Click to start
        DynamicallyLoadedLogin login = new DynamicallyLoadedLogin();
        login.startBtn.click();

//        3. Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(login.loadingBar));

       // BrowserUtils.waitForInvisibilityOf(login.loadingBar);

//        4. Assert username inputbox is displayed
        Assert.assertTrue(login.userInput.isDisplayed());

//        5. Enter username: tomsmith
        login.userInput.sendKeys("tomsmith");

//        6. Enter password: incorrectpassword
        login.passInput.sendKeys("incorrectpassword");

//        7. Click to Submit button
        login.submitBtn.click();

//        8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(login.errorMsg.isDisplayed());

        Driver.closeDriver();
    }
}
