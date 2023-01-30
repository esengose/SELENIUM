package practise_ErolHoca.week04;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Random;

public class P01 extends TestBase {
    @Test
    public void test(){
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        Faker faker = new Faker();
        String num1rakam1=faker.number().digits(2);
        String num1rakam2=faker.number().digits(2);
       driver.findElement(By.xpath("//span[.='")).click();
         //       +driver.findElement(By.xpath("//span[@class='btn btn-outline-primary'"+num1rakam2+"]"));
       // driver.findElement(By.xpath("//div[@class='screen']")).sendKeys(num1rakam1)




        //Sonucu konsola yazdırıp

        //Sonucun doğrulamasını yapalım
    }
}
