package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class P02 extends TestBase {
    @Test
    public void test() {
        //navigate to https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //Click on calculator under Micro Apps (Micro Apps yazısı altındaki Calculator -hesap makinesi- tıklayın
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//h2[3]"))).perform(); //micro aps üzerine gittik
        action.click(driver.findElement(By.id("calculatetest"))).perform();    //calculatora tıkladık

        //Type any number in the first input (ilk kutuya herhangi bir sayı girin)
        driver.findElement(By.id("number1")).sendKeys("8");

        //Type any number in the second input (ikinci kutuya herhangi bir sayı girin)
        driver.findElement(By.id("number2")).sendKeys("4");

        //Click on calculate (calculate basarak hesapla komutu verin)
        action.click(driver.findElement(By.id("calculate"))).perform();

        //Get the result (dinamik çalışması için sonucu bir konteynıra alın)
        String answer = driver.findElement(By.xpath("//span[@id='answer']")).getText();

        //Assert the result (sonucu doğrulayın)
        Assert.assertTrue(answer.contains("12"));

        //print the result (sonucu konsola yazın)
        System.out.println("answer = " + answer);

        //change the operation (işlem türünü değiştirin)
    }
        @Test
    public void dividetest(){
            driver.get("https://testpages.herokuapp.com/styled/index.html");
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(By.xpath("//h2[3]"))).perform(); //micro aps üzerine gittik
            action.click(driver.findElement(By.id("calculatetest"))).perform();    //calculatora tıkladık
            driver.findElement(By.id("number1")).sendKeys("8");
            driver.findElement(By.id("number2")).sendKeys("4");

            WebElement dropFunction=driver.findElement(By.id("function"));
            Select selected=new Select(dropFunction);
            selected.selectByVisibleText("divide");   //dropdown ile işlem degişikliği yapabiliriz

            action.click(driver.findElement(By.id("calculate"))).perform();
            String answer = driver.findElement(By.xpath("//span[@id='answer']")).getText();
            System.out.println("answer = " + answer);

        }
}


