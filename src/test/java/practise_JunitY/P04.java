package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P04 extends TestBase {
    @Test
    public void test() {
    /*
        Given
        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/

        When
        Click on the "Animals and Nature" emoji (Animals and Nature emojisine tıklayın)
        And
        Click all the "Animals and Nature" emoji elements (Animals and Nature emojisi altındaki tüm emojilere tıklayın)
        And
        Fill the form (Formu doldurun)
        And
        Press the apply button (Apply -uygula- butonuna basın
        Then
        Verify "code" element is displayed (Code isimli elementin göründüğünü doğrulayın)
         */
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        WebElement frame=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(frame);

        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        List<WebElement> emojiiList=driver.findElements(By.xpath("//div[@id='nature']/div/img"));
        for(WebElement w: emojiiList){
            w.click();
        }
        System.out.println("emojiiList.size() = " + emojiiList.size());

        //using lambda is recommended
        // emojiiList.stream().forEach(t->t.click());
        driver.switchTo().defaultContent();

        List<WebElement>textBox=driver.findElements(By.xpath("//input"));  // 11 inputs
        List<String>textWords=new ArrayList<>(Arrays.asList("dear","admin","selenium","java","sql","sdlc","stlc","html","jdbc","element","locate"));
        for (int i=0; i< textBox.size(); i++){
            textBox.get(i).sendKeys(textWords.get(i));
            }

        driver.findElement(By.xpath("//button[@id='send']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//textarea[@id='code']")).isDisplayed());

        driver.close();

        }




}