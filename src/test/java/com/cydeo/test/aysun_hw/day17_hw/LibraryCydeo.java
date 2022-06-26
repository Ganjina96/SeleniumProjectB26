package com.cydeo.test.aysun_hw.day17_hw;

import com.cydeo.pages.LibraryPage;
import com.cydeo.test.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LibraryCydeo {
    LibraryPage libraryPage;


    @BeforeMethod
    public void setUp(){
//        1- Open a chrome browser
//        2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
        libraryPage = new LibraryPage();
    }

    @Test
    public void error_msg_test(){
//        3- Do not enter any information
//        4- Click to “Sign in” button
        libraryPage.signInBtn.click();

//        5- Verify expected error is displayed:
//        Expected: This field is required.
        Assert.assertEquals(libraryPage.errorMsg.getText(),"This field is required.");
    }

    @Test
    public void invalid_email(){
//        3- Enter invalid email format
        libraryPage.inputEmail.sendKeys("ganjina");
        libraryPage.signInBtn.click();

//        4- Verify expected error is displayed:
//        Expected: Please enter a valid email address.
        Assert.assertEquals(libraryPage.errorMsg.getText(),"Please enter a valid email address.");
    }

    @Test
    public void negative_login(){
//        3- Enter incorrect username or incorrect password
        libraryPage.inputEmail.sendKeys("ganjina@gmail.com");
        libraryPage.password.sendKeys("incorrect");
        libraryPage.signInBtn.click();

//        4- Verify title expected error is displayed:
//        Expected: Sorry, Wrong Email or Password
        Assert.assertEquals(libraryPage.errorMsg2.getText(),"Sorry, Wrong Email or Password");

        Driver.closeDriver();
    }
}
