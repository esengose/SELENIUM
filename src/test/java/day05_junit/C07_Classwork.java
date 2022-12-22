package day05_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Classwork {
    //https://www.facebook.com adresine gidin
    //Cookies’i kabul edin
    //“Create an Account” button’una basin
    //“radio buttons” elementlerini locate edin
    //Secili degilse cinsiyet butonundan size uygun olani secin

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
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("esen");
        driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("gose");
        WebElement female = driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
        if(!female.isSelected()){
            female.click();
        }
        Thread.sleep(3000);


    }














}
