package com.cydeo.test.day4_cssSelector_xpath;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_css_isDisplayed {
    public static void main(String[] args) {

        /*
        TC #1: XPATH and cssSelector Practices
         */

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        // 3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)

                // a.“Home” link
        //Locate homeLink using cssSelector, class value
        WebElement homeLink1 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //Locate homeLink using cssSelector, href value
        WebElement homeLink2 = driver.findElement(By.cssSelector("a[href='/']"));
        //Locate homeLink using cssSelector, syntax2 for class "."
        WebElement homeLink3 = driver.findElement(By.cssSelector("a.nav-link"));

        // Locate home link using XPATH by class attribute
        WebElement homeLink4 = driver.findElement(By.xpath("//a[@class='nav-link']"));
        // Locate home link using XPATH by text
        WebElement homeLink5 = driver.findElement(By.xpath("//a[.='Home']")); // xpath("//a[text()='Home']")


               // b. “Forgot password” header
        //Locate forgotPswd using cssSelector from parent to child w/ ">"
        WebElement forgotPswd1 = driver.findElement(By.cssSelector("div[class='example']>h2"));
        //Locate forgotPswd using cssSelector syntax2 from parent to child w/ ">"
        WebElement forgotPswd2 = driver.findElement(By.cssSelector("div.example > h2"));


        // Locate forgot password using XPATH
        WebElement forgotPswd3 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));


              // c. “E-mail” text
        //Locate email using cssSelector from parent to child w/ ">"
        WebElement email1 = driver.findElement(By.cssSelector("div[class='large-6 small-12 columns']>label"));
        //Locate email using cssSelector by label attribute
        WebElement email2 = driver.findElement(By.cssSelector("label[for='email']"));


        // Locate email using XPATH by text
        WebElement email3 = driver.findElement(By.xpath("//label[.='E-mail']"));


             // d. E-mail input box
        WebElement inputBox = driver.findElement(By.cssSelector("input[type='text']"));

        // Locate email input box using XPATH by type attribute
        WebElement inputBox1 = driver.findElement(By.xpath("//input[@type='text']"));


            // e. “Retrieve password” button
        WebElement retrievePswd = driver.findElement(By.cssSelector("button#form_submit"));

          // f. “Powered by Cydeo text
        WebElement cydeo = driver.findElement(By.cssSelector("div[style='text-align: center;']"));

        // 4. Verify all web elements are displayed.
        System.out.println("Home Link is displayed? " + homeLink1.isDisplayed());
        System.out.println("Forgot password header is displayed? " + forgotPswd1.isDisplayed());
        System.out.println("Email text is displayed? " + email1.isDisplayed());
        System.out.println("Email input box is displayed? " + inputBox.isDisplayed());
        System.out.println("Retrieve password button is displayed? " + retrievePswd.isDisplayed());
        System.out.println("Powered by Cydeo text is displayed? " + cydeo.isDisplayed());

        driver.quit();


    }
}
