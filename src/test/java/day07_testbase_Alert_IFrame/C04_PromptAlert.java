package day07_testbase_Alert_IFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {
    @Test
    public void sendKeysMethod() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //butona tıklıyoruz
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        //metin kısmına istediğimiz bir ifadeyi yazıyoruz
        driver.switchTo().alert().sendKeys("esen");
        Thread.sleep(2000);
        //ok basarak tamam demiş oluyoruz
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        String actualresult=driver.findElement(By.id("result")).getText();
        String expected="esen";
        Assert.assertTrue(actualresult.contains(expected));

    }
}
