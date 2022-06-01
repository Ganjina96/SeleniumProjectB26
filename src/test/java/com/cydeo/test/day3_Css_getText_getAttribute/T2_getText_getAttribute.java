package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_getText_getAttribute {

    /*
    TC #2: getText() and getAttribute() method practice
     */
    public static void main(String[] args) {

        // 1- Open a chrome browser
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form ");

        // 3- Verify header text is as expected:
        //  Expected: Registration form

        // locate header text to get the text btw openign and closing tag

        // Using cssSelector to go from parent to child
        //WebElement headerText = driver.findElement(By.cssSelector("div[class='page-header']>h2"));


        // using cssSelector to go from parent to child
        WebElement headerText = driver.findElement(By.tagName("h2"));
        String expectedHeader = "Registration form";
        String actual = headerText.getText();

        if (actual.equals(expectedHeader)){
            System.out.println("Header text verification passed");
        } else {
            System.out.println("Header text verification failed");
        }

        // 4- Locate “First name” input box
        WebElement inputBox = driver.findElement(By.name("firstname"));

        // 5- Verify placeholder attribute’s value is as expected:
        //  Expected: first name
        String expectedAttr = "first name";

        // getAttribute(attribute argument) method is helping us get value of attributes
        String actualAttr = inputBox.getAttribute("placeholder");

        if (actualAttr.equals(expectedAttr)){
            System.out.println("Placeholder text verification passed");
        } else {
            System.out.println("Placeholder text verification failed");
        }

        driver.quit();

    }
}
