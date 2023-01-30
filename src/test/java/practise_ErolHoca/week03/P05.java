package practise_ErolHoca.week03;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P05 extends TestBase {
    @Test
    public void test(){
        /*
        -http://spicejet.com/ sayfasına gidelim
        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        -Sayfa başlığının Fleet içerdiğini test edelim
     */
        driver.get("http://spicejet.com/");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[text()='About Us']"))).perform();
        driver.findElement(By.xpath("//div[text()='Fleet']")).click();
        waitFor(3);
        switchToWindow(1);
        Assert.assertTrue(driver.getTitle().contains("Fleet"));

    }
}
