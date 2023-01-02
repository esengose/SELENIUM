package day07_testbase_Alert_IFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);

        String actualresult=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedresult="You clicked: Cancel";

        Assert.assertEquals(actualresult,expectedresult);


    }
}
