package practise_JunitY;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class P21 extends TestBase {
    //We will make a roof of 5% of the height of the earliest built tower. (en erken yapılan binanın yükseklğinin %5 i kadar çatı yapacağız)
    //Find how many meters we will build. (kaç metre inşa edeceğimizi bulalım)  :

    /*
     Given
        Go to https://www.techlistic.com/p/demo-selenium-practice.html    (Siteye gidin)
    When
        Put all built years into a list    (Tüm built yılları bir liste içine koyun)
    And
        Calculate min year    (minimum yılı hesaplayın)
    And
        Put all heights into a list    (tüm yükseklik bilgilerini bir liste içine koyun)
    And
        Calculate the height to build   ( built yüksekliğini hesaplayın)
    Then
        Assert that build height is 25.45 meters (build height yüksekliğinin 25.45 metre oldugunu doğrulayın
     */
    @Test
    public void test(){
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        List<WebElement> builtYears=driver.findElements(By.xpath("//table[@border='1']//tbody//tr//td[4]"));
        List<String>builtYeartoString=new ArrayList<>();
        for(WebElement w: builtYears){
            builtYeartoString.add(w.getText());
        }
        System.out.println("builtYeartoString = " + builtYeartoString); // 2010, 2012, 2004, 2008

       int minyear=Integer.parseInt(builtYeartoString.get(0).toString());  //sort işlemi yapmadan dizdik
       for(String w: builtYeartoString){
           if(Integer.parseInt(w)<minyear){
               minyear=Integer.parseInt(w);
           }
       }
        System.out.println("min year:"+minyear);                 //2004

        //Find index min year
        int idxOfMinYear = 0;
        for (int i = 0; i < builtYears.size(); i++) {
            if (Integer.parseInt(builtYears.get(i).getText()) == minyear){
                idxOfMinYear = i;
            }
        }
        System.out.println("idxOfMinYear = " + idxOfMinYear);





        List<WebElement>heights=driver.findElements(By.xpath("//table[@border='1']//tbody//tr//td[3]"));

        double heightToBuild = Integer.parseInt(heights.get(idxOfMinYear).getText().replaceAll("\\D", ""))*0.05;
        System.out.println("heights.get(idxOfMinYear).getText() = " + heights.get(idxOfMinYear).getText());//509m
        //Calculate the total height
        int totalHeight = 0;
        for(WebElement w : heights){
            totalHeight += Integer.parseInt(w.getText().substring(0,3));
        }
        System.out.println("Total height : " + totalHeight); //2431
        //Assert that build height is 25.45 meters
        System.out.println("heightToBuild = " + heightToBuild);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedHeight = decimalFormat.format(heightToBuild);
        System.out.println("You will build: " + formattedHeight + " meters");
        assertEquals("25,45",formattedHeight); //bunu hoca 25.45 yazdi ama benim pcnin . , sorunsalindan virgul yaptim ben.
    }

    }

