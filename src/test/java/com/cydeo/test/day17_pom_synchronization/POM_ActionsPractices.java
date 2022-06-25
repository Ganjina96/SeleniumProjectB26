package com.cydeo.test.day17_pom_synchronization;

import com.cydeo.pages.CydeoPracticePage;
import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POM_ActionsPractices {
    @Test
    public void drag_small_circle_text(){
//        1. Open a chrome browser
//        2. Go to:
//        https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get(ConfigurationReader.getProperty("drag.and.drop.url"));
        CydeoPracticePage practicePage = new CydeoPracticePage();

//        3. Verify expected default text appears on big circle
//                Expected = "Drag the small circle here."
        Assert.assertEquals(practicePage.bigCirlce.getText(),"Drag the small circle here.");

    }

    @Test
    public void drop_here_text(){
//        TC #3: Cydeo Practice Drag and Drop Test
//        1. Open a chrome browser
//        2.  Go to:
//        https://practice.cydeo.com/drag_and_drop_circles


//        3. Click and hold small circle


//        4. Verify "Drop here." text appears on big circle
    }
}
