package exercises;

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
import java.util.List;

public class ex12 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void addProduct() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String homePageUrl="https://automationexercise.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(homePageUrl,actualUrl);

        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();

        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.END).perform();


        //5. Hover over first product and click 'Add to cart'
        driver.findElement(By.xpath("//*[@data-product-id='1']")).click();


        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();


        //7. Hover over second product and click 'Add to cart'
        actions.sendKeys(Keys.UP).perform();
        driver.findElement(By.xpath("//*[@data-product-id='3']")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();

        //9. Verify both products are added to Cart
        List<WebElement> cartList=driver.findElements(By.xpath("//td[@class='cart_product']"));
        for(WebElement w: cartList){
            System.out.println(w.getText());
            w.isDisplayed();
        }



        //10. Verify their prices, quantity and total price
    }

}
