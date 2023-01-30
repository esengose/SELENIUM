package practise_JunitY;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class P08 extends TestBase {
    @Test
    public void test(){
 /*
    Given
    Go to https://cgi-lib.berkeley.edu/ex/fup.html

    When
    Type "My File" into "Notes about the file" input  (Notes about the file bu kısma My File yaz)
    And
    Click "Choose File" button (Choose file bas)
    And
    Select the file to upload (Yüklemek için dosya seç)
    And
    Click on "Press" button  (Press butonuna bas)
    Then
    Assert that "Your notes on the file were" equals "My File" (Bu iki tırnak işaretinin eşit oldugunu kontrol et)
    And
    Assert that file Content contains "Hello, I am uploaded file" (Tırmak işareti içindeki yazıyı file Content in içerdiğini kontrol et)
     */
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        driver.findElement(By.xpath("//input[@name='note']")).sendKeys("My File");

        String userHome=System.getProperty("user.home");
        System.out.println("userHome = " + userHome);
        driver.findElement(By.name("upfile")).sendKeys(userHome+ "/Practise01.sql");  //FILE PATH   USER HOME+  VE DOSYA İSMİ
        driver.findElement(By.xpath("//input[@value='Press']")).click();  //(PRESS BUTONU)

        String note = driver.findElement(By.xpath("//blockquote")).getText();
        assertEquals("My File",note);

        String fileContent = driver.findElement(By.xpath("//pre")).getText();
        assertTrue(fileContent.contains("Hello, I am uploaded file"));




    }

}
