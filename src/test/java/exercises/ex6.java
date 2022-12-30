package exercises;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ex6 {
    Faker faker = new Faker();
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void contactUs() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        driver.navigate().to("http://automationexercise.com");
        String homepageurl="https://automationexercise.com/";
        String actualurl= driver.getCurrentUrl();
        Assert.assertEquals(homepageurl,actualurl);

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement contact= driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        System.out.println(contact.getText());
        contact.isDisplayed();

        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("about account info");
        driver.findElement(By.xpath("//*[@id='message']")).sendKeys("ghvbnjlkgvikfdömgğbvli,fdömkbgğ,fdsökgğb");

        //7. Upload file
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\GamePower\\Desktop\\SELENIUM\\Selenyum methods1.txt");

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement success = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        System.out.println(success.getText());
        success.isDisplayed();
        Thread.sleep(2000);

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
        String actualURL = driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals("https://automationexercise.com/", actualURL);

    }


}