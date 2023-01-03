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

public class ex15 {
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
        WebElement homePage = driver.findElement(By.tagName("body"));
        Assert.assertTrue(homePage.isDisplayed());
//4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
//5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("flutter shy", Keys.TAB,"fluttershy@gmail.com",Keys.TAB, Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345",Keys.TAB,"14",Keys.TAB,"December",Keys.TAB,"2020",Keys.TAB,Keys.TAB,Keys.TAB,"flutter",Keys.TAB,"shy",Keys.TAB
        ,"fff",Keys.TAB,"corncity",Keys.TAB,"unicornplace",Keys.TAB,"Canada",Keys.TAB,"aaa",Keys.TAB,"bbb",Keys.TAB,"111",Keys.TAB,"222",Keys.TAB,Keys.ENTER);
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountCreated=driver.findElement(By.xpath("//b[text()='Account Created!']"));
        System.out.println(accountCreated.getText());
        Assert.assertTrue(accountCreated.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        Thread.sleep(2000);
//7. Verify ' Logged in as username' at top
        WebElement loggedwithusername= driver.findElement(By.partialLinkText("Logged in as"));
        System.out.println(loggedwithusername.getText());
        Assert.assertTrue(loggedwithusername.isDisplayed());
//8. Add products to cart
        Actions action=new Actions(driver);
        action.sendKeys(Keys.END).perform();
driver.findElement(By.xpath("(//a[@data-product-id='11'])[1]")).click();
//9. Click 'Cart' button
driver.findElement(By.xpath("//u[text()='View Cart']")).click();
Thread.sleep(2000);
//10. Verify that cart page is displayed
        String expectedUrl="https://automationexercise.com/view_cart";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

//11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
//12. Verify Address Details and Review Your Order
        WebElement checkoutPage=driver.findElement(By.xpath("//section[@id='cart_items']"));
        System.out.println(checkoutPage.getText());
        Assert.assertTrue(checkoutPage.isDisplayed());
        Thread.sleep(2000);
//13. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("welldone welldone");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        Thread.sleep(2000);
//14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("so gan",Keys.TAB,"123456789101123",Keys.TAB,"911",Keys.TAB,"12",Keys.TAB,"2030");

//15. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(2000);
//16. Verify success message 'Your order has been placed successfully!'
        WebElement successmessage= driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
        System.out.println(successmessage.getText());
        Assert.assertTrue(successmessage.isDisplayed());

//17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement deleted=driver.findElement(By.xpath("//h2[@data-qa='account-deleted']"));
        System.out.println(deleted.getText());
        Assert.assertTrue(deleted.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        driver.close();
    }
}