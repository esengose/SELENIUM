package day14_Screenshot_ExtentReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_ScreenShot2 extends TestBase {
    @Test
    public void test() throws IOException {
        //Techproya gidiniz
        driver.get("https://techproeducation.com/");


//        Sosyal medya elemanlarını goruntusunu al
//        1. ekran goruntusunu ek
        WebElement sosyalMedyaIconlari=driver.findElement(By.xpath("(//div[@class='elementor-widget-container'])[1]"));
        File image = sosyalMedyaIconlari.getScreenshotAs(OutputType.FILE);
//        2. goruntuyu kaydet
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));


        //logonun ekran görüntüsünü al
        takeScreenshotOfElement(driver.findElement(By.xpath("//img[@class='attachment-large size-large lazyloaded']")));




    }
}
