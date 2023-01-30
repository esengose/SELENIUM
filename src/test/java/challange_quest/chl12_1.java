package challange_quest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class chl12_1 extends TestBase {

    @Test
    public void test() {

        //  #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        //  #Fill in capitals by country
        WebElement Madrid= driver.findElement(By.xpath("//div[@id='box7']"));
        WebElement Rome= driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement Oslo= driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement Stockholm= driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement Copenhagen= driver.findElement(By.xpath("//div[@id='box4']"));
        WebElement Seoul= driver.findElement(By.xpath("//div[@id='box5']"));
        WebElement Washington= driver.findElement(By.xpath("//div[@id='box3']"));

        WebElement Italy =driver.findElement(By.xpath("//div[@id='box106']"));
        WebElement Spain =driver.findElement(By.xpath("//div[@id='box107']"));
        WebElement Denmark=driver.findElement(By.xpath("//div[@id='box104']"));
        WebElement Norway=driver.findElement(By.xpath("//div[@id='box101']"));
        WebElement Sweden=driver.findElement(By.xpath("//div[@id='box102']"));
        WebElement SouthKorea=driver.findElement(By.xpath("//div[@id='box105']"));
        WebElement UnitedStates=driver.findElement(By.xpath("//div[@id='box103']"));

        Actions action = new Actions(driver);
        action.dragAndDrop(Madrid,Spain)
                .dragAndDrop(Rome,Italy)
                .dragAndDrop(Oslo,Norway)
                .dragAndDrop(Stockholm,Sweden)
                .dragAndDrop(Copenhagen,Denmark)
                .dragAndDrop(Seoul,SouthKorea)
                .dragAndDrop(Washington,UnitedStates)
                .build()
                .perform();




    }
}