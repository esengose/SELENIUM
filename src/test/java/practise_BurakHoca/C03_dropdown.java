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

public class C03_dropdown {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void dropdowntest() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropmenu=driver.findElement(By.xpath("//select[@id='dropdown']"));

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın

        Select selectedOption =new Select(dropmenu);
        selectedOption.selectByIndex(1);
        System.out.println(selectedOption.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        selectedOption.selectByValue("2");
        System.out.println(selectedOption.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        selectedOption.selectByVisibleText("Option 1");
        System.out.println(selectedOption.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        // Tüm option'ları yazdırın
        List<WebElement> allOptions=selectedOption.getOptions();
        for(WebElement w: allOptions){
            System.out.println(w.getText());
        }

        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        Assert.assertEquals(allOptions.size(),3);

                driver.close();
    }

}
