package automationExercisesWithJunit;

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

public class ex4 {
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
    public void logOutUser(){
        //        1. Launch browser
        //        2. Navigate to url 'http://automationexercise.com'
        //        3. Verify that home page is visible successfully
        driver.navigate().to("http://automationexercise.com");
        String homepageurl="https://automationexercise.com/";
        String actualurl= driver.getCurrentUrl();
        Assert.assertEquals(homepageurl,actualurl);

        //        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //        5. Verify 'Login to your account' is visible
        WebElement login=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        System.out.println(login.getText());
        login.isDisplayed();

        //        6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("dear_mear@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
        //        7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //        8. Verify that 'Logged in as username' is visible
        WebElement logAS = driver.findElement(By.partialLinkText("Logged in as"));
        System.out.println(logAS.getText());
        logAS.isDisplayed();

        //        9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        //        10. Verify that user is navigated to login page
       String logInpageUrl= "https://automationexercise.com/login";
       String currenturl= driver.getCurrentUrl();
       Assert.assertEquals(logInpageUrl,currenturl);

    }

    @After
    public void tearDown(){
        driver.close();
    }



}
