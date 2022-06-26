package com.cydeo.pages;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedPage {

    public DynamicallyLoadedPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "alert")
    public WebElement doneMsg;

    @FindBy (xpath = "//img[@alt='square pants']")
    public WebElement img;
}
