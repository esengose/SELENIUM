package day04_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HomeworkCh {
    //1. ""https://www.saucedemo.com"" Adresine gidin
//2. Username kutusuna "standard_user" yazdirin
//3. Password kutusuna "secret_sauce" yazdirin
//4. Login tusuna basin
//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
//6. Add to Cart butonuna basin
//7. Alisveris sepetine tiklayin
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
//9. Sayfayi kapatin
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-test='username']")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-test='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='submit-button btn_action']")).click();
        Thread.sleep(2000);
        WebElement ilkUrun=driver.findElement(By.xpath("//*[@alt='Sauce Labs Backpack']"));
        ilkUrun.click();
        WebElement kaydedilenUrun=driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']"));
        System.out.println(kaydedilenUrun.getText());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@name='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
        Thread.sleep(2000);
        WebElement sepetteMi=driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
        if(sepetteMi.equals(ilkUrun)){
            System.out.println("urun sepete eklenmiştir");
        }else System.out.println("tekrar deneyiniz");
        Thread.sleep(2000);
        driver.close();





    }
}
