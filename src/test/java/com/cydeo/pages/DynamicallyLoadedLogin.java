package com.cydeo.pages;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedLogin {

    public DynamicallyLoadedLogin(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath="//button[.='Start']")
    public WebElement startBtn;

    @FindBy (id = "loading")
    public WebElement loadingBar;

    @FindBy (id = "username")
    public WebElement userInput;

    @FindBy (id = "pwd")
    public WebElement passInput;

    @FindBy (xpath = "//button[.='Submit']")
    public WebElement submitBtn;

    @FindBy (id = "flash")
    public WebElement errorMsg;





}

