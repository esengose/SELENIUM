package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P16 extends TestBase {
      /*
Given
    Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html (Siteye gidin)
When
    Fill the username, password and textArea comment: (kullanıcı adı, şifre ve yorum alanalrını doldurun)
And
    Choose a file and upload it  (Bir dosya seçin ve yükleyin)
And
    Select checkbox, radio item and dropdowns  (checkbox, radio butons ve dropdownları seçin)
And
    Click on submit (tamama tıklayın)
Then
    Verify that uploaded file name is on the Form Details. (Form details/ form detayları kısmında yüklenen dosyanın isminin olduğunu doğrulayın)
 */
    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.findElement(By.name("username")).sendKeys("xxx", Keys.TAB,"123");
        WebElement comment =  driver.findElement(By.name("comments"));
        comment.clear();
        comment.sendKeys("hi! i am a comment!");
        String userHome= System.getProperty("user.home");
        driver.findElement(By.name("filename")).sendKeys(userHome+"/Desktop/logo.jpeg");

        List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']")); //all checkboxes
        for(WebElement w: checkboxes){
            if(!w.isSelected()){
                w.click();
            }

            driver.findElement(By.xpath("//input[@value='rd1']")).click();        //radio button 1

            WebElement dropMenu=driver.findElement(By.xpath("//select[@name='multipleselect[]']"));
            Select select = new Select(dropMenu);
            select.deselectAll();
            select.selectByValue("ms1");
        }

            WebElement dropdown= driver.findElement(By.xpath("//select[@name='dropdown']"));
            Select selected=new Select(dropdown);
            selected.selectByValue("dd3");

            driver.findElement(By.xpath("(//input[@name='submitbutton'])[2]")).click();
            String fileName= driver.findElement(By.xpath("//li[@id='_valuefilename']")).getText();
            Assert.assertEquals("logo.jpeg",fileName);



    }
}
