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

import java.io.CharArrayReader;
import java.time.Duration;

public class ex17 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void removeFromCart() throws InterruptedException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        driver.get("http://automationexercise.com");
        WebElement homePage = driver.findElement(By.tagName("body"));
        Assert.assertTrue(homePage.isDisplayed());


        //4. Add products to cart
        //WebElement myProduct=driver.findElement(By.xpath("(//a[@data-product-id='16'])[1]"));
        Actions action = new Actions(driver);
       // action.moveToElement(myProduct).click().perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.END).perform();
       driver.findElement(By.xpath("(//a[@data-product-id='16'])[1]")).click();
        Thread.sleep(2000);

        //5. Click 'Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        Thread.sleep(2000);
        //6. Verify that cart page is displayed
        String expectedUrl="https://automationexercise.com/view_cart";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        Thread.sleep(2000);
        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
        Thread.sleep(2000);

        //8. Verify that product is removed from the cart
        WebElement cartEmpty=driver.findElement(By.xpath("//b[text()='Cart is empty!']"));
        System.out.println(cartEmpty.getText());
        Assert.assertTrue(cartEmpty.isDisplayed());

        driver.close();

    }
}
