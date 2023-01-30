package practise_ErolHoca.week03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04 extends TestBase {
    //google sayfasina gidelim
    //Buyuk kucuk harf olucak sekilde "HeLlO" yazdiralim

    @Test
    public void test(){
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o",Keys.SHIFT);
    }
}
