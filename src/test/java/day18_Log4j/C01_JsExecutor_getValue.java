package day18_Log4j;

import org.junit.Test;
import utilities.TestBase;

public class C01_JsExecutor_getValue extends TestBase {
    //      1)getValueTest metotu olustur
//  2)https://www.priceline.com/ a git
//            3)Tarih kısmındaki Yazili metinleri al ve yazdır
    @Test
    public void getValueTest(){
        driver.get("https://www.priceline.com/");
        getValueByJS("hotelDates");

    }
}
