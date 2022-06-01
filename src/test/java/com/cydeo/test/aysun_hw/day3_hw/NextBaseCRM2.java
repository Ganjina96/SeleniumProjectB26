package com.cydeo.test.aysun_hw.day3_hw;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NextBaseCRM2 {

    /*
    TC #5: NextBaseCRM, locators, getText(), getAttribute() practice

PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
     */

    public static void main(String[] args) {

        // 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        // 3- Enter incorrect username into login box:
        WebElement loginBox = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        loginBox.sendKeys("incorrect");

        // 4- Click to `Reset password` button
        WebElement resetBtn = driver.findElement(By.cssSelector("button[value='Reset password']"));
        resetBtn.click();

        // 5- Verify “error” label is as expected
        //: Login or E-mail not found
        WebElement errorTxt = driver.findElement(By.cssSelector("div.errortext"));
        String actualTxt = errorTxt.getText();
        if (actualTxt.equals("Login or E-mail not found")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.quit();



    }
}
