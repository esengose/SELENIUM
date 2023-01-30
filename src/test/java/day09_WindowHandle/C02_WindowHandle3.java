package day09_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.DriverCommand;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {
    @Test
    public void test(){
        //1. TechPro education sayfasinin title'inin "Techpro Education" metnini icerdigini test edin.
        driver.get("https://www.techproeducation.com");
        String techproHandle= driver.getWindowHandle();

        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        //2. Yeni bir pencerede Amazon sayfasini acip title'in "Amazon" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW); //1.yeni pencere oluşturur 2.oraya geçiş yapar
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //3. Yeni bir pencerede LinkedIn sayfasini acip title'in "LinkedIn" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        waitFor(3);

        //        DRIVER NERDE? LINKEDINDE
//        TECHPRO SAYFASINA GITMEK ICIN TEKRAR driver.switchTo().window(techProHandle)
        driver.switchTo().window(techproHandle);
        waitFor(3);
//        DRIVER NERDE? TECHPRODA
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);

    }
}
