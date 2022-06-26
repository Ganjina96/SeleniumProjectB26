package com.cydeo.test.day17_pom_synchronization;

import com.cydeo.pages.CydeoPracticePage;
import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POM_ActionsPractices {

    CydeoPracticePage practicePage;
    Actions actions;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("drag.and.drop.url"));
        practicePage = new CydeoPracticePage();
        actions = new Actions(Driver.getDriver());

    }

    @Test
    public void drag_small_circle_text(){
//        1. Open a chrome browser
//        2. Go to:
//        https://practice.cydeo.com/drag_and_drop_circles
//        3. Verify expected default text appears on big circle
//                Expected = "Drag the small circle here."
        Assert.assertEquals(practicePage.bigCirlce.getText(),"Drag the small circle here.");

    }

    @Test
    public void drop_here_text(){
//        1. Open a chrome browser
//        2.  Go to:
//        https://practice.cydeo.com/drag_and_drop_circles

//        3. Click and hold small circle
        // moveByOffset(x,y) moves the element along the x and y axis to see the message
        actions.moveToElement(practicePage.smallCircle)
                .clickAndHold()
                .pause(2000)
                .moveByOffset(100,0)
                .pause(2000)
                .perform();

//        4. Verify "Drop here." text appears on big circle
        Assert.assertEquals(practicePage.bigCirlce.getText(),"Drop here.");

    }

    @Test
    public void now_drop_text(){
//        7. Open a chrome browser
//        8. Go to:
//        https://practice.cydeo.com/drag_and_drop_circles
//        9. Click and hold small circle
//        10. Move it on top of the big circle
        actions.moveToElement(practicePage.smallCircle)
                .clickAndHold().pause(2000)
                .moveToElement(practicePage.bigCirlce).pause(2000)
                .perform();

//        11. Verify “Now drop...” text appears on big circle
        Assert.assertEquals(practicePage.bigCirlce.getText(), "Now drop...");
    }

    @Test
    public void try_again(){
//        1. Open a chrome browser
//        2. Go to:
//        https://practice.cydeo.com/drag_and_drop_circles
//        3. Click and hold small circle
//        4. Dropped anywhere outside of big circle
        actions.moveToElement(practicePage.smallCircle)
                .clickAndHold().pause(2000)
                .moveByOffset(100,0).pause(2000)
                .release().perform();

//        5. Verify “Try again!” text appears on big circle
        Assert.assertEquals(practicePage.bigCirlce.getText(), "Try again!");

        Driver.closeDriver();

    }
}
