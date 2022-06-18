package com.cydeo.test.day13_configuration_reader;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.BrowserUtils;
import com.cydeo.test.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T01_Config_Practice extends TestBase {

    @Test
    public void login_crm_app(){

        //1. Create new test and make set ups
        // new way
        //2. Go to : https://login1.nextbasecrm.com/
        driver.get(ConfigurationReader.getProperty("env"));

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("username"));

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "(11) Portal");



/*
 // old way
        // 2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        // 3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

        // 4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        // 5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        // 6. Verify title is as expected:
        // Expected: Portal
        //BrowserUtils.verifyTitle(driver,"(1) Portal");

 */


    }
}
