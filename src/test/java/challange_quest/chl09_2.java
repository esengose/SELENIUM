package challange_quest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

import static org.openqa.selenium.Keys.ENTER;

public class chl09_2 extends TestBase{




    @Test
    public void test() throws InterruptedException {


        //url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

        //       ilk pencereyi al
        String windowhandle1=driver.getWindowHandle();
        //       "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//a[@href='../articles_popup.php']")).click();

        //       setteki tüm pencereyi al
        Set<String>allWindows=driver.getWindowHandles();

        //       diğer pencereye geç
        for(String w: allWindows){
            if(!w.equals(windowhandle1)){
                driver.switchTo().window(w);
            }
        }

        //       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("somepne@gmail.com");

        //       Gönder düğmesine tıklayarak
        driver.findElement(By.name("btnLogin")).click();
        //       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
       WebElement validText=driver.findElement(By.xpath("//*[text()='This access is valid only for 20 days.']"));
        System.out.println(validText.getText());
        Assert.assertTrue(validText.isDisplayed());
        //       Tekrar ilk pencereye geç
        driver.switchTo().window(windowhandle1);
        //       İlk pencerede olduğunu doğrula
        String expectedUrl="https://demo.guru99.com/popup.php";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);


    }
}