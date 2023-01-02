package practise_BurakHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_dropdown {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test() {
        // ...Exercise 2...
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        // dropdown'dan "Baby" secenegini secin
        WebElement allDrop= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select= new Select(allDrop);
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        List<WebElement> options= select.getOptions();
        for(WebElement w: options){
            System.out.println(w.getText());
        }

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin


        Assert.assertEquals(options.size(),28);

        driver.close();

        }




    }



