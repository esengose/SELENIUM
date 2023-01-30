package challange_quest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class chlday15 extends TestBase {
    @Test
    public void test(){
        //https://www.way2automation.com/angularjs-protractor/webtables/
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
        //tüm E-mail leri yazdırın
        String tableXPath= "//table[@table-title='Smart Table example']";
        columnDataList(tableXPath,7);
        //Tüm E-maillerin "@" işareti içerdiğini doğrulayin
        Assert.assertTrue(tableXPath.contains("@"));

    }
    public List<WebElement> columnDataList (String tableXPath,int column){
        List<WebElement> columnDatas=driver.findElements(By.xpath(tableXPath+"//tbody//tr//td[" +column+"]"));
        for(WebElement each: columnDatas){
            System.out.println(each.getText());
        }
        return columnDatas;
    }

           @Test
           public void methodTest(){
        driver.get("https://the-internet.herokuapp.com/tables");
        String tableXPath= "//table[@id='table1']";
        columnDataList(tableXPath,3);//tablonun 3.sütunu
        rowDataList(tableXPath,4);  //tablonun 4.satırı
    }

    public List<WebElement> rowDataList (String tableXpath, int row){
        List<WebElement>rowDatas=driver.findElements(By.xpath(tableXpath+"//tbody//tr[" + row +"]"));
        for(WebElement each: rowDatas){
            System.out.println(each.getText());
        }
        return rowDatas;
    }

}
