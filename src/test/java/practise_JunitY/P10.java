package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P10 extends TestBase {
    @Test
    public void test(){
         /*
    Given
    Go to https://www.saucedemo.com/  (Siteye gidin)
    When
    Enter the username as "standard_user" (Kullanıcı adını "standard_user" girin)
    And
    Enter the password as "secret_sauce"  (Şifreyi "secret_sauce" girin)
    And
    Click on login button  (Giriş butonuna basın)
    And
    Order products by "Price (low to high)" (Ürünleri fiyatlarına göre düşükten yükseğe olarak sıralayın)
    Then
    Assert that last product costs $49.99, first product costs $7.99 (ilk fiyatın 7.99 son fiyatın 49.99 olduğunu doğrulayın)
     */
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeHolder='Password']")).sendKeys("secret_sauce");
        WebElement loginbutton=driver.findElement(By.id("login-button"));
        // loginbutton.sendKeys(Keys.ENTER); // clik ve submit te olmadı
        Actions action = new Actions(driver);
        action.click(loginbutton).perform();

        WebElement dropMenu= driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(dropMenu);
        select.selectByValue("lohi");
        List<WebElement> fiyatListesi=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for(WebElement each: fiyatListesi){
            System.out.println(each.getText());
        }
        Assert.assertEquals("$7.99",fiyatListesi.get(0).getText());
        Assert.assertEquals("$49.99",fiyatListesi.get(fiyatListesi.size()-1).getText());


    }

}
