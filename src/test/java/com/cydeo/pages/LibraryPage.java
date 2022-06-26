package com.cydeo.pages;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryPage {

    public LibraryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement signInBtn;

    @FindBy (id = "inputEmail-error")
    public WebElement errorMsg;

    @FindBy (id = "inputEmail")
    public WebElement inputEmail;

    @FindBy (id = "inputPassword")
    public WebElement password;

    @FindBy (xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement errorMsg2;



}
