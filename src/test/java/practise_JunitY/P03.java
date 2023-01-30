package practise_JunitY;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P03 extends TestBase {
    @Test
    public void test() {
        /*

    Given
       Go to url : https://phptravels.com/demo/ (Siteye gidin)
    When
       Fill the form (formu doldurun)
    And
       Click on "SUBMIT" (submit e tıklayın)
   Then
      Assert that the form has been sent (formun gönderildiğini doğrulayın)
     */
        driver.get("https://phptravels.com/demo/");
        Faker faker=new Faker();
        String name=faker.name().firstName();
        String lastname=faker.name().lastName();
        String companyname=faker.company().name();
        String email=faker.internet().emailAddress();

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(name, Keys.TAB,lastname,Keys.TAB
        ,companyname,Keys.TAB,email,Keys.TAB, Keys.ENTER);

        driver.switchTo().alert().accept();

        String num1=driver.findElement(By.xpath("//span[@id='numb1']")).getText();
        String num2=driver.findElement(By.xpath("//span[@id='numb2']")).getText();

        // int num1 = Integer.parseInt(driver.findElement(By.id("numb1")).getText());  BÖYLE DE YAPILABİLİRDİ
        // int num2 = Integer.parseInt(driver.findElement(By.id("numb2")).getText());


        int resultNum=Integer.parseInt(num1)+Integer.parseInt(num2);
        String resultToString=String.valueOf(resultNum);

        WebElement resultKutusu=driver.findElement(By.xpath("//input[@id='number']"));
        resultKutusu.sendKeys(resultToString);

        WebElement thankYouText=driver.findElement(By.xpath("//h2[@class='text-center cw tac']"));
        Assert.assertTrue(thankYouText.isDisplayed());



    }
}