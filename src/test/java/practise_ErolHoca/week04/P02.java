package practise_ErolHoca.week04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P02 extends TestBase {
    @Test
    public void test(){
        //     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        //     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement iframe= driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframe);
        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement yesilTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement maviTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(yesilTus,-175,0);//Genellikle slider' lar için bu method kullanılır
        actions.dragAndDropBy(maviTus,-80,0);
        actions.dragAndDropBy(yesilTus,301,0).release().build().perform();

        //     -Sarı olduğunu test edelim
        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        Assert.assertTrue(sari.isDisplayed());
        //assert.sari.isDisplayed();
    }
}
