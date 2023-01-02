package challange_quest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class chl10 extends TestBase {
    @Test
    public void test() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

//Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();

//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement selectText=driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
        System.out.println(selectText.getText());
        Assert.assertTrue(selectText.isDisplayed());

//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();

//New Tab butonunun görünür olduğunu doğrula
        WebElement tabButton=driver.findElement(By.xpath("//button[@id='tabButton']"));
        System.out.println(tabButton.getText());
        Assert.assertTrue(tabButton.isDisplayed());

//New Tab butonuna click yap
        tabButton.click();
//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        String firstwindow=driver.getWindowHandle();
        Set<String> allWindows=driver.getWindowHandles();
        for(String w: allWindows){
            if(!w.equals(firstwindow)){
                driver.switchTo().window(w);
            }
        }
        WebElement samplePage=driver.findElement(By.id("sampleHeading"));
        System.out.println(samplePage.getText());
        Assert.assertTrue(samplePage.isDisplayed());

//İlk Tab'a geri dön
        driver.switchTo().window(firstwindow);
////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(tabButton.isDisplayed());
    }
}