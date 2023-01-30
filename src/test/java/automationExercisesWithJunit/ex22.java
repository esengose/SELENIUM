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

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class ex22 {
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
        //3. Scroll to bottom of page
        Actions action =new Actions(driver);
        action.sendKeys(Keys.END).perform();
        Thread.sleep(3000);
        //4. Verify 'RECOMMENDED ITEMS' are visible
        WebElement h2text=driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        System.out.println(h2text.getText());
        Assert.assertTrue(h2text.isDisplayed());
        Thread.sleep(3000);
        //5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("(//a[@data-product-id='5'])[1]")).click();
        Thread.sleep(3000);
        //6. Click on 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        Thread.sleep(3000);

        //7. Verify that product is displayed in cart page
        /*List<WebElement> cartpageinfo=driver.findElements(By.xpath("//tr[@id='product-5']"));
        for(WebElement w: cartpageinfo){
            System.out.println(w.getText());
        }*/
        String cartPageUrl= "https://automationexercise.com/view_cart";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(cartPageUrl,actualUrl);
        Thread.sleep(3000);
        driver.close();

    }
}
