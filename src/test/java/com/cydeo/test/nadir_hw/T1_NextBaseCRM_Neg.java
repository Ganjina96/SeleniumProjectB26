package com.cydeo.test.nadir_hw;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_NextBaseCRM_Neg {
    public static void main(String[] args) throws InterruptedException {


        /*
        Test case 02:
        For US: Login Functionality
        For Negative AC: HelpDesk credentials( correct username and wrong password)
         */

        // 1. Setup driver
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2. Go to http://login2.nextbasecrm.com/
        driver.get("http://login2.nextbasecrm.com/");

        // 3. Verify you are on nextbasecrm.com autorization page
        // Expected title: "Authorization"

        String actualTitle = driver.getTitle();
        String expectedTitle = "Authorization";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("You are on the right page");
        } else {
            System.out.println("You are on the wrong page");
        }

        Thread.sleep(3000);

        // 4. Enter correct username: helpdesk1@cybertekschool.com

        WebElement username = driver.findElement(By.name("USER_LOGIN"));
        username.sendKeys("helpdesk1@cybertekschool.com");

        // 5. Enter wrong password: wrong
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("wrong");

        // 5. Locate the login button and click it
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();

        // 6. I should see an error message: Incorrect login or password

        WebElement errorTxt = driver.findElement(By.className("errortext"));
        String name = errorTxt.getText();
        String expected = "Incorrect login or password";

        if (name.equals(expected)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        Thread.sleep(3000);

        driver.quit();


    }
}
