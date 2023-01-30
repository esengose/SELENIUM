package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P05 extends TestBase {
    @Test
    public void test() {
      /*
        Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        When
        Click "CLICK ME" of JavaScript Alert
        And
        Get the Alert text
        Then
        Verify that message is "I am an alert box!"
        When
        Accept Alert
         */
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.xpath("//span[@id='button1']")).click();

        String alertText=driver.switchTo().alert().getText();
        Assert.assertEquals("I am an alert box!",alertText);

        driver.switchTo().alert().accept();


    }
}