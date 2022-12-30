package day07_testbaseAlert;

import org.junit.Test;
import utilities.TestBase;

public class C05_iFrame extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        Thread.sleep(5000);

    }
}