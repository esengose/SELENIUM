package practise_ErolHoca.week03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P07 extends TestBase {
    @Test
    public void test(){
        // - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        //    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        //    - Son olarak sayfayı temizleyiniz
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement board=driver.findElement(By.xpath("//canvas"));
        Actions action = new Actions(driver);
        action.moveToElement(board).clickAndHold();

        for (int i = 0; i < 10; i++) {
            action.moveByOffset(5,-5);
        }
        for(int i=0; i<10; i++){
            action.moveByOffset(5,5);
        }
        for (int i = 0; i < 10; i++) {
            action.moveByOffset(5,-5);
        }
        for (int i = 0; i < 10; i++) {
            action.moveByOffset(5,5);
        }

        action.release().build().perform();

    }
}
