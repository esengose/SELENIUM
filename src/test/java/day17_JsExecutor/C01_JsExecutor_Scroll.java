package day17_JsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_JsExecutor_Scroll extends TestBase {
    @Test
    public void scrollIntoViewTest() throws IOException {
        //    ScrollIntoViewTest metotu olustur
        //    Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);
        //    We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al

        //1. Elementi bul
        WebElement weOffer =driver.findElement(By.xpath("//span[.='we offer']"));
        //2. js objesi oluştur
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //3. Yapmak istediğim işlemi js.executeScript methodu ile yap.
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        waitFor(3);
        takeScreenShotOfPage();

        //    Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement enrollFree =driver.findElement(By.xpath("//span[.='Enroll Free Course']"));
        scrollIntoViewJS(enrollFree);
        waitFor(3);
        takeScreenShotOfPage();

        //    Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        waitFor(3);
        takeScreenShotOfPage();

        //    Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(enrollFree);
        waitFor(3);
        takeScreenShotOfPage();

        scrollTopJS();  // reusable method--Sayfanın en üstüne gider.
        scrollEndJS();  // reusable method--Sayfanın en altına gider.



    }

}