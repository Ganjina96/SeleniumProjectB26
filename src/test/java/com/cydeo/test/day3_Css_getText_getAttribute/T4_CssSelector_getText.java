package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_CssSelector_getText {
    public static void main(String[] args) {

        /*
        TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
         */

       // 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes ");

        // 3- Verify “Reset password” button text is as expected:
        //Expected: Reset password
        WebElement resetPassBtn = driver.findElement(By.cssSelector("button[class='login-btn']"));

        String expected = "Reset password";
        String actual = resetPassBtn.getText();

        if (actual.equals(expected)){
            System.out.println("Reset password button text verification passed");
        } else {
            System.out.println("Reser password button text verification failed");
        }

        driver.quit();



    }
}
