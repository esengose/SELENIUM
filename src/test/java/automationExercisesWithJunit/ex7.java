package automationExercisesWithJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ex7 {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void verifyPage() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String homePageURl= driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/",homePageURl);

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]")).click();
        Thread.sleep(2000);
        //5. Verify user is navigated to test cases page successfully
        String testCaseUrl = "https://automationexercise.com/test_cases";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(testCaseUrl,actualUrl);
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
