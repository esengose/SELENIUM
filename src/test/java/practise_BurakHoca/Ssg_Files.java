package practise_BurakHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Ssg_Files extends TestBase {
    @Test
    public void test01(){
        // Exercise 1...
        // masaustunde bir text dosyası olusturun
        // masaustundeki text dosyasının varlıgını test edin

        String pathFile= "C:\\Users\\GamePower\\Desktop\\fileHere.txt";
        boolean isFiles =Files.exists(Paths.get(pathFile));
        Assert.assertTrue(isFiles);
    }

    @Test
    public void test02(){
        // Exercise 2...
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. LambdaTest.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[.='LambdaTest.txt']")).click();

        //3. dosyanin bilgisayarınızda downloads'a basariyla indirilip indirilmedigini test ediniz
        String pathFile="C:\\Users\\GamePower\\Downloads\\LambdaTest.txt";
        boolean isDowloaded=Files.exists(Paths.get(pathFile));
        Assert.assertTrue(isDowloaded);
    }

    @Test
    public void test03(){
        // Exercise 3...
        // masaustunde bir deneme dosyası olusturun
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\GamePower\\Desktop\\fileHere.txt");

        // 'Upload' butonuna basın
        driver.findElement(By.id("file-submit")).click();

        // 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement fileUploadedTxt= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedTxt.isDisplayed());
    }
}
