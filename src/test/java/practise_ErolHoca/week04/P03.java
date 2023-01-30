package practise_ErolHoca.week04;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P03 extends TestBase {
    /*- FAKER -
   Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
   gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
   Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
   çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
   bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
   değerler oluşturmanıza olanak tanır.
   Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
   projemize eklememiz gerekmektedir.
    */
    @Test
    public void test() {
        //"https://demoqa.com/automation-practice-form"  Adresine gidin
        driver.get("https://demoqa.com/automation-practice-form");
        // Formu doldurunuz
        Faker faker = new Faker();
        driver.findElement(By.id("firstName")).sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,faker.internet().emailAddress(),Keys.TAB,
        Keys.SPACE,Keys.TAB,faker.phoneNumber().cellPhone(),Keys.TAB,"20 Jul 2020",Keys.ENTER,Keys.TAB,"jdshfjşd",Keys.TAB,Keys.SPACE);

        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
        String filePath= "C:\\Users\\GamePower\\Desktop\\logo.jpeg";
        dosyaSec.sendKeys(filePath);

       //SHIFT E BASILIYKEN DOSYAYA SAĞ CLİCK YAPTIĞIMIZDA DOSYA YOLU KOPYALA ÇIKIYOR

        WebElement address = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        address.sendKeys(faker.address().fullAddress(),Keys.TAB,"NCR",Keys.ENTER,Keys.TAB,"Delhi");






        // Sayfayi kapatin
    }
}