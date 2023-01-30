package works;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class W03 extends TestBase {
    @Test
    public void test() {
        //sahibinden.coma gidin
        //anasayfada oldugunuzu dogrulayin
        driver.get("https://sahibinden.com");
        String actualPage = driver.getCurrentUrl();
        String expectedPage = "https://www.sahibinden.com/";
        Assert.assertEquals(expectedPage, actualPage);

        //detayli arama tiklayin
        driver.findElement(By.xpath("//a[@title='Detaylı Arama']")).click();

        //detayli arama sayfasina geldiginizi dogrulatin
        Assert.assertEquals("https://www.sahibinden.com/arama/detayli", driver.getCurrentUrl());

        //emlak-konut-satilik seceneklerini secip
        driver.findElement(By.xpath("//span[text()='Emlak']")).click();
        driver.findElement(By.xpath("//span[text()='Konut']")).click();
        driver.findElement(By.xpath("//span[text()='Satılık']")).click();

        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
            detaylıKonum("İzmir","Bornova","Atatürk Mh.");

        //cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin

    }

    public void detaylıKonum(String il, String ilce, String mah) {
        WebElement cerezKabul=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        driver.findElement(By.xpath("//*[@class='faceted-select']")).click();  //İL KUTUSU
        WebElement ilelement =driver.findElement(By.xpath("//input[@placeholder='İl']")); //İL GİRDİĞİMİZ ALAN
        ilelement.sendKeys(il);  //DİNAMİK İL İSMİ
        waitFor(3);
        driver.findElement(By.xpath("//a[contains(text(),'" + il + "')]")).click();  // TEXTTE DİNAMİK OLARAK VERİLEN İLİ SEÇ
        WebElement menudenCık= driver.findElement(By.xpath("//a[@class='collapse-pane']"));


        driver.findElement(By.xpath("(//*[@class='faceted-select'])[2]")).click();  //İLÇE KUTUSU
        if(cerezKabul.isDisplayed()) cerezKabul.click();
        WebElement ilcelement=driver.findElement(By.xpath("//input[@placeholder='İlçe']")); //İLÇEYİ DİNAMİK OLARAK GİRDİĞİMİZ ALAN
        ilcelement.sendKeys(ilce); //İLÇE İSMİ GİR
        waitFor(3);
        driver.findElement(By.xpath("//a[contains(text(),'" + ilce + "')]")).click(); //TEXXTE DİNAMİK OLARAK VERİELN İLÇEYİ SEÇ
        //Actions action =new Actions(driver);
        //action.doubleClick(menudenCık);
        menudenCık.click();


        driver.findElement(By.xpath("//a[normalize-space()='Semt']"));//MH KUTUSU
        if(cerezKabul.isDisplayed()) cerezKabul.click();
        WebElement mhelement=driver.findElement(By.xpath("//input[@placeholder='Semt / Mahalle']"));
        mhelement.sendKeys(mah);
        waitFor(3);
        driver.findElement(By.xpath("//a[contains(text(),'" + ilce + "')]")).click();
        menudenCık.click();
    }

}