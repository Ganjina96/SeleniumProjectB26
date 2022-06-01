package com.cydeo.test.aysun_hw.day3_hw;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NextBaseCRM {

    /*
    TC #2: NextBaseCRM, locators, getText(), getAttribute() practice

PS: Inspect and decide which locator you should be using to locate web
elements.
     */

    public static void main(String[] args) throws InterruptedException {

        // 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        // 3- Verify “remember me” label text is as expected:
        // Expected: Remember me on this computer
        WebElement rmbrBtn = driver.findElement(By.cssSelector("label[class='login-item-checkbox-label']"));
        String label = rmbrBtn.getText();
        if (label.equals("Remember me on this computer")){
            System.out.println("Label correct");
        } else {
            System.out.println("Label incorrect");
        }

        // 4- Verify “forgot password” link text is as expected:
        // Expected: FORGOT YOUR PASSWORD?
        WebElement forgotPsw = driver.findElement(By.className("login-link-forgot-pass"));
        String text = forgotPsw.getText();
        if (text.equals("FORGOT YOUR PASSWORD?")){
            System.out.println("Text passed");
        } else {
            System.out.println("Text failed");
        }

        // 5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        WebElement forgotPsw2 = driver.findElement(By.cssSelector("a[href='/?forgot_password=yes']"));
        String actualAttr = forgotPsw2.getAttribute("href");
        if (actualAttr.contains("forgot_password=yes")){
            System.out.println("Attribute correct");
        } else {
            System.out.println("Attribute incorrect");
        }

        Thread.sleep(3000);

        driver.quit();


    }
}
