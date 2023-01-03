package day08_IFrame_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Homework2 extends TestBase {
    @Test
    public void test() {
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        //Title'in "Windows" oldugunu test edin
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Windows"));
        //Click here a tiklayin
        driver.findElement(By.xpath("//*[@target='_blank']")).click();
        //Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin
                                //1.yol
        /*String firstW= driver.getWindowHandle();
        Set<String> newWindows=driver.getWindowHandles();
        for(String w: newWindows){
            if(!w.equals(firstW)){
                driver.switchTo().window(w);

            }
        }*/
                                //2.yol
        switchToWindow("New Window");

        String newTitle= driver.getTitle();
        Assert.assertTrue(newTitle.contains("New Window"));

    }
}