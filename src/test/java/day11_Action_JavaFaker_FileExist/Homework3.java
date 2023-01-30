package day11_Action_JavaFaker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Homework3 extends TestBase {
    @Test
    public void test() {

        //Keyboard Base Actions
        //Homework
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
        driver.get("http://webdriveruniversity.com/Actions");

        //Link 1" e tiklayin
        Actions action =new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"))).perform();
        action.click(driver.findElement(By.xpath("(//a[@href='#'])[1]"))).perform();

        //Popup mesajini yazdirin
        driver.switchTo().alert().getText();
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //“Click and hold" kutusuna basili tutun
        action.clickAndHold(driver.findElement(By.xpath("//*[@id='click-box']"))).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        String clickHoldText= driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]")).getText();
        System.out.println("clickHoldText = " + clickHoldText);

        //8- “Double click me" butonunu cift tiklayin
        action.doubleClick(driver.findElement(By.xpath("//div[@id='double-click']"))).perform();
    }
}