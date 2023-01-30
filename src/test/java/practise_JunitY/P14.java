package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class P14 extends TestBase {
     /*
    Given
        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html (Siteye gidin)
    When
        Click all the buttons   (Bütün butonlara tıklayın)
    Then
        Assert all buttons clicked (Bütün butonlara tıklandığını doğrulayın)
     */
    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        driver.findElement(By.id("onblur")).click();
        waitFor(2);
        driver.findElement(By.id("onclick")).click();  //onblur butonu için tıklandı
        waitFor(2);
        driver.findElement(By.id("onclick")).click(); //onclick butonu için tıklandı
        waitFor(2);
        Actions action = new Actions(driver);
        waitFor(2);
        action.contextClick(driver.findElement(By.id("oncontextmenu"))).perform();    //sağ click
        waitFor(2);
           action.doubleClick(driver.findElement(By.id("ondoubleclick"))).perform();     //çift click
        waitFor(2);
           action.click(driver.findElement(By.id("onfocus"))). perform();                //tuşun üzerinde tıklanmalı
        waitFor(2);
           action.click(driver.findElement(By.id("onkeydown"))).sendKeys(Keys.ENTER).perform();  //butona basarken bir tuşa daha basılmalı
        waitFor(2);
           action.click(driver.findElement(By.id("onkeyup"))).sendKeys(Keys.ENTER).release().perform(); //butona basıp serbest bırakılmalı
        waitFor(2);
           action.click(driver.findElement(By.id("onkeypress"))).sendKeys(Keys.ENTER).perform(); //butona basılırken bir tuşa daha basılmalı
        waitFor(2);
           action.moveToElement(driver.findElement(By.id("onmouseover"))). perform(); //hover over - üzerinde beklenmeli
        waitFor(2);
           action.moveToElement(driver.findElement(By.id("onmouseleave"))).perform(); //üzerinde bekleyip çekilmeli
        waitFor(2);
        (action.click(driver.findElement(By.id("onmousedown")))).perform(); // onmouse leave butonu için çalıştı
           action.click(driver.findElement(By.id("onmousedown"))). //click yaptıktan sonra çekilmeli
                build().perform();

           List<WebElement> eventTrigText=driver.findElements(By.xpath("//p[text()='Event Triggered']"));
        System.out.println("eventTrigText.size() = " + eventTrigText.size());
        Assert.assertEquals(11,eventTrigText.size());


    }
}
