package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P07 extends TestBase {
    @Test
    public void test() {

    /*
    Given
    Go to https://demo.guru99.com/test/drag_drop.html ( Siteye gidin)
    When
    Drag orange element on proper boxes below them  (Turuncu blokları aşağıda belirli kutulara drag drop methoduyla taşıyın)( HER BLOK TAŞINMIYOR, YALNIZCA BAZILARI)
    Then
    Verify they are dropped  (drag drop ları doğrulayın // bitirince perfect yazısı çıkıyor)
     */
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        WebElement dragAmount1=driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement dropBox2=driver.findElement(By.xpath("//ol[@id='amt7']"));

        WebElement dragBank =driver.findElement(By.id("credit2"));
        WebElement dropBox1 = driver.findElement(By.id("bank"));

        WebElement dragSale=driver.findElement(By.id("credit1"));
        WebElement dropBox3=driver.findElement(By.id("loan"));

        WebElement dragAmount2=driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));
        WebElement dropBox4=driver.findElement(By.id("amt8"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragBank,dropBox1).
                dragAndDrop(dragAmount1,dropBox2).
                dragAndDrop(dragSale,dropBox3).
                dragAndDrop(dragAmount2,dropBox4).perform();

        String perfectMessage= driver.findElement(By.xpath("(//a[@class='button button-green'])[1]")).getText();

        Assert.assertEquals("Perfect!",perfectMessage);

    }
}