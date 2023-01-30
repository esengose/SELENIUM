package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P17 extends TestBase {
 /*
    Given
           Go to https://testpages.herokuapp.com/styled/tag/table.html (Siteye gidin)
    When
           Calculate the total amount on the table (Verilen tablodaki miktarların toplamını hesaplayın)
    Then
            Assert the amount  (Toplam miktarı doğrulayın)
     */
    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");

        List<WebElement> amounts=driver.findElements(By.xpath("//table[@id='mytable']//tbody//tr//td[2]"));

        double sum=0;  //because 33.4 amount samples there
        for(WebElement w: amounts){
          sum+=Double.parseDouble(w.getText());
        }
        System.out.println("sum = " + sum);

        Assert.assertTrue(110.3==sum);
    }
}
