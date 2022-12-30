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

public class ex8 {
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
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String homepageurl="https://automationexercise.com/";
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals(homepageurl,actualurl);

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/products']")).click();


        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String productsUrl="https://automationexercise.com/products";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(productsUrl,actualUrl);

        //6. The products list is visible
        List<WebElement> productList=driver.findElements(By.xpath("//div[@class='product-overlay']"));
        for(WebElement w: productList){
            System.out.println(w.getText());
            w.isDisplayed();
        }


        //7. Click on 'View Product' of first product
        Actions actions = new Actions(driver);  //bunu yapmayınca hiç bir seçenekle çalışmadı
        actions.sendKeys(Keys.END).perform();

        //driver.findElement(By.partialLinkText("View Product")).click(); ------> böyle de alınabilir

        //WebElement plusbutton=driver.findElement(By.xpath("(//*[@class='fa fa-plus-square'])[1]")); -------> böyle de olabilir
        //plusbutton.click();

        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        Thread.sleep(2000);


        //8. User is landed to product detail page
       String productDetailUrl= "https://automationexercise.com/product_details/1";
       String actUrl= driver.getCurrentUrl();
       Assert.assertEquals(productDetailUrl,actUrl);

        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        WebElement prodctInfo=driver.findElement(By.xpath("//*[@class='product-information']"));
        System.out.println(prodctInfo.getText());
        prodctInfo.isDisplayed();
    }

}
