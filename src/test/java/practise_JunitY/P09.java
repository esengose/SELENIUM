package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P09 extends TestBase {

    @Test
    public void test(){
        /*
Given
Go to https://the-internet.herokuapp.com/add_remove_elements/

When
Click on the "Add Element" button 100 times  (Add element butonuna 100 kere bas)
And
Click on the "Delete" button 20 times  (Delete butonuna 20 kez bas)
Then
Assert that 20 buttons were deleted. (20 butonun silindiğini doğrula)
 */
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addbutton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for(int i=1; i<101; i++){
            addbutton.click();
        }
        List<WebElement> deleteButtons=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println(deleteButtons.size());
        for (int i= 1; i<21; i++){
            deleteButtons.get(i).click();
        }
        List<WebElement>remainButtons=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println(remainButtons.size());

        Assert.assertTrue(deleteButtons.size()-remainButtons.size()==20);


    }

}
