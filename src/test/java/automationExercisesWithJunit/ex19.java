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

public class ex19 {
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
        //4. Verify that Brands are visible on left side bar
        List<WebElement> brandsNames=driver.findElements(By.xpath("//div[@class='brands-name']"));
        for(WebElement w: brandsNames) {
            System.out.println(w.getText());
            Assert.assertTrue(w.isDisplayed());
        }
        Thread.sleep(2000);

        //5. Click on any brand name
        Actions action =new Actions(driver);
        action.sendKeys(Keys.END).perform();

        driver.findElement(By.xpath("//a[@href='/brand_products/Babyhug']")).click();

        //6. Verify that user is navigated to brand page and brand products are displayed
        String expectedUrl="https://automationexercise.com/brand_products/Babyhug";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        Thread.sleep(2000);
        //7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//a[@href='/brand_products/Madame']")).click();

        //8. Verify that user is navigated to that brand page and can see products
        String expectedUrl2="https://automationexercise.com/brand_products/Madame";
        String actualUrl2=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl2,actualUrl2);

        driver.close();

    }
}