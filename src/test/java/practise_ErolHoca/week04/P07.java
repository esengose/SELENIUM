package practise_ErolHoca.week04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class P07 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        WebElement browser = driver.findElement(By.xpath("(//*[@type='button'])[83]"));
        actions.moveToElement(browser).perform();

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım

        driver.findElement(By.xpath("(//*[@class='XqQF9c'])[2]")).click();
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));

        //Açılan pencerede chromedriver'i indirelim
        WebElement chromeDriver = driver.findElement(By.xpath("//*[.='chromedriver_win32.zip']"));
        chromeDriver.click();
        Thread.sleep(5);

        //Driver'in indiğini doğrulayalım
        String dosyaYolu="C:\\Users\\GamePower\\Downloads\\chromedriver_win32 (4).zip";
        boolean isDownloaded= Files.exists(Paths.get(dosyaYolu));
        Assert.assertTrue(isDownloaded);
    }
}
