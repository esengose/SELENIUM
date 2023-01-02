package practise_ErolHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test02(){
        //       https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //       cookies uyarisini kabul ederek kapatin

        //       Sayfa basliginin “Google” ifadesi icerdigini test edin
        String title= driver.getTitle();
        Assert.assertTrue(title.contains("Google"));

        //       Arama cubuguna “Nutella” yazip aratin
    driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //       Bulunan sonuc sayisini yazdirin
      String [] sonucsayisi= driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println(sonucsayisi[1]);


        //       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonuc=sonucsayisi[1];
        sonuc=sonuc.replaceAll("\\D","");
        System.out.println(sonuc);
        int istenensayi=10000000;
        Assert.assertTrue(Integer.parseInt(sonuc)>10000000);
        //       Sayfayi kapatin
        driver.close();
    }
}
