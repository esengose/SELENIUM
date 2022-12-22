package day05_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Classwork {
    //https://www.youtube.com adresine gidin
    //Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //=> Sayfa başlığının “YouTube” oldugunu test edin
    //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin

    WebDriver driver;
    @Before
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void youtubetitle(){
    driver.get("https://www.youtube.com");
        String actualTitle=driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    @Test
    public void isDisplayed(){
        driver.get("https://www.youtube.com");
        WebElement youtubeLogo= driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeLogo.isDisplayed());
    }

    @Test
    public void isEnabled(){
        driver.get("https://www.youtube.com");
        WebElement searchbox= driver.findElement(By.xpath("//*[@class='ytd-searchbox-spt'] "));
        Assert.assertTrue(searchbox.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        driver.get("https://www.youtube.com");
        String actualTitle= driver.getTitle();
        String expectedWrongTitle="youtube";
        Assert.assertFalse(actualTitle.equals(expectedWrongTitle));
    }






}
