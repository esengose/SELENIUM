package practise_ErolHoca.week04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P06 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        driver.findElement(By.xpath("//input[@id='uploadfile_0']")).sendKeys("C:\\Users\\GamePower\\Desktop\\logo.jpeg");

        // I accept terms of service bölümünü tikleyin
        driver.findElement(By.xpath("//input[@id='terms']")).click(); //accept terms button

        // Submit File buttonuna basınız
        driver.findElement(By.xpath("//button[@id='submitbutton']")).click(); //submit buton

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        Thread.sleep(2000);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();


    }
}
