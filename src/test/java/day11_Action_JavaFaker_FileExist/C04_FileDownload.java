package day11_Action_JavaFaker_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void fileDownloadTest(){
        //Class : FileDownloadTest Method : downloadTestExist
        //https://testcenter.techproeducation.com/index.php?page=file-download   adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        waitFor(5);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String filePath=System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        boolean isDownloaded= Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);

    }
}
