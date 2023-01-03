package automationExercisesWithJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class ex18 {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void categoriesTest() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        //3. Verify that categories are visible on left side bar
        List<WebElement> categories=driver.findElements(By.xpath("//div[@id='accordian']"));
        for(WebElement w: categories){
            System.out.println(w.getText());
            Assert.assertTrue(w.isDisplayed());
        }
        //4. Click on 'Women' category
        driver.findElement(By.xpath("//a[@href='#Women']")).click();


        //5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//a[@href='/category_products/1']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='#Women']")).click();
        driver.findElement(By.xpath("//a[@href='/category_products/1']")).click();


        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement categoryPage=driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(categoryPage.isDisplayed());


        String expectedText="WOMEN - DRESS PRODUCTS";
        String actualText =driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        Assert.assertEquals(expectedText,actualText);
        System.out.println(actualText);
        Thread.sleep(2000);

        //7. On left side bar, click on any sub-category link of 'Men' category
         driver.findElement(By.xpath("//a[@href='#Men']")).click();
         driver.findElement(By.xpath("//a[@href='/category_products/6']")).click();

        //8. Verify that user is navigated to that category page
        String expectedURL= "https://automationexercise.com/category_products/6";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualUrl);
driver.close();
    }
}