package com.cydeo.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    // TC: Create utility methods for CRM_Utilities class
    // 1. Create a new method for login
    // 2. Create a method to make CRM Login test logic re-usable
    // 3. When method is called, it should simply log in
    // This method should have at least 2 overloaded versions.

    // Method #1 info:
        //• Name: login_crm()
        //• Return type: void
        //• Arg1: WebDriver
    public static void login_crm(WebDriver driver){
        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("helpdesk1@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();
    }

    // Method #2 info:
        //• Name: login_crm()
        //• Return type: void
        //• Arg1: WebDriver
        //• Arg2: String username
        //• Arg3: String password
    public static void login_crm(WebDriver driver, String username, String password){
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

    }








}
