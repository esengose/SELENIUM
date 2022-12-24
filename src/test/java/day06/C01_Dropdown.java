package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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

public class C01_Dropdown {
    //Dropdown SELECT tagıyla kullanılır.
    //Eger test sınıfında birden fazla method oluşturulmuşsa @Before kullanılır.
    /*
1. What is dropdown? Dropdown nedir?
Dropdown liste olusturmak icin kullanilir.
2. How to handle dropdown elements? Dropdown nasil automate edilir?
-Dropdown'i Locate ederiz
-Select objecti'i olustururum
-Select objecti'i ile istedigim secenegi secerim
NOT: Select object'i olusturma nedenim, dropdownlarin Select class'i ile olusturulmasi
3.Tüm dropdown seçeneklerini nasıl print ederiz?
-getOptions() methodu ile tüm dropdown elementlerini listeye koyarız
-sonra seçenekleri loop ile yazdırabiliriz
4.Bir seçeneğin seçili olduğunu automate etmek için ne yapılır?
-getFırstSelectedOption() methodu seçili olan seçeneği getirir

                             REUSABLE METHOD
   //Dropdown için tekrar tekrar kullanabileceğimiz methodlar oluşturduğumuzda bunlara tekrar tekrar kullanılabilen methodlar denir. reusable

 */


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void selectByIndexTest(){
        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        // Dogum yilini, ayini, ve gununu su sekilde secer : 2000, January, 10
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        //Locate dropdown element
        WebElement year=driver.findElement(By.xpath("//select[@id='year']"));

        //Create select object
        Select yearDropdown=new Select(year);
        //3 farklı şekilde yapabiliriz
        yearDropdown.selectByIndex(22);  //seçenek sırası 0 dan başlar

        WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
        Select monthDropdown =new Select(month);
        monthDropdown.selectByValue("0"); //option in value degeri ile seçim yapılabilir.

        WebElement day=driver.findElement(By.xpath("//select[@id='day']"));
        Select dayDropdown =new Select(day);
        dayDropdown.selectByVisibleText("10"); //caseSensitive dir. görünen metni String içinde alır

    }


    @Test
    public void printAllElements(){
        //Tüm eyalet isimlerini yazdıralım
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement state =driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDrop= new Select(state);
        List<WebElement> stateList=stateDrop.getOptions();
        for(WebElement w: stateList){
            System.out.println(w.getText());
        }

    }

    @Test
    public void getSelectedOptions (){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        //State dropdownindeki varsayılan (default) seçili seçeneğin "Select a State" olduğunu verify edelim
        WebElement state =driver.findElement(By.xpath("//select[@id='state']"));
        Select statedrop =new Select(state);
        String defaulText=statedrop.getFirstSelectedOption().getText(); //burada default olan texti tesbit ettik

        Assert.assertEquals("Select a State",defaulText);

    }

    @After
    public void tearDown(){
        driver.close();
    }






}
