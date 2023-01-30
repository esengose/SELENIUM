package day15_ExtentReport_WebTables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    private static Logger logger = LogManager.getLogger(C02_WebTables.class.getName());
    @Test
    public void table1Print() {
        driver.get("https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("TABLE 1 VERILERI");
        System.out.println(table1);
        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
//        tumVeriler.forEach(t-> System.out.println(t.getText()));//LAMDA
        for (WebElement veri : tumVeriler) {
            System.out.println(veri.getText());
            logger.info("table 1 verileri");
        }
    }

    @Test
    public void row3Print() {
        //    Task 2 : 3. Row’ datalarını print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> row3Elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        row3Elements.forEach(veri -> System.out.println(veri.getText()));
    }

    //    Task 3 : Son row daki dataları print edin
    @Test
    public void sonSatirVerileri() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatir = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonSatir.forEach(veri -> System.out.println(veri.getText()));
    }

    //    Task 4 : 5. Column datalarini print edin
    @Test
    public void sutun5Test() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sutun5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        sutun5.forEach(veri -> System.out.println(veri.getText()));
    }

    //    Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //    Parameter 1 = row numarasi
    //    Parameter 2 = column numarasi
    //    printData(2,3);  => 2nd row, 3rd column daki datayı print etsin



    public void printData (int row,int column) {
        WebElement tableData=driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + row + "]//td[" +column + "]"));
        System.out.println(tableData.getText());
    }

    @Test
    public void printDataTest() {
        driver.get("https://the-internet.herokuapp.com/tables");
        printData(2,3);
    }


}






























