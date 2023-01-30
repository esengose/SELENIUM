package works;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class W02 extends TestBase {
    @Test
    public void test(){
        //sahibinden.coma gidin
        driver.get("https://www.sahibinden.com/");

        //anasayfada oldugunuz dogrulayin
        String expectedUrl="https://www.sahibinden.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        //arama kismina opel astra yazip aratin
        driver.findElement(By.xpath("//*[@id='searchText']")).sendKeys("opel astra", Keys.ENTER);

        //sonuc sayisini konsala yazdirin
        String[] sonuc=driver.findElement(By.xpath("//div[@class='resultsTextWrapper']")).getText().split(" ");
       String sonucsayı= sonuc[2];
       String [] ss=sonucsayı.split("");
        System.out.println(ss[28]+ss[29]+ss[30]+ss[31]+ss[32]+ss[33]);

        //anasayfaya geri donun
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();

        //ikici el alisveris kisminda telefonlara  tiklayin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN);
        WebElement ikinciElTlf=driver.findElement(By.xpath("//*[@title='Cep Telefonu']"));
        ikinciElTlf.click();

        //ilk urune tiklayip ilan no ve ilan tarihinin gorunurlulugunu test edin
       List<WebElement>telList=driver.findElements(By.xpath("//ul[@class='showCaseList showCaseSubCategory category-showcase-container']"));
       for(WebElement w: telList){
          if(w== telList.get(0)){
              w.click();
          }
       }
       WebElement infoBox=driver.findElement(By.className("classifiedInfoList"));
       Assert.assertTrue(infoBox.isDisplayed());
    }
}
