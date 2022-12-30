package challange_quest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class chl06 {



    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
    }

    @Test
    public void testEditor() {
        // Given kullanici "https://editor.datatables.net/" sayfasina gider
        //    Then new butonuna basar
        driver.get("https://editor.datatables.net/");
        driver.findElement(By.xpath("//*[@class='dt-button buttons-create']")).click();

        //    And editor firstname kutusuna "<firstName>" bilgileri girer
        //    And editor lastname kutusuna "<lastName>" bilgileri girer
        //    And editor position kutusuna "<position>" bilgileri girer
        //    And editor office kutusuna "<office>" bilgileri girer
        //    And editor extension kutusuna "<extension>" bilgileri girer
        //    And editor startdate kutusuna "<startDate>" bilgileri girer
        //    And editor salary kutusuna "<salary>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_first_name']")).sendKeys("Eddie");
        driver.findElement(By.xpath("//*[@id='DTE_Field_last_name']")).sendKeys("Thor");
        driver.findElement(By.xpath("//*[@id='DTE_Field_position']")).sendKeys("QA Engineer");
        driver.findElement(By.xpath("//*[@id='DTE_Field_office']")).sendKeys("Farfar Away");
        driver.findElement(By.xpath("//*[@id='DTE_Field_extn']")).sendKeys(".cs");
        driver.findElement(By.xpath("//*[@id='DTE_Field_start_date']")).sendKeys("2022-12-26");
        driver.findElement(By.xpath("//*[@id='DTE_Field_salary']")).sendKeys("200000");

        //    When Create tusuna basar
        //    Then Kullanıcının eklendiğini doğrular.
        driver.findElement(By.xpath("//*[@class='btn']")).click();
        WebElement isHere= driver.findElement(By.xpath("//*[@type='search']"));
        isHere.sendKeys("Eddie Thor");
        Assert.assertTrue("passed", isHere.isDisplayed());

        //    And Eklediği kullanıcı kaydını siler
        //    Then Kullanıcinin silindiğini doğrular.
        driver.findElement(By.xpath("//*[@id='row_58']")).click();
        driver.findElement(By.xpath("//*[@class='dt-button buttons-selected buttons-remove']")).click();
        driver.findElement(By.xpath("//*[@class='btn']")).click();
        WebElement isDeleted =driver.findElement(By.className("dataTables_empty"));
        Assert.assertTrue("passed",isDeleted.isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }



}