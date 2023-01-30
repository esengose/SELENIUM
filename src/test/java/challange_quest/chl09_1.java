package challange_quest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class chl09_1 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get(" https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        Thread.sleep(3000);
        //maximize the web site

        // ikinci emojiye tıklayın
        int size = driver.findElements(By.tagName("iFrame")).size();
        System.out.println("Toplam iFrame sayısı: " + size);
        WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='emoojis'])"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        Thread.sleep(2000);

        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> emojiler = driver.findElements(By.xpath("//div[@id='nature']/div/img"));
        for (WebElement w : emojiler) {
            w.click();
        }
        Thread.sleep(2000);
        // ana iframe'e geri dön
        driver.switchTo().defaultContent();

        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement>inputPlace=driver.findElements(By.xpath("//input"));
        List<String>inputs=new ArrayList<>(Arrays.asList("PRETTY","LITTLE","LIARS","HOW","TO","TRAIN","YOUR","DRAGON","?","?","?"));
for (int i=0; i< inputPlace.size(); i++){
    inputPlace.get(i).sendKeys(inputs.get(i));
}
Thread.sleep(9000);
        // uygula butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();

    }


}
