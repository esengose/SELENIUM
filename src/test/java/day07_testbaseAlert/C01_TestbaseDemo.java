package day07_testbaseAlert;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestbaseDemo extends TestBase {
/*
   UTILITIES:
   - Utilities tekrar tekrar kullanacagimiz class'lari koydugumuz paketin adidir.
        - TestBase -> Bugun
        - Driver -> Sonra
        - ExcelUtil -> Sonra
        - Configuration -> Sonra
   - Utilities paketinde Test case'ler yazilmaz.
   - Sadece tekrar kullanilabilecek destek siniflari(Support Class) olusturulur.
   - Bu support class'lar test case'lerin yazilmasini hizlandirir.
 */
    @Test
    public void test01(){
        //techpro anasayfasya git ve title ın boothcamp kelimesini içerdiğini test et
        driver.get("https://techproeducation.com");
        String pageTitle=driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));
    }




}
