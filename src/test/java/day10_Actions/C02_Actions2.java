package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {
    @Test
    public void hoverOverTest(){
        //Method : hoverOver() and test the following scenario:
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan “Account & Lists” menüsüne git


        //        1. ACTIONS OBJESI
        Actions actions = new Actions(driver);
//        2. ELEMANI BUL
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        waitFor(1);
//        2. UYGUN ACTIONS METHODUNU KULLAN. EN SONRA PERFORM KULLANAMAYI UNUTMA
        actions.moveToElement(accountList).perform();
        waitFor(3);

        //“Account” secenegine tikka
        driver.findElement(By.linkText("Account")).click();

        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));

    }
}
