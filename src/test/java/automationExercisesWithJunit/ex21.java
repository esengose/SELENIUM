package automationExercisesWithJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.time.Duration;

public class ex21 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
@Test
    public void test() throws InterruptedException {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
    driver.get("http://automationexercise.com");
//3. Click on 'Products' button
    driver.findElement(By.xpath("//a[@href='/products']")).click();
    driver.navigate().refresh();
    driver.findElement(By.xpath("//a[@href='/products']")).click();
    Thread.sleep(4000);
//4. Verify user is navigated to ALL PRODUCTS page successfully
    String expectedUrl="https://automationexercise.com/products";
    String actualUrl= driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl,actualUrl);
    Thread.sleep(2000);
//5. Click on 'View Product' button
    Actions action = new Actions(driver);
    action.sendKeys(Keys.END).perform();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@href='/product_details/8']")).click();
    Thread.sleep(2000);
//6. Verify 'Write Your Review' is visible
    driver.findElement(By.xpath("//*[@id='name']")).sendKeys("???", Keys.TAB,"dear_mear@gmail.com",Keys.TAB,"!!!");
//7. Enter name, email and review
    Thread.sleep(2000);
//8. Click 'Submit' button
    action.sendKeys(Keys.END).perform();
    Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='button-review']")).click();

//9. Verify success message 'Thank you for your review.'

}
}
