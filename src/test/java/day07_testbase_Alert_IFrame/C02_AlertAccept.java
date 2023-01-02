package day07_testbase_Alert_IFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertAccept extends TestBase {
    //Bir class olusturun: Alerts
    //https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “You clicked: Cancel” oldugunu test edin.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    @Test
    public void acceptAlertTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//        1. butona tıklayın,
//        uyarıdaki OK butonuna tıklayın
//        ve result mesajının
//       “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);
    }
    /*
    *Alertleri nasil automate edersin? How to handle alerts in selenium?
    -Alertler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir.
     */
    }



