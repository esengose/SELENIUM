package practise_ErolHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P08 extends TestBase {
    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        TestBase.driver.get("https://amazon.com");
        //Dropdown menuyu yazdıralım
        List<WebElement> dropdown = TestBase.driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));

        //Select select = new Select(dropdown);
        dropdown.forEach(t-> System.out.println(t.getText()));

        //Dropdown menuden baby secelim
        //arama bölümünden milk aratalım
        TestBase.driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby"
                , Keys.TAB,"Milk",Keys.ENTER);

    }

}
