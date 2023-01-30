package day09_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void handleCookiesTest(){
        //Class: Cookies
        //Method: handleCookies
        //Amazona git
        driver.get("https://www.amazon.com.tr/");
        waitFor(10);
        //1.toplam cookie sayisini bul
        //3. Bir Cookie yi smiyle bul
       Set<Cookie> allCookies=driver.manage().getCookies();
       int cookieNum= allCookies.size();
        System.out.println("Sayfada " + cookieNum+" adet cookie var");
        for (Cookie eachCookie : allCookies){
            System.out.println("COOKIE ISIMLERI : " + eachCookie.getName());
        }
        System.out.println("cookie isimle çağır: "+driver.manage().getCookieNamed("session-id"));

        //4. Yeni bir cookie ekle
        Cookie favoriCookiem= new Cookie("cikolatam","antem-fistikli-çikolata");
        driver.manage().addCookie(favoriCookiem);
        waitFor(3);
        System.out.println("yeni cookie sayısı: "+ driver.manage().getCookies().size());

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");

        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(3);
        System.out.println("son cookie sayısı : "+driver.manage().getCookies().size());


    }
}
