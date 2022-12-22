package day05_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
@BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
en son @AfterClass'i calistiririz.
    Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
 */
   @BeforeClass
    public static void setUp(){
       System.out.println("Her test methodundan önce çalışır");
   }
   @AfterClass
    public static void tearDown(){
       System.out.println("Her test methodundan sonra çalışır");
   }
   @Test
    public void test(){
       System.out.println("ilk test");
   }

   @Test
    public void test2(){
       System.out.println("ikinci test");
   }

   @Before
    public void test3(){
       System.out.println("Testlerden önce çalışır");
   }

   @After
    public void test4(){
       System.out.println("Testlerden sonra çalışır");
   }

    @Test
    @Ignore //Çalıştırmak istemediğimiz testler için kullanırız
    public void test03() {
        System.out.println("Ikinci Test");

    }











}
