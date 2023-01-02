package automationExercisesWithJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ex10 {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void verifySubscription() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String homePageUrl="https://automationexercise.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(homePageUrl,actualUrl);

        //4. Scroll down to footer
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.END).perform();


        //5. Verify text 'SUBSCRIPTION'
        driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed();

        //6. Enter email address in input and click arrow button
        WebElement email=driver.findElement(By.id("susbscribe_email"));
        email.sendKeys("dear_mear@gmail.com",Keys.ENTER);
        Thread.sleep(1000);

        //7. Verify success message 'You have been successfully subscribed!' is visible
         WebElement successMessage= driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
        // WebElement successMessage= driver.findElement(By.xpath("//div[@class='alert-success alert']"));
         Thread.sleep(3000);
         System.out.println(successMessage.getText());
         Thread.sleep(3000);
         successMessage.isDisplayed();

         driver.close();
    }





}
