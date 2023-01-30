package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P13 extends TestBase {
    /*
    Given
        Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
    When
        Click on "click me" button  (Hareketli bir buton olan click me ye tıklamaya çalış:))
    Then
        Verify that "Event Triggered"  ( "Event Triggered" yazısını doğrula)
    */
    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
        waitFor(4); //hard wait koymadığımda passed olsa da event triggered yazısı görünmüyor
        driver.findElement(By.xpath("//button[@id='growbutton']")).click();
        //implicitly wait olmasa çalışmayabiliyor çünkü buton büyüdüğünde çalışıyor.implicitliy wait, buton elementini beklediği için çalışıyor.

        String eventTriggeredText=driver.findElement(By.id("growbuttonstatus")).getText();
        Assert.assertEquals("Event Triggered",eventTriggeredText);
    }
}
