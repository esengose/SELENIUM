package day04_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomeworkCh2 {
    public static void main(String[] args) throws InterruptedException {
        /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        //click on Phones & PDAs
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();

        //get the brandName of phones
        List<WebElement> brandNameList = driver.findElements(By.tagName("h4"));
        for (WebElement w : brandNameList) {
            System.out.println(w.getText());
            System.out.println();
        }
        //click on add to button for all elements
        List<WebElement> phonesadd = driver.findElements(By.xpath("//*[@class='button-group']"));
        for (int i = 0; i < phonesadd.size(); i++) {
            phonesadd.get(i).click();
        }
        //click on black total added cart button
        // olmadı ---> driver.findElement(By.xpath("//*[@class='breadcrumb']")).click();
        // olmadı ----> driver.findElement(By.xpath("//span[@id='cart-total']")).click();
        // olmadı ---> driver.findElement(By.xpath("//*[text()='3 item(s)-$583.19']")).click()
        // driver.findElement(By.id("cart-total")).click();
        driver.findElement(By.id("cart-total")).click(); //b
        Thread.sleep(3000);

        //get the names of list from the cart
       List<WebElement> inCart= driver.findElements(By.tagName("tbody"));
       for(WebElement w:inCart){
           System.out.println(w.getText());
       }
        Thread.sleep(3000);
        // compare the names from displaying list and cart list
        if(brandNameList.equals(inCart)){
            System.out.println("list test passed");
        } else System.out.println("list test failed");
        Thread.sleep(3000);
    }

}

