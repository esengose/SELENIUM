package day13_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test(){
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//input[@type='searchh']")).sendKeys("QA"+ Keys.ENTER); //org.openqa.selenium.NoSuchElementException:
    }
}
