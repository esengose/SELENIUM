package practise_ErolHoca.week02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P03 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String ilkWindowhnd= driver.getWindowHandle();
        //    - youtube videosunu çalıştırınız
        WebElement iframe=driver.findElement(By.xpath("//*[@class='render']/iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();

        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();
        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        //    - iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        Thread.sleep(3000);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String [] aramaSonuc = driver.findElement
                        (By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).
                getText().split(" ");
        System.out.println("arama sonuç sayısı= "+aramaSonuc[2]);

        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(ilkWindowhnd);
        System.out.println(driver.getCurrentUrl());
        //    - ilk sekmeyi kapatalım
        driver.close();
        //    - Sonra diğer sekmeyide kapatalım

    }
}