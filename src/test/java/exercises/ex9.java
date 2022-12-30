package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.getKeyFromUnicode;

public class ex9 {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
@Test
    public void test() throws InterruptedException {
        //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    driver.get("http://automationexercise.com");
    //3. Verify that home page is visible successfully
    String homepageurl="https://automationexercise.com/";
    String actualurl=driver.getCurrentUrl();
    Assert.assertEquals(homepageurl,actualurl);

    //4. Click on 'Products' button
    driver.findElement(By.xpath("//a[@href='/products']")).click();
    driver.navigate().refresh();
    driver.findElement(By.xpath("//a[@href='/products']")).click();
    Thread.sleep(1000);

    //5. Verify user is navigated to ALL PRODUCTS page successfully
    String productsUrl="https://automationexercise.com/products";
    String actualUrl=driver.getCurrentUrl();
    Assert.assertEquals(productsUrl,actualUrl);

    //6. Enter product name in search input and click search button
    WebElement product=driver.findElement(By.xpath("//*[@id='search_product']"));
    product.sendKeys("Blue Top");

    driver.findElement(By.xpath("//*[@class='fa fa-search']")).click();
    Thread.sleep(2000);

    //7. Verify 'SEARCHED PRODUCTS' is visible
    WebElement searchProductsText=driver.findElement(By.xpath("//h2[@class='title text-center']"));
    System.out.println(searchProductsText.getText());
    searchProductsText.isDisplayed();


    //8. Verify all the products related to search are visible
    WebElement searchedProduct= driver.findElement(By.xpath("//div[@class='product-overlay']"));
    searchedProduct.isDisplayed();
}

    @After
    public void tearDown(){
        driver.close();
}

}
