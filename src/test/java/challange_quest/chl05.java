package challange_quest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class chl05 {
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
        Thread.sleep(3000);
        //click on Phones & PDAs
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();
        Thread.sleep(3000);

        //get the brandName of phones
            List<WebElement> brandNameList = driver.findElements(By.tagName("h4"));
            List<String>firstlist=new ArrayList<>();
            for (WebElement w : brandNameList) {
                firstlist.add(w.getText());
            }
        Collections.sort(firstlist);
        System.out.println(firstlist);


        //click on add to button for all elements
        List<WebElement> phonesadd = driver.findElements(By.xpath("//*[@class='button-group']"));
        for (int i = 0; i < phonesadd.size(); i++) {
            phonesadd.get(i).click();

        }Thread.sleep(3000);
        //click on black total added cart button

       driver.findElement(By.xpath("//span[@id='cart-total']")).click();

        //driver.findElement(By.id("cart-total")).click();  bu da olur

        Thread.sleep(3000);

        //get the names of list from the cart
       List<WebElement> inCart= driver.findElements(By.xpath("//*[@class='text-left']"));
       List<String>secondlist=new ArrayList<>();
       for(WebElement w:inCart){
           secondlist.add(w.getText());
       }
       Collections.sort(secondlist);
        System.out.println(secondlist);
        Thread.sleep(3000);

        // compare the names from displaying list and cart list
        if(firstlist.equals(secondlist)){
            System.out.println("list test passed");
        } else System.out.println("list test failed");
        Thread.sleep(3000);
    }

}

