package day16_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void writeExcelTest() throws IOException {
        //  WORKBOOK > WORKSHEET/SHEET (SAYFA) > ROW (SATIR) > CELL (VERI HUCRESI)
        // String path="./src/test/java/resources/Capitals.xlxs";
        String path =".\\src\\test\\java\\resources\\Capitals.xlsx";//WINDOWS

        //DOSYAYI AÇ
        FileInputStream fileInputStream = new FileInputStream(path);

        //EXCEL DOSYASINI AÇ - WORKBOOK AÇ
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //SAYFAYI AÇ -SHEET AÇ
        // Sheet sheet1 = workbook.getSheetAt(0); //index 0 dan başlar, ilk sayfayı açar
        Sheet sheet1 = workbook.getSheet("Sheet1"); //sheet in ismi ile çağrılır

        //İLK SATIRA GİT/ROW
        Row row1= sheet1.getRow(0); //indexle ilk satıra gider

        //İLK SATIR 3.SÜTUNU CREATE ET
        Cell cell3=row1.createCell(2);

        //NÜFUS YAZ
        cell3.setCellValue("NÜFUS");

        //2.satır 3.sütuna 450000
        sheet1.getRow(1).createCell(2).setCellValue("450000");
        //3.satır 3.sütuna 350000
        sheet1.getRow(2).createCell(2).setCellValue("350000");

        //KAYDET
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);



    }
}
