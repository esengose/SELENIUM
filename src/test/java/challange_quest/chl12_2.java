package challange_quest;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class chl12_2 extends TestBase {
    @Test
    public void test() {

        // //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //    //2. "Hover over Me First" kutusunun ustune gelin
        Actions action = new Actions(driver);
        WebElement hoverOverFirst=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        action.moveToElement(hoverOverFirst).perform();

        //    //3. "Link 1" e tiklayin
        action.click(driver.findElement(By.xpath("(//*[@href='#'])[1]"))).perform();
        //    //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //    //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //    //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHold=driver.findElement(By.xpath("//div[@id='click-box']"));
        action.clickAndHold(clickAndHold).perform();

        //    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());

        //    //8. "Double click me" butonunu cift tiklayin
        action.doubleClick(driver.findElement(By.xpath("//div[@id='double-click']"))).perform();
        //    //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='div-double-click']")).isEnabled());
    }
}