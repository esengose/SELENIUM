package practise_ErolHoca.week03;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P02 extends TestBase {

    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */
    @Test
    public void test() {

        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com");
        waitFor(5);
        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies=driver.manage().getCookies();
        waitFor(5);
        System.out.println("cookies.size() = " + cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for(Cookie w: cookies){
            System.out.println("w.getName()+\" \"+w.getValue() = " + w.getName() + " " + w.getValue());
        }
        //Yeni bir cookie ekleyiniz
        Cookie myLittleCookie= new Cookie("myLittleCookie","1234567");
        driver.manage().addCookie(myLittleCookie);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie>newCookies=driver.manage().getCookies();
        for(Cookie w: newCookies){
            System.out.println("new cookies sayısı= "+ newCookies.size());
            System.out.println(w.getName());
        }
        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookieNamed("myLittleCookie");

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
    }
}