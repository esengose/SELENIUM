package practise_ErolHoca.week05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P03 extends TestBase {
    @Test
    public void test() {
        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
        List<WebElement> otelBilgileri = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr"));
        for (WebElement each : otelBilgileri) {
            // System.out.println("each.getText() = " + each.getText());
        }
        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        int row = 1;
        for (WebElement w : otelBilgileri) {
            if (w.getText().contains("601m")) {
                System.out.println(row + ". satır : " + w.getText());
            }
            row++;
        }
        //Bütün Height bilgilerini yazdırınız
        List<WebElement> allHeights = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr//td[3]"));
        for (WebElement each : allHeights) {
            System.out.println("each.getText() = " + each.getText());
        }
        //Otel uzunluklarının hepsini toplayınız
        List<String> list = new ArrayList<>();   //webelement yükseklikler listimi String bir list içine attım
        for (WebElement w : allHeights) {
            list.add(w.getText());
        }
        for (int i = 0; i < list.size(); i++) {             //String listimi set list methoduyla replace ederek m leri sildim yerine hiçlik koydm
            list.set(i, list.get(i).replaceAll("m", ""));
        }
        System.out.println("list = " + list);

        int sum = 0;
        for (String s : list) {                         //String listin Integer degerini alarak toplama yaptım
            sum = sum + Integer.valueOf(s);
        }
        System.out.println("Toplam uzunluk= " + sum);

        //Bir method ile satır ve sutun bilgilerini çağıralım
        tabloSatirSutun(3,4);  //3.satir 4.sütun
    }
        private void tabloSatirSutun (int satir, int sutun){
            System.out.println(satir + ". satir ve " +sutun+".sutun : "+ driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tbody//tr["+satir+"]//td["+sutun+"]")).getText());
        }
    }
