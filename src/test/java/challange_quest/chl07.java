package challange_quest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class chl07 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
    }
    @Test
    public void bookTest() {
        //1-https://books-pwakit.appspot.com/ adresine gidin.
        driver.get("https://books-pwakit.appspot.com/");
        //2-"BOOKS" başlığının görünür olduğunu doğrulayın

        WebElement books= driver.findElement(By.xpath("//*[text()='BOOKS']"));
        Assert.assertTrue("passed", books.isDisplayed());

        //3-Arama çubuğunda "Selenium" u aratın.
        WebElement searchbx = driver.findElement(By.xpath("//book-app[@apptitle='BOOKS']"));
        searchbx.sendKeys("selenium",ENTER);


        //4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.


    }






}
