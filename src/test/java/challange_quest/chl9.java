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

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.getKeyFromUnicode;

public class chl9 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {

        // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//a[@href='#OKTab']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Thread.sleep(3000);

        //    accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(3000);


        //    cancel Alert  (Press a Button !)

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(2000);

        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("Techproeducation esen");
        driver.switchTo().alert().accept();

        //    finally print on console this mesaaje "Hello TechproEducation How are you today"

        String message = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        Assert.assertTrue(message.contains("esen"));

    }

}
