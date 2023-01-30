package day16_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C01_ExcelRead {
    @Test
    public void readExcelTest() throws IOException {
        //java dosyasına sağ tıkla ve resources adında bir klasör oluştur
        //excel dosyasını bu klasöre at
        //Resources dosyası excel, word, text gibi data dosyalarının oldugu klasördür

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

        //İLK SATIRDAKİ İLK VERİYİ AL
          Cell cell1 = row1.getCell(0); //ilk hücredeki datayı verir

        //VERİYİ YAZDIR
         System.out.println(cell1);

        // 1. SATIR 2. SUTUN
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println(cell12);

        String cell31=sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);

        //Exceldeki toplam satır sayısını bulunuz
        int toplamSatırSayısı=sheet1.getLastRowNum()+1;//son satir numarasi.index 0dan basliyor. sayma sayilari 1 den. +1 ekle
        System.out.println(toplamSatırSayısı); //11

        //Exceldeki toplam sütun sayısını bulunuz
        int toplamSütunSayısı=sheet1.getPhysicalNumberOfRows();
        System.out.println(toplamSütunSayısı); // 1den başladığı için +1 EKLEMİYORUZ

        //COUNTRY, CAPITALS key ve valueları map alıp print etmek istiyoruz
        Map<String,String> ulkeBaskentleri=new HashMap<>();
        for (int satirSayisi=1;satirSayisi<toplamSatırSayısı;satirSayisi++){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
        }
        System.out.println(ulkeBaskentleri);
        TreeMap a = new TreeMap<>(ulkeBaskentleri);
        System.out.println(a);



    }
}
