package day11_Action_JavaFaker_FileExist;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Homework4 extends TestBase {
    @Test
    public void test() {

        //Faker Kutuphanesi HOMEWORK
//Faker class'i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
//degerler uretmemize imkan tanir.
//Faker degerler uretmek icin Faker class'indan bir obje uretir ve var olan method'lari kullaniriz.
//"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
//"create new account"  butonuna basin
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();

//"firstName" giris kutusuna bir isim yazin
        Faker faker =new Faker();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,faker.internet().password(),Keys.TAB,Keys.TAB,"10",Keys.TAB,"01",Keys.TAB,"1989");

//"surname" giris kutusuna bir soyisim yazin
//"email" giris kutusuna bir email yazin
//"email" onay kutusuna emaili tekrar yazin
//Bir sifre girin
//Tarih icin gun secin
//Tarih icin ay secin
//Tarih icin yil secin
//Cinsiyeti secin
//Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement female=driver.findElement(By.xpath("//input[@value='1']"));
        female.click();
        WebElement male=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement other=driver.findElement(By.xpath("//input[@value='-1']"));

        Assert.assertTrue(female.isSelected());
        Assert.assertFalse(male.isSelected());
        Assert.assertFalse(other.isSelected());
//Sayfayi kapatin

    }
}