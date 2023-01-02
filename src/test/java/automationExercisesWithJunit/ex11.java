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

public class ex11 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void verifyCartPage() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String homePageUrl="https://automationexercise.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(homePageUrl,actualUrl);

        //4. Click 'Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        //5. Scroll down to footer
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //6. Verify text 'SUBSCRIPTION'
        WebElement subs=driver.findElement(By.tagName("h2"));
        System.out.println(subs.getText());
        subs.isDisplayed();

        //7. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("dear_mear@gmail.com", Keys.ENTER);

        //8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement successmessage=driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        System.out.println(successmessage.getText());
        successmessage.isDisplayed();
    }


}