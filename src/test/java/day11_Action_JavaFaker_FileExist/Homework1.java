package day11_Action_JavaFaker_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Homework1 extends TestBase {
    @Test
    public void test1() {
        //Test01 :  1- amazon gidin
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        driver.get("https://www.amazon.com");
        WebElement dropMenu = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(dropMenu);
        List<WebElement> dropList = select.getOptions();
        for (WebElement w : dropList) {
            System.out.println(w.getText());
        }
        //dropdown menude 40 eleman olduğunu doğrulayın
        System.out.println("dropList.size() = " + dropList.size());
        Assert.assertFalse(dropList.size() == 40);
    }

    @Test
    public void test02() {
        //Test02
        //dropdown menuden elektronik bölümü seçin
        driver.get("https://www.amazon.com");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);
        String[] sonuc = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().split(" ");
        waitFor(3);
        System.out.println("iphone sonuc sayısı = " + sonuc[2]);
        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonuc[5].contains("iphone"));

        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("//img[@data-image-index='1']"));
        WebElement ucuncuUrun = driver.findElement(By.xpath("//img[@data-image-index='3']"));
        WebElement ikinciUrun = driver.findElement(with(By.tagName("img")).below(ilkUrun).above(ucuncuUrun));
        ikinciUrun.click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim


    }

    //Test03
    @Test
    public void test03() {
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com.tr");

        //dropdown’dan bebek bölümüne secin
        WebElement dropMenu = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(dropMenu);
        select.selectByVisibleText("Bebek");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset"+ Keys.ENTER);
        String []sonuc= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().split(" ");
        System.out.println("bebek puset araması sonuc sayısı = " + sonuc[0] + " " +sonuc[1]);

        //sonuç yazsının puset içerdiğini test edin
        String sonucYazı=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(sonucYazı.contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement urun2= driver.findElement(By.xpath("//img[@data-image-index='2']"));
        WebElement urun4= driver.findElement(By.xpath("//img[@data-image-index='4']"));
        WebElement urun3= driver.findElement(with(By.tagName("img")).toRightOf(urun2).toLeftOf(urun4));
        driver.findElement(By.xpath("//span[@id='a-autoid-0']")).click();
        urun3.click();
        //Actions action = new Actions(driver);
        //action.moveToElement(urun3).click(urun3).perform();



        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String urun3Title=driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String urun3Fiyat=driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();
        System.out.println("urun3Title = " + urun3Title);
        System.out.println("urun3Fiyat = " + urun3Fiyat);
        driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();

        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
        String sepetTitle= driver.findElement(By.partialLinkText("Bebebebek")).getText();
        String sepetFiyat=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]")).getText();
        System.out.println("sepetTitle = " + sepetTitle);
        System.out.println("sepetFiyat = " + sepetFiyat);
        Assert.assertTrue(sepetTitle.contains("Bebebebek"));
        Assert.assertEquals("229,90 TL",sepetFiyat);
    }
}