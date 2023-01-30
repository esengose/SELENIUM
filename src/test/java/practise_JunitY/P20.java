package practise_JunitY;

import org.apache.poi.ss.formula.functions.LookupUtils;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P20 {
 /*
     Given
        Save EarningList.xlsx file into your project   (Projenize EarningList.xlsx dosyasını kaydedin)
    When
        In the row column, write the row numbers according to the earnings amount. (Row isimli sütunu kazancın mikatına göre sıralayıp doldur, 1,2,3 gibi)
    Then
        Assert that row number of Wednesday is 1 (wednesday ın 1 oldugunu doğrula)

        NOTE: I do not need to extend to TestBase. We are not doing UI test, we are just doing local data/ excel test. (EXTEND TESTBASE E GEREK YOK)
     */
    @Test
    public void test() throws IOException {
        String path ="C:\\Users\\GamePower\\IdeaProjects\\MavenProject\\src\\test\\java\\resources\\EarningList.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbookObj = WorkbookFactory.create(fileInputStream);
        Sheet sheetObj= workbookObj.getSheet("Sheet1");
        Row rowObj= sheetObj.getRow(1);
        Cell cellObj=rowObj.createCell(2);
     /*   cellObj.setCellValue("2");
        sheetObj.getRow(2).createCell(2).setCellValue("5");
        sheetObj.getRow(3).createCell(2).setCellValue("1");
        sheetObj.getRow(4).createCell(2).setCellValue("4");
        sheetObj.getRow(5).createCell(2).setCellValue("3");
        sheetObj.getRow(6).createCell(2).setCellValue("6");
        sheetObj.getRow(7).createCell(2).setCellValue("6");*/

        List<Double> earnings=new ArrayList<>();

        for(int i=1; i<=sheetObj.getLastRowNum(); i++){

            earnings.add(Double.valueOf(sheetObj.getRow(i).getCell(1).toString()));
        }
        System.out.println("earnings = " + earnings);

        List<Double>sortedEarnnigs=new ArrayList<>(earnings);
        Collections.sort(sortedEarnnigs);
        Collections.reverse(sortedEarnnigs);
        System.out.println("sortedEarnnigs = " + sortedEarnnigs);

        for(int i=0; i<earnings.size(); i++){
            for(int j=0; j<earnings.size(); j++){
                if(sortedEarnnigs.get(i)==earnings.get(j)){
                    sheetObj.getRow(j+1).createCell(2).setCellValue(i+1);
                }
            }
        }


        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbookObj.write(fileOutputStream);

        Assert.assertEquals("1.0",sheetObj.getRow(3).getCell(2).toString());



    }
}
