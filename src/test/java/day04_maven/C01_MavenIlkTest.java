package day04_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1https://www.amazon.com/ sayfasina gidelim
//2arama kutusunu locate edelim
//3"Samsung headphones" ile arama yapalim
//4Bulunan sonuc sayisini yazdiralim
//5Ilk urunu tiklayalim
//6Sayfadaki tum basliklari yazdiralim

        driver.get("https://amazon.com/");
        WebElement searchbox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchbox.sendKeys("Samsung headphones");
        searchbox.submit();

        WebElement aramasonucu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(aramasonucu.getText());

        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        List<WebElement> sayfabasliklariList = driver.findElements(By.xpath("//h1"));
        for (WebElement w : sayfabasliklariList) {
            System.out.println(w.getText());
        }






    }

}

