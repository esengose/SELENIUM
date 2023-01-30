package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class P11 extends TestBase {
    @Test
    public void test(){
  /*
    Given
    Go to https://webdriveruniversity.com/To-Do-List/index.html  (Siteye gidini)
    When
    Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
    And        (Yeni yapılacaklar listesi ekleyiniz yukarıdaki gibi: kahvaltı hazırla, bulaşkları yıka, bebeğin bakımıyla ilgilen, çocuğun ödevine yardmcı ol, selenium çalş, uyu)

    Strike through all todos  (Tüm yapılacakların üstünü çiz)
    And
    Delete all todos. (yapılacakların hepsini sil)
    Then
    Assert that all todos deleted. (Tüm yapılacakalrın silindiğini doğrula)
     */
    driver.get("https://webdriveruniversity.com/To-Do-List/index.html");

    driver.findElement(By.xpath("//input[@placeholder='Add new todo']")).sendKeys("Prepare breakfast"+ Keys.ENTER,"Wash the dishes"+Keys.ENTER,"Take care of baby"+ Keys.ENTER,
            "Help your kid's homework"+Keys.ENTER,"Study Selenium"+Keys.ENTER,"Sleep"+Keys.ENTER);


        List<WebElement> todoList= driver.findElements(By.tagName("li"));
        System.out.println("todoList.size() = " + todoList.size());
        Actions action = new Actions(driver);
        for(WebElement each: todoList){
            action.moveToElement(each).perform();
            action.click(each).perform();
            WebElement delete=driver.findElement(By.xpath("(//i[@class='fa fa-trash'])[1]"));
            action.click(delete).perform();
            waitFor(2);
        }
        // for(WebElement each: todoList){    BU ÇALIŞMADI BU YÜZDEN DELETE BUTONU EACH LOOP İÇİNE KOYDUM
        //     each.clear();

        List<WebElement>toDoListDeleted=driver.findElements(By.tagName("li"));
        Assert.assertEquals(0,toDoListDeleted.size());


        }

    }

