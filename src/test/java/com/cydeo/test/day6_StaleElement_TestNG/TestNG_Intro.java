package com.cydeo.test.day6_StaleElement_TestNG;

import org.testng.Assert;
import org.testng.annotations.*;


public class TestNG_Intro {

    // beforeClass will be running before all test methods
    @BeforeClass
    public void setUp(){
        System.out.println("Setting up...");
    }

    // afterClass will be running after all test methods
    @AfterClass
    public void tearDown(){
        System.out.println("After class is done");
    }

    // beforeMethod will be running before each test method
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Setting up method");
    }

    // afterMethod will be running after each test method
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is done");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is running...");
        String actual = "apple";
        String expected = "apple";

        // assertEquals(actual,expected, "Test failed"), message is optional and will only appear if it fails
        Assert.assertEquals(actual,expected, "Test failed");

    }

//    public void test2(){
//        System.out.println("Test 2 is running..."); // won't run because there is no @Test annotation, it is not runnable
//    }

    @Test
    public void test2(){
        System.out.println("Test 2 is running...");

        Assert.assertEquals("orange", "orange", "failed");
    }



}
