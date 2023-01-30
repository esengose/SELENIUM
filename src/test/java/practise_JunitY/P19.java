package practise_JunitY;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P19 extends TestBase {
    /*
        Given
            Go to https://www.facebook.com/     (siteye gidin)
        When
            Click on "Create New Account"     (yeni hesap oluştura tıklayın)
        And
            Fill all the boxes by using keyboard actions class (Keyboard actions kullanarak formu doldurun)
         */
    @Test
    public void test() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
        WebElement name = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions action = new Actions(driver);
        Faker faker = new Faker();
        String email= faker.internet().emailAddress();
        action.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("18")
                .sendKeys(Keys.TAB)
                .sendKeys("Oca")
                .sendKeys(Keys.TAB)
                .sendKeys("2014")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }


}
