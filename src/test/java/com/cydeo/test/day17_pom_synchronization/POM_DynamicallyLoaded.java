package com.cydeo.test.day17_pom_synchronization;

import com.cydeo.pages.DynamicallyLoadedPage;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POM_DynamicallyLoaded {
    DynamicallyLoadedPage loadedPage;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        loadedPage = new DynamicallyLoadedPage();

    }

    @Test
    public void load_page(){
//        2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

//        3. Assert:
//        Message “Done” is displayed.
        Assert.assertEquals(loadedPage.doneMsg.getText(), "Done!");

//        4. Assert: Image is displayed.
        Assert.assertTrue(loadedPage.img.isDisplayed());

    }

}
