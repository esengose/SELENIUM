package day07_testbase_Alert_IFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_iFrame extends TestBase {
    @Test
    public void test01() throws InterruptedException {

//        https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        Thread.sleep(5000);

//        Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String metin=driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        String expected="black border";
        Assert.assertTrue(metin.contains(expected));

//        Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //Application lists  iframe in içinde, iframe i switch yapmamız gerekiyor
        driver.switchTo().frame(0); //index sıfırdan başlar
        String text= driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        String expectedtext = "Applications lists";
        Assert.assertEquals(text,expectedtext);



//        Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));
    }
}