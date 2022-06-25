package com.cydeo.test.aysun_hw.day16_hw;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T1_InfiniteScroll {

    @Test
    public void infinite_scroll() {
        // 1- Open a chrome browser
        // 2- Go to:https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        // 3- Use below JavaScript method and scroll
        // a. 750 pixels down 10times.
        for (int i = 1; i <= 10 ; i++) {
            ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollBy(0,750)");
        }

        // b. 750 pixels up 10times
        for (int i = 1; i <= 10 ; i++) {
            ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollBy(0,-750)");
        }

        Driver.closeDriver();

//    JavaScript's method to use :window.scrollBy(0,0)
    }
}
