package challange_quest;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class chlday14 extends TestBase {
    /* https://www.n11.com/ ' da
     Decision table testing yaparak tum olasiliklar icin login page'in bize verecegi responselari test edin.
     n11ValidEmail=test.123.yap@gmail.com
             n11ValidPassword=Deneme123!
 */
    public void testDenemeBirKi(String email, String password){
        driver.get("https://www.n11.com/");
        WebElement girisYap = driver.findElement(By.xpath("//a[@title='Giriş Yap']"));
        girisYap.click();
       // String n11ValidEmail = "test.123.yap@gmail.com";
        //String n11ValidPassword = "Deneme123!";
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        emailKutusu.sendKeys(email);
        passwordKutusu.sendKeys(password);
        WebElement submitButton = driver.findElement(By.xpath("//div[@id='loginButton']"));
        submitButton.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(//button[@class='dn-slide-deny-btn'])[1]")).click();
        waitFor(5);
    }

    @Test
    public void test1() {
        String n11ValidEmail = "test.123.yap@gmail.com";
        String n11ValidPassword = "Deneme123!";

        testDenemeBirKi(n11ValidEmail,n11ValidPassword);

         Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Hesabım']")).isDisplayed());
    }
    @Test
    public void test2(){
        String n11ValidEmail = "test.123.yap@gmail.com";
        String n11ValidPassword = "Deneme123!";

        testDenemeBirKi("geçersiz","geçersiz");
       //String sonuc= driver.findElement(By.xpath("//div[text()='Lütfen geçerli bir e-posta adresi girin.']")).getText();

    }
    @Test
    public void test3(){
        String n11ValidEmail = "test.123.yap@gmail.com";
        String n11ValidPassword = "Deneme123!";

        testDenemeBirKi(n11ValidEmail,"geçersiz");
        String sonuc=driver.findElement(By.xpath("//div[text()='E-posta adresiniz veya şifreniz hatalı']")).getText();
    }
    @Test
    public void test4(){
        String n11ValidEmail = "test.123.yap@gmail.com";
        String n11ValidPassword = "Deneme123!";

        testDenemeBirKi("geçersiz",n11ValidPassword);
        String sonuc= driver.findElement(By.xpath("//div[text()='Lütfen geçerli bir e-posta adresi girin.']")).getText();
    }

}