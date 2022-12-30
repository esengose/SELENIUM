package exercises;

import com.github.javafaker.Faker;
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

public class ex5 {
    Faker faker= new Faker();
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void existingMail(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        driver.navigate().to("http://automationexercise.com");
        String homepageurl="https://automationexercise.com/";
        String actualurl= driver.getCurrentUrl();
        Assert.assertEquals(homepageurl,actualurl);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUser=driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        System.out.println(newUser.getText());
        newUser.isDisplayed();

        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("hello dear");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("dear_mear@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. Verify error 'Email Address already exist!' is visible
        WebElement error= driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
        System.out.println(error.getText());
        error.isDisplayed();

    }
    @After
    public void tearDown(){
        driver.close();
    }
}
