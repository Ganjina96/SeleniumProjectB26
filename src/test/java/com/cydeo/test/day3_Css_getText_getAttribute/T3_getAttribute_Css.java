package com.cydeo.test.day3_Css_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_getAttribute_Css {
    public static void main(String[] args) {

        /*
        TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
         */

        // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        // 3- Verify “Log in” button text is as expected:
        //Expected: Log In

        // using CSS selector, we can search by attribute = type, value, onClick, etc

        // Located using value attribute
        // WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        // Located using class attribute
        // WebElement loginButton = driver.findElement(By.cssSelector("input[class='login-btn']"));

        WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        String expected = "Log In";
        String actual = loginBtn.getAttribute("value");

        if (actual.equals(expected)){
            System.out.println("Login button text verification passed");
        } else {
            System.out.println("Login button text verification failed");
        }

        driver.quit();



    }
}
