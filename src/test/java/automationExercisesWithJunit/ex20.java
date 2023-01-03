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

import java.time.Duration;
import java.util.List;

public class ex20 {
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
        //3. Click on 'Products' button
        driver.get("http://automationexercise.com");
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        String allProductsPage="https://automationexercise.com/products";
        String actualPage=driver.getCurrentUrl();

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertEquals(allProductsPage,actualPage);

        //5. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Winter Top", Keys.TAB,Keys.ENTER);

        //6. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProduct=driver.findElement(By.xpath("//a[@href='/product_details/5']"));
        System.out.println(searchedProduct.getText());
        Assert.assertTrue(searchedProduct.isDisplayed());

        //7. Verify all the products related to search are visible
        driver.findElement(By.xpath("//input[@id='search_product']")).clear();
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Top", Keys.TAB,Keys.ENTER);

        //8. Add those products to cart
        List<WebElement> tops=driver.findElements(By.xpath("//*[@id='Women']/div/ul/li[2]"));
        for(WebElement w: tops){
            System.out.println(w.getText());
            Assert.assertTrue(w.isDisplayed());
            Thread.sleep(1000);
            w.click();
        }

        //8. Add those products to cart

        //9. Click 'Cart' button and verify that products are visible in cart
        //10. Click 'Signup / Login' button and submit login details
        //11. Again, go to Cart page
        //12. Verify that those products are visible in cart after login as well
    }
}