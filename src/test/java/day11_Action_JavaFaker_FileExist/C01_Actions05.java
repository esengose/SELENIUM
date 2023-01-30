package day11_Action_JavaFaker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions05 extends TestBase {
    @Test
    public void keyboardActionsTest(){
        //Create a class: Action5
        //Create a method keyboardActions
        //Google a gidin https://www.google.com
        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //ENTER a BAS
        driver.get("https://www.google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));
//        aramaKutusu.sendKeys("IPHONE X FIYATLARI" + Keys.ENTER);
        Actions actions = new Actions(driver);
        actions
                .keyDown(aramaKutusu,Keys.SHIFT)//arama kutusunun ustunde Shist tusuna bas
                .sendKeys("iPhone X fiyatlari")//shifte basiliyken yazi yaz
                .keyUp(aramaKutusu,Keys.SHIFT)//shift de artik basma
                .sendKeys("  cok pahali!"+Keys.ENTER)//normal halde yaz ve Enter tusuna bas
                .build()
                .perform();




    }
}
