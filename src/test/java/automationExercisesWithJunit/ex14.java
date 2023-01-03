package automationExercisesWithJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.channel.AbstractEventLoopGroup;
import io.netty.util.concurrent.SucceededFuture;
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

public class ex14 {
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
        WebElement homePage=driver.findElement(By.tagName("body"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Add products to cart
        Actions action= new Actions(driver);
        action.sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/product_details/3']")).click();
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/product_details/3']")).click();
        //5. Click 'Cart' button
        driver.findElement(By.xpath("//*[@class='btn btn-default cart']")).click();
        Thread.sleep(3000);
        //6. Verify that cart page is displayed
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        Thread.sleep(3000);
        String expected="https://automationexercise.com/view_cart";
        String actual=driver.getCurrentUrl();
        Assert.assertEquals(expected,actual);
        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        Thread.sleep(3000);
        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("(//a[@href='/login'])[2]")).click();
        Thread.sleep(3000);
        //9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("pinky_pie@gmail.com",Keys.TAB,"12345",Keys.TAB,Keys.ENTER);

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        //11. Verify ' Logged in as username' at top
        WebElement loggedwithusername= driver.findElement(By.partialLinkText("Logged in as"));
        System.out.println(loggedwithusername.getText());
        Assert.assertTrue(loggedwithusername.isDisplayed());
        Thread.sleep(5000);

        //12.Click 'Cart' button
        driver.findElement(By.xpath("//li[3]/a[1]")).click();
        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //14. Verify Address Details and Review Your Order
        WebElement checkoutPage=driver.findElement(By.xpath("//section[@id='cart_items']"));
        System.out.println(checkoutPage.getText());
        Assert.assertTrue(checkoutPage.isDisplayed());
        Thread.sleep(2000);

        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("welldone welldone");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        Thread.sleep(2000);

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("dear mear",Keys.TAB,"123456789101123",Keys.TAB,"911",Keys.TAB,"12",Keys.TAB,"2030");

        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(2000);
        //18. Verify success message 'Your order has been placed successfully!'
        WebElement successmessage= driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
        System.out.println(successmessage.getText());
        Assert.assertTrue(successmessage.isDisplayed());

        //19. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement deleted=driver.findElement(By.xpath("//h2[@data-qa='account-deleted']"));
        System.out.println(deleted.getText());
        Assert.assertTrue(deleted.isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        driver.close();

    }
}