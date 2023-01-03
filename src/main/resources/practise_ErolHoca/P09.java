package practise_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P09 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        TestBase.driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //    accept Alert(I am an alert box!) and print alert on console
        WebElement alert = TestBase.driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();
        System.out.println(TestBase.driver.switchTo().alert().getText()); // Alert üzerindeki yazıyı konsola yazdırdık
        TestBase.driver.switchTo().alert().accept(); // Alertte tamam'a bastık
        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        TestBase.driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        Thread.sleep(2000);
        TestBase.driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        //    cancel Alert  (Press a Button !)
        Thread.sleep(2000);
        TestBase.driver.switchTo().alert().dismiss();
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        //    finally print on console this message "Hello TechproEducation How are you today"
        //    aseertion these message
        TestBase.driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        Thread.sleep(2000);
        TestBase.driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        Thread.sleep(2000);
        TestBase.driver.switchTo().alert().sendKeys("TechProEducation");
        Thread.sleep(2000);
        TestBase.driver.switchTo().alert().accept();
        //    finally print on console this message "Hello TechProEducation How are you today"
        System.out.println(TestBase.driver.findElement(By.xpath("//*[@id='demo1']")).getText());
        //    aseertion these message
        Assert.assertEquals("Hello TechProEducation How are you today", TestBase.driver.findElement(By.xpath("//*[@id='demo1']")).getText());

    }

    }
