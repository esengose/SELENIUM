package practise_ErolHoca.week02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P05 extends TestBase {
    @Test
    public void test() {
        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement firstframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(firstframe);
        driver.findElement(By.xpath("//*[@id='tinymce']")).clear();
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("Techproeducation");


        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumLinki = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumLinki.isDisplayed());

        // Elemental Selenium linkine tıklayın
        elementalSeleniumLinki.click();
        List<String> wwindowHandles = new ArrayList<>(driver.getWindowHandles());
        System.out.println(wwindowHandles);
        driver.switchTo().window(wwindowHandles.get(1));
         /*
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */

        // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println("Elemantal Selenium Sayfa Başlığı : "+driver.getTitle());

        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement sourceLabsLinki = driver.findElement(By.xpath("//*[text()='Sauce Labs']"));
        Assert.assertTrue(sourceLabsLinki.isDisplayed());

        // Source labs linkine tıklayın
        System.out.println("--------------------------------------------------");
        sourceLabsLinki.click();
        List<String> windowHandles2 = new ArrayList<>(driver.getWindowHandles());
        System.out.println(windowHandles2);
        driver.switchTo().window(windowHandles2.get(2));
        // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println("Source Labs Sayfa başlığı : "+driver.getTitle());
        driver.switchTo().window(windowHandles2.get(0));
        System.out.println("Sayfa url'i : "+driver.getCurrentUrl());
        // ilk sekmeyi kapatalım
        driver.close();
        driver.switchTo().window(windowHandles2.get(2));
        System.out.println(driver.getCurrentUrl());
    }

    }

