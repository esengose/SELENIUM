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
import java.util.ArrayList;
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
        Assert.assertTrue(searchedProduct.isDisplayed());

        //7. Verify all the products related to search are visible
        driver.findElement(By.xpath("//input[@id='search_product']")).clear();
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Top", Keys.TAB,Keys.ENTER);

        //8. Add those products to cart
        List<WebElement>tops=driver.findElements(By.xpath("//div[@class='col-sm-4']"));
        for(WebElement w: tops){
            System.out.println("product name= "+w.getText());
        }
        System.out.println("toplam ürün: "+tops.size());
        Actions action =new Actions(driver);

        /////////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        List<WebElement> products=driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        int counter=0;
        for (int i = 1; i < 44; i++) {
            if (i == 9 || i == 10 || i == 17 || i == 25 || i == 26 || i == 27 || i == 32 || i == 34 || i == 36) {
                continue;
            }else {
                driver.findElement(By.xpath("(//a[@data-product-id='" + i + "'])[1]")).click();
                driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
                counter++;
            }
        }
        System.out.println(counter);


     /*   for(int i=1; i<44; i++) {
            if (i == 1 || i == 5 || i == 6 || i == 7 || i == 8 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 18 || i == 24 || i == 42) {
                action.sendKeys(Keys.END).perform();
                driver.findElement(By.xpath("(//a[@data-product-id='" + i + "'])[1]")).click();
                //driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]")).click();
                driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
            } else {
                continue;
            }
        }*/

        //9. Click 'Cart' button and verify that products are visible in cart

        //10. Click 'Signup / Login' button and submit login details

        //11. Again, go to Cart page
        //12. Verify that those products are visible in cart after login as well
    }
}