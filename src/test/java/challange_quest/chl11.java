package challange_quest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class chl11 extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.amazon.com.tr/");

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone 13 512", Keys.ENTER);

        List<WebElement> iphoneList=driver.findElements(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']"));
        for(WebElement w: iphoneList) {
            System.out.println(w.getText());
        }
            driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

           String yeşiltanım= driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
           String price=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
           String color=driver.findElement(By.xpath("(//span[@class='a-size-base po-break-word'])[1]")).getText();
           String stock= driver.findElement(By.xpath("//span[@class='a-size-medium a-color-success']")).getText();
        System.out.println(yeşiltanım);
        System.out.println("yeşil price :"+price+" TL");
        System.out.println("stock :" +stock);

        String arr[]=yeşiltanım.split(" ");



    }
}
