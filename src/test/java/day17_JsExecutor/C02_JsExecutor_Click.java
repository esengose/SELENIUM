package day17_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_JsExecutor_Click extends TestBase {
    @Test
    public void test(){
        //  clickByJSTest
        //  Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");

        //  LMS LOGIN elementine tikla
        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));

        //  Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et
        waitFor(3);
        Assert.assertEquals("https://lms.techproeducation.com/",driver.getCurrentUrl());
    }

}
