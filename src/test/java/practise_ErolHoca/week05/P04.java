package practise_ErolHoca.week05;

import org.apache.logging.log4j.core.util.JsonUtils;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P04 extends TestBase {
    @Test
    public void test() throws IOException {
        //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
        String filePath = "C:\\Users\\GamePower\\Downloads\\data.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        String email = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();
        System.out.println("email = " + email);
        String password= workbook.getSheet("Sayfa1").getRow(2).getCell(1).toString();
        System.out.println("password = " + password);

        //https://www.bluerentalcars.com/ adresine gidip
        driver.get("https://www.bluerentalcars.com/");
        //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        driver.findElement(By.xpath("(//a[@role='button'])[1]")).click();
        driver.findElement(By.id("formBasicEmail")).sendKeys(email, Keys.TAB,password,Keys.ENTER);

        //Login olduğumuzu doğrulayalım
        WebElement login = driver.findElement(By.id("dropdown-basic-button"));
        Assert.assertEquals(login.getText(),"Erol Evren");
    }



    }


