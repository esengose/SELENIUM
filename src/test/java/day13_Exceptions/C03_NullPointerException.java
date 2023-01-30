package day13_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException extends TestBase {
    //Değişken oluşturup instantiate etmediğimizde - new kelimesini kullanmadığımızda - alırız
    //WebDriver driver deyip = new ChromeDriver() demezsek NullPointer alırız
    WebDriver driver;
    Faker faker;
    @Test
    public void test(){
      //  driver= new ChromeDriver();   initiate etmeliyiz
        driver.get("https://www.techproeducation.com");  //java.lang.NullPointerException

    }

    @Test
    public void test2(){
       // faker=new Faker();         initiate etmeliyiz
        System.out.println(faker.name().fullName());     // java.lang.NullPointerException
    }
}
