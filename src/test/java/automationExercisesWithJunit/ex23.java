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

import java.time.Duration;

public class ex23 {
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
        //3. Verify that home page is visible successfully
        driver.get("http://automationexercise.com");
        String homePageURl= driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/",homePageURl);

        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("7", Keys.TAB,"47@gmail.com",Keys.TAB,Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        WebElement register=driver.findElement(By.xpath("//input[@id='password']"));

        register.sendKeys("12345",Keys.TAB,"1",Keys.TAB,"May",Keys.TAB,"1990",Keys.TAB,Keys.SPACE,Keys.TAB,Keys.SPACE,Keys.TAB,
                "SELENİUM",Keys.TAB,"JAVA",Keys.TAB,"SQL",Keys.TAB,"GIT",Keys.TAB,"GITHUB",Keys.TAB,"Canada",Keys.TAB,"LINKEDIN",Keys.TAB,"INSTA",Keys.TAB,"1223",Keys.TAB,"2346");

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        driver.switchTo().alert().accept();


        //7. Verify ' Logged in as username' at top
        WebElement uptext=driver.findElement(By.partialLinkText("Logged in as"));
        System.out.println(uptext.getText());
        Assert.assertTrue(uptext.isDisplayed());
        Thread.sleep(2000);

        //8. Add products to cart
        Actions action =new Actions(driver);
        action.sendKeys(Keys.END);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@data-product-id='7'])[1]")).click();
        Thread.sleep(2000);

        //9. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
        Thread.sleep(3000);
        //10. Verify that cart page is displayed
        String cartPage="https://automationexercise.com/view_cart";
        String actualPage=driver.getCurrentUrl();
        Assert.assertEquals(cartPage,actualPage);
        Thread.sleep(2000);
        //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        Thread.sleep(2000);
        //12. Verify that the delivery address is same address filled at the time registration of account
        String deliverAddrss=driver.findElement(By.xpath("//*[@id='address_delivery']")).getText();
        Assert.assertTrue(register.getText().contains(deliverAddrss));
        //13. Verify that the billing address is same address filled at the time registration of account

        //14. Click 'Delete Account' button
        //15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
