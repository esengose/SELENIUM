package practise_ErolHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {
    static WebDriver driver;
    @BeforeClass

    public static void beforeclass(){
        //BeforeClass ile driver ı olusturun ve
        //Maximize edin, 15 sn bekletin
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void before(){
        //http://www.google.com adresine gidin
        driver.get("https://google.com/");
    }

    @Test
    public void test(){

//arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        WebElement aramakutusu= driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramakutusu.sendKeys("The God Father", Keys.ENTER);

    }
    @Test
    public void test2(){
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        WebElement aramakutusu= driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramakutusu.sendKeys("Kill Bill",Keys.ENTER);

    }
    @Test
    public void test3(){
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        WebElement aramakutusu= driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramakutusu.sendKeys("Lord of the rings",Keys.ENTER);

    }


    @After
    public void tearDown(){
        String [] sonuc1=driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println(" sonuc sayısı= " +sonuc1[1]);
    }

    @AfterClass
    //AfterClass ile kapatın
    public static void afterclass(){
        driver.close();
    }








}
