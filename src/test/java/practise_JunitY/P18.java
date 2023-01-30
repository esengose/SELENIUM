package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class P18 extends TestBase {
/*  TODO
     Given
         Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"     (Siteye gidin)
     When
        Click on Ajax Loader         (ajax loader tıklayın)
     And
        Click on "Click Me!" button     (click me ye tıklamak için EXPLICIT WAIT METOT KULLANIN)
     Then
        Assert that button is clicked    (butonun tıklandığını doğrulayın)
     And
        Take screenshot after each step     (her aşamada sayfanın ekran görüntüsünü alın)
*/
    @Test
    public void test() throws IOException {
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        takeScreenShotOfPage();

        driver.findElement(By.xpath("//a[@href='../Ajax-Loader/index.html']")).click(); //ajax loader button

        waitForClickablility(By.id("button1"),5).click();  //explicit wait  //click butonun click edilebilmesini bekledik
        takeScreenShotOfPage();

        waitForVisibility(By.xpath("//h4[.='Well Done For Waiting....!!!']"),3); //
        String wellDoneText= driver.findElement(By.xpath("//h4[.='Well Done For Waiting....!!!']")).getText();
        Assert.assertTrue(wellDoneText.contains("Well Done"));
        System.out.println("wellDoneText = " + wellDoneText);
        takeScreenShotOfPage();
    }
}
