package challange_quest;

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

public class chl08 {
    /*
1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
3-Option3 ü seçin.
4-Option3 ün seçili olduğunu doğrulayın.
*/
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement dropmenu=driver.findElement(By.id("dropdown-class-example"));

        System.out.println(dropmenu.getText());
        Assert.assertTrue(dropmenu.isDisplayed());
        Select selected=new Select(dropmenu);
        selected.selectByVisibleText("Option3");
        WebElement option3=driver.findElement(By.xpath("//option[@value='option3']"));
        Assert.assertTrue(option3.isSelected());

        driver.close();
    }
}
