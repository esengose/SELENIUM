package day11_Action_JavaFaker_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework2 extends TestBase {
    @Test
    public void test() {

        //Bir Class olusturalim KeyboardActions2
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //video’yu gorecek kadar asagi inin
        Actions action =new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        //videoyu izlemek icin Play tusuna basin
        WebElement iFrame=driver.findElement(By.xpath("//iframe[@frameborder='0']"));
        driver.switchTo().frame(iFrame);
        WebElement buton=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        buton.click();
        //videoyu calistirdiginizi test edin
        Assert.assertTrue(buton.isEnabled());

    }
}