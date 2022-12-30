package practiseSessions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
//fill the firstname
// fill the lastname
//check the gender
//check the experience
//fill the date
        WebElement firstname=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys("Mutlu", Keys.TAB,"NEMUTLU",Keys.TAB,Keys.ARROW_RIGHT, Keys.TAB,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT, Keys.TAB,"21.06.2023"
        , Keys.TAB,Keys.TAB,Keys.SPACE, Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE, Keys.TAB,"South America",Keys.TAB,Keys.LEFT_CONTROL,
                Keys.SPACE,Keys.ARROW_DOWN,Keys.SPACE,Keys.ARROW_DOWN,Keys.SPACE,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);

//choose your profession -> Automation Tester
//choose your tool -> Selenium Webdriver
//choose your continent -> Antartica
//choose your command  -> Browser Commands
//click submit button


    }
}
