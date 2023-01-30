package practise_ErolHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //-"amazon.com" adresine gidelim
        driver.get("https://amazon.com/");

        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String currentTitle=driver.getTitle();
        String currentUrl= driver.getCurrentUrl();
        System.out.println("Current title: "+ currentTitle);
        System.out.println("Current url: "+ currentUrl);
        Thread.sleep(2000);

        //-title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(currentTitle.contains("spend") && currentUrl.contains("spend"));

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://trendyol.com/");
        Thread.sleep(2000);
        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim

        String trendyolTitle=driver.getTitle();
        Assert.assertFalse(trendyolTitle.contains("sitesi"));

        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
        Thread.sleep(2000);

        //-sayfayi yenileyelim
        driver.navigate().refresh();
        Thread.sleep(2000);

        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();

        driver.close();


    }
}
