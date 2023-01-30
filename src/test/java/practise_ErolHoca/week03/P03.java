package practise_ErolHoca.week03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03 extends TestBase {
    /*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
 */
    /*
    http://uitestpractice.com/Students/Actions adresine gidelim
    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
    Accept ile alert'ü kapatalım
    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
     */
    @Test
    public void test(){
        //  http://uitestpractice.com/Students/Actions adresine gidelim
        // Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        driver.get("http://uitestpractice.com/Students/Actions");
        WebElement maviKutu=driver.findElement(By.xpath("//div[@id='div2']"));
        Actions action = new Actions(driver);
        action.moveToElement(maviKutu).perform();
        waitFor(3);
        //Double Click Me! butonuna tiklayalim ve cikan mesajin ""Double Clicked !!"" oldugunu dogrulayalim
        WebElement dblClickButton=driver.findElement(By.xpath("//button[@name='dblClick']"));
        action.doubleClick(dblClickButton).perform();
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertEquals("Double Clicked !!",driver.switchTo().alert().getText());

       // Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();

      // Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement dragElmn=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropElmn=driver.findElement(By.xpath("//*[@id='droppable']"));
        action.dragAndDrop(dragElmn,dropElmn).perform();
        WebElement droppedText=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertEquals("Dropped!",droppedText.getText());


    }
}
