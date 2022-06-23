package com.cydeo.test.day16_actions_jsExecutor;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DragAndDrop {

    @Test
    public void drag_and_drop_test(){
        //    1- Open a chrome browser
//    2- Go to: https://demo.guru99.com/test/drag_drop.html
        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");
        Actions actions = new Actions(Driver.getDriver());

//    3- Drag “BANK” and drop into Account area under Debit Side
        WebElement bank = Driver.getDriver().findElement(By.partialLinkText("BANK"));
        WebElement debitSide = Driver.getDriver().findElement(By.id("bank"));
        actions.dragAndDrop(bank,debitSide).perform();

//    4- Drag “5000” and drop into Amount area under Debit Side
        WebElement amount5000 = Driver.getDriver().findElement(By.linkText("5000"));
        WebElement amountDebit = Driver.getDriver().findElement(By.id("amt7"));
        actions.dragAndDrop(amount5000,amountDebit).perform();

//    5- Drag “SALES” and drop into Account area under Credit Side
        WebElement sales = Driver.getDriver().findElement(By.partialLinkText("SALES"));
        WebElement accountCredit = Driver.getDriver().findElement(By.id("loan"));
        actions.dragAndDrop(sales,accountCredit).perform();

//    6- Drag “5000” and drop into Amount area under Credit Side
        WebElement fiveK = Driver.getDriver().findElement(By.linkText("5000"));
        WebElement amountCredit = Driver.getDriver().findElement(By.id("amt8"));
        actions.dragAndDrop(fiveK,amountCredit).perform();

//    7- Verify “Perfect!” text displayed.
        WebElement msg = Driver.getDriver().findElement(By.linkText("Perfect!"));
        Assert.assertEquals(msg.getText(),"Perfect!");

        Driver.closeDriver();
    }
}
