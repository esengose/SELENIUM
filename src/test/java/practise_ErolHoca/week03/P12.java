package practise_ErolHoca.week03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P12 extends TestBase {                 //Bu derse Burak hoca girmişti
    @Test
    public void test() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions action =new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-discoverability-t1']"))).perform();

        // Change country/region butonuna basiniz
        action.click(driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]"))).perform();
        switchToWindow("Go to Website");

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement dropmenu=driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select selectOption=new Select(dropmenu);
        selectOption.selectByVisibleText("Turkey (Türkiye)");
        driver.findElement(By.xpath("//a[@id='icp-dropdown_18']")).click();

        // Go to website butonuna tiklayiniz
        action.click(driver.findElement(By.xpath("//span[@id='icp-save-button']"))).perform();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Elektronik"));
    }
}