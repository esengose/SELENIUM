package practise_ErolHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P11 extends TestBase {
    @Test
    public void test() {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        TestBase.driver.get("http://demo.guru99.com/test/guru99home/");
        //    //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iFrame= TestBase.driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe sayısı :"+iFrame.size());

        //    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement frame= TestBase.driver.findElement(By.xpath("//*[@wmode='transparent']"));
        TestBase.driver.switchTo().frame(frame);
        TestBase.driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();
        //    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        TestBase.driver.switchTo().defaultContent();
        //    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //    //tıklayınız
        WebElement frame2= TestBase.driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        TestBase.driver.switchTo().frame(frame2);
        TestBase.driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
    }
}