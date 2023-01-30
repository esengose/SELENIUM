package works;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class W01 extends TestBase {
    @Test
    public void test() {

             //https://www.trendyol.com.adresine/ gidin
        driver.get("https://trendyol.com");

            //anasayfada oldugunuz dogrulayin
        String anasayfa="https://www.trendyol.com/";
        String actual=driver.getCurrentUrl();
        Assert.assertEquals(anasayfa,actual);
        driver.switchTo().alert().accept();

            //sayfanin en altinda biz kimiz kismina tiklayin ve aciklama sayfasina gittiginiz dogrulayin
        driver.findElement(By.xpath("//a[@href='/international.html/tr#whoWeAre']")).click();

            //ana sayfaya geri donun

            //yine sayfanin en altinda ulke degistire tiklayip germany secenegini secin

            //ve sayfanizin trendyol germany oldugunu dogrulayin
    }
}