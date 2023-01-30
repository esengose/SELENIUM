package practise_ErolHoca.week05;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P05 {
    @Test
    public void test() throws IOException {
        //Data isimli excel dosyasına yeni kullanıcı adı ve password ekliyelim


        String filePath = "C:\\Users\\GamePower\\Downloads\\data.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb= WorkbookFactory.create(fis);
        wb.getSheet("Sayfa1").createRow(3).createCell(0).setCellValue("2.Kullanıcı Bilgileri");
        wb.getSheet("Sayfa1").createRow(4).createCell(0).setCellValue("email");
        wb.getSheet("Sayfa1").createRow(5).createCell(0).setCellValue("password");

        FileOutputStream fos = new FileOutputStream(filePath);
        wb.write(fos);

        //Yeni bir methodda kullanıcı bilgileri başlığını silelim
        hucreSil(3,0);
    }
    private void hucreSil(int row, int cell) throws IOException {
        String filePath = "C:\\Users\\GamePower\\Downloads\\data.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb= WorkbookFactory.create(fis);
        Sheet sheeet = wb.getSheet("Sayfa1");
        Row roww = sheeet.getRow(row);
        Cell celll= roww.getCell(cell);
        roww.removeCell(celll); //hucre silmek için removecell

        FileOutputStream fos= new FileOutputStream(filePath);
        wb.write(fos);
    }
}