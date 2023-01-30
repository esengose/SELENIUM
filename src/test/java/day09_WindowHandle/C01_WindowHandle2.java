package day09_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle2 extends TestBase {
    @Test
    public void test() {


//        https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

//        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualtWindowText=driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();
        String expectedWindowText="Opening a new window";
        Assert.assertEquals(actualtWindowText,expectedWindowText);

//        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertTrue(actualTitle.equals(expectedTitle));

//        Click Here butonuna basın.
        driver.findElement(By.xpath("(//*[@target='_blank'])[1]")).click();

        /////İKİNCİ PENCERE AÇILIR////////////////BURDA İŞLEM YAPMAK İSTEDİĞİMDEN O PENCEREYE SWITCH YAPMALIYIZ

       waitFor(3);
        switchToWindow(1);  //2.windowa geçiş yaptık, driver artık 2.windowda

//        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualWTitle= driver.getTitle();
        String expectedWTitle="New Window";
        Assert.assertTrue(actualTitle.equals(expectedTitle));











    }
}