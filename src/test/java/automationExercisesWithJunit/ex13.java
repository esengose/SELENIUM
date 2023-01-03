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
import utilities.TestBase;

import java.time.Duration;

public class ex13  {
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
        //3. Verify that home page is visible successfully
        WebElement homePage=driver.findElement(By.tagName("body"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click 'View Product' for any product on home page
        Actions action= new Actions(driver);
        action.sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/product_details/3']")).click();
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/product_details/3']")).click();

        //5. Verify product detail is opened
        String expectedUrl="https://automationexercise.com/product_details/3";
        String actualUrl=driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals(expectedUrl,actualUrl);

        //6. Increase quantity to 4
        driver.findElement(By.xpath("//input[@id='quantity']")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys("4");
        Thread.sleep(3000);
        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//*[@class='btn btn-default cart']")).click();
        Thread.sleep(4000);

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        Thread.sleep(3000);
        //9. Verify that product is displayed in cart page with exact quantity
        WebElement cartPage = driver.findElement(By.xpath("//tr[@id='product-3']"));
        System.out.println(cartPage.getText());
        Assert.assertTrue(cartPage.isDisplayed());
        driver.close();

    }

}