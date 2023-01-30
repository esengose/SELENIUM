package practise_JunitY;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P01 extends TestBase {
    @Test
    public void test() {
        //Got url : http://www.uitestpractice.com/ (Siteye gidin)
        driver.get("http://www.uitestpractice.com/");
        //Click on 'Form'       (Formu doldurun)
        driver.findElement(By.linkText("Form")).click();
        //Fill the First Name : John  (İsmi girin)
        driver.findElement(By.id("firstname")).sendKeys("John", Keys.TAB,"Doe",Keys.TAB,Keys.SPACE,Keys.TAB,Keys.TAB,Keys.SPACE,Keys.TAB,Keys.TAB,"Canada",
                Keys.TAB,"02/01/2000",Keys.TAB,"12345",Keys.TAB,"john_doe",Keys.TAB,"john@doe.com",Keys.TAB,
                "My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere",Keys.TAB,"John.123");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Fill the Last Name : Doe  (Soyismi girin)

        //Check the Marital Status : Married (Medeni hali : Marride -evli- olarak girin)

        //Check the Hobby : Reading  (Hobi: okuma olarak girin)

        //Select the Country : Canada (ülke : kanada olarak seçin)

        //Fill the Date of Birth : 1st February 2000 (doğum yılı girin)

        //Fill the phone number : 12345 (telf nmarası girin)

        //Fill the User Name : john_doe  (kullanıcı adı girin)

        //Fill the Email : john@doe.com (email girin)

        //Fill the About Yourself : My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere
        //Kendiniz hakkında birşeyler yazın: Benim adım John Doe. Ben ünlü bir adamım. Çünkü adım heryerde sahte veri olarak kullanılıyor.

        //Fill the Passsword : John.123 (şifreyi girin)

        //Click on submit  (submit i tıklayın)


       WebElement submit= driver.findElement(By.xpath("//button[@type='submit']"));
       submit.sendKeys(Keys.ENTER);

    }
}