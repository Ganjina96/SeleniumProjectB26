package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_JavaFaker_Registration_Form {

    @Test
    public void registration_form_test(){
        // Note: Use JavaFaker OR read from configuration.properties file when possible.
//    1. Open browser
//    2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();
//    3. Enter first name
        WebElement firstName = Driver.getDriver().findElement(By.name("firstname"));
        firstName.sendKeys(faker.name().firstName());
//    4. Enter last name
        WebElement lastName = Driver.getDriver().findElement(By.name("lastname"));
        lastName.sendKeys(faker.name().lastName());
//    5. Enter username
        WebElement username = Driver.getDriver().findElement(By.name("username"));
        username.sendKeys(faker.bothify("?????###"));
//    6. Enter email address
        WebElement email = Driver.getDriver().findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());
//    7. Enter password
        WebElement password = Driver.getDriver().findElement(By.name("password"));
        password.sendKeys(faker.internet().password());
//    8. Enter phone number
        WebElement phoneNum = Driver.getDriver().findElement(By.name("phone"));
        phoneNum.sendKeys(faker.numerify("###-###-####"));
//    9. Select a gender from radio buttons
        WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        gender.click();
//    10.Enter date of birth
        WebElement dob = Driver.getDriver().findElement(By.name("birthday"));
        dob.sendKeys(faker.numerify("0#/1#/19##"));
//    11.Select Department/Office
        Select department = new Select(Driver.getDriver().findElement(By.name("department")));
        department.selectByIndex(faker.number().numberBetween(1,9));
//    12.Select Job Title
        Select title = new Select(Driver.getDriver().findElement(By.name("job_title")));
        title.selectByIndex(faker.number().numberBetween(1,8));

//    13.Select programming language from checkboxes
        WebElement programLand = Driver.getDriver().findElement(By.id("inlineCheckbox2"));
        programLand.click();

//    14.Click to sign up button
        WebElement signUp = Driver.getDriver().findElement(By.id("wooden_spoon"));
        signUp.click();
//    15.Verify success message “You’ve successfully completed registration.” is
//    displayed.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//h4[@class='alert-heading']/following-sibling::p"))));
        WebElement msg = Driver.getDriver().findElement(By.xpath("//h4[@class='alert-heading']/following-sibling::p"));

        Assert.assertEquals(msg.getText(),"You've successfully completed registration!");
        Driver.closeDriver();

    }

}
