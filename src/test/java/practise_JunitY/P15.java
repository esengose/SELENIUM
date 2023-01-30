package practise_JunitY;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P15 extends TestBase {
     /*
    Given
        Go to https://testpages.herokuapp.com/ (Siteye gidin)
    When
        Click on File Downloads   (File Downloads / Dosya İndir tıklayın)
    And
        Click on Server Download (Server Download tıklayın)
    Then
        Verify that file is downloaded (Dosyanın indirildiğini doğrulayın)

     */
    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/");
        driver.findElement(By.xpath("//a[@id='download']")).click();
        driver.findElement(By.id("server-download")).click();

        String filePath=System.getProperty("user.home")+"/Downloads/textfile.txt/";
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);

       /* String userHome=System.getProperty("user.home");
        String userDir=System.getProperty("user.dir");
        System.out.println("userHome = " + userHome);
        System.out.println("userDir = " + userDir);*/

    }
}
