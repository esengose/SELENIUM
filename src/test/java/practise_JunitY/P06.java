package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P06 extends TestBase {
    @Test
    public void test() {
     /*
    Given
    Go to https://www.gmibank.com/
    When
    Hover over "Premium" Deposit Package
    And
    Click on "Book now"
    Then
    Verify url contains "services"
     */
        driver.get("https://www.gmibank.com/");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("(//h4[@class='pricing-title'])[2]"))).perform();

        action.click(driver.findElement(By.xpath("//a[.='Book Now']"))).perform();

        String url=driver.getCurrentUrl();
        String expectedWord="services";
        Assert.assertTrue(url.contains(expectedWord));

        driver.close();
    }
}