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

public class ex2 {
    WebDriver driver;
    Faker faker= new Faker();

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void correctEmail(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String homePageurl= "https://automationexercise.com/";
        String actualurl= driver.getCurrentUrl();
        Assert.assertEquals(homePageurl,actualurl);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginAccount= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        System.out.println(loginAccount.getText());
        loginAccount.isDisplayed();

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("tai.heathcote@yahoo.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");

        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Verify that 'Logged in as username' is visible
        driver.findElement(By.partialLinkText("Logged in as")).isDisplayed();

        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDeleted= driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        System.out.println(accountDeleted.getText());
        accountDeleted.isDisplayed();

    }

    @After
    public void tearDown(){
        driver.close();
    }




}
