package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P12 extends TestBase {
    /*
    Given
    Go to https://www.saucedemo.com/  (Siteye gidin.)
    When
    Enter the username as "standard_user" (kullanıcı adını bu şekilde girin)
    And
    Enter the password as "secret-sauce"  (şifreyi bu şekilde girin)
    And
    Click on the login button (logine tıklayın)
    And
    Add all products to cart (sepete tüm ürünleri ekleyin)
    And
    Go to cart (sepete gidin)
    And
    Click on checkout (checkout tıklayın)
    And
    Fill your information (bilgileri doldurun)
    And
    Click on continue (continue devam a tıklayın)
    Then
    Assert that total price is $140.34 (toplam ücretin $140.34 olduğunu doğrulayın)
    When
    Click on finish (bitişe tıklayın)
    Then
    Assert that CHECKOUT: COMPLETE! (CHECKOUT: COMPLETE! doğrulayın)
     */
    @Test
    public void test(){
        driver.get("https://www.saucedemo.com/");
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeHolder='Password']")).sendKeys("secret_sauce");
        WebElement loginbutton=driver.findElement(By.id("login-button"));
        loginbutton.click();

        List<WebElement> allProducts=driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        for(WebElement w: allProducts){
            w.click();
        }
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("aaa", Keys.TAB,"bbb",Keys.TAB,"123");

        driver.findElement(By.id("continue")).click();

        String[] totalPrice=driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText().split(" ");

        Assert.assertEquals("$140.34",totalPrice[1]);

        driver.findElement(By.xpath("//button[@id='finish']")).click();

        Assert.assertEquals("CHECKOUT: COMPLETE!",driver.findElement(By.xpath("//span[@class='title']")).getText());







    }
}
