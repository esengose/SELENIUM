package day08_IFrame_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;
import utilities.TestBase;

public class Homework extends TestBase {
    @Test
    public void iFrameTest() {
        //    Bir class olusturun: IframeOdev
        //    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //    sayfadaki toplam iframe sayısını bulunuz.
        int totalFrame=driver.findElements(By.tagName("iframe")).size();
        System.out.println("totalFrame : "+totalFrame);

        //    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String pageTitle=driver.findElement(By.tagName("h3")).getText();
        System.out.println(pageTitle);
        Assert.assertTrue(pageTitle.contains("Editor"));

        //    Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//p[.='Your content goes here.']")).clear();

        //    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("iframein icindeyim");

        //    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String footertext=driver.findElement(By.xpath("(//a[@target='_blank'])[2]")).getText();
        System.out.println(footertext);
        Assert.assertTrue(footertext.contains("Elemental Selenium"));
    }
}