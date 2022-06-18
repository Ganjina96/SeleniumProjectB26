package com.cydeo.test.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // First we have to have a private constructor to have a Singleton design pattern and close access to the object of this class from outside this class

    private Driver(){}

    // now we need an instance variable of the driver
    // we make it private to hide it from outside influence, and we make it static because only static variables are accepted into a static method we will use it in.

    private static WebDriver driver;

    // we make a public getter method, so we can access it anywhere, we make it static, so we can call it by class name without needing to create an object

    public static WebDriver getDriver(){
        // check if the driver is null and if it is we will set up a browser inside the "if statement"
        // if we have already set up the driver and using it again for following lines of code it will return us to the same driver

        if (driver == null){
            // we read browser type from the configuration.properties with the help of Configuration Reader class and getDriver() method

            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;
            }

        }
        return driver;
    }












}
