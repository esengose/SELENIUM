package exercises;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ex1 {

    WebDriver driver;
    Faker faker= new Faker();

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void register() throws InterruptedException {
        //Register User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        driver.get("http://automationexercise.com");
        String actualurl = "https://automationexercise.com/";
        String expectedurl = driver.getCurrentUrl();
        Assert.assertEquals(actualurl, expectedurl);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignUp=driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        System.out.println(newUserSignUp.getText());
        newUserSignUp.isDisplayed();

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(faker.gameOfThrones().character());
        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys(faker.internet().emailAddress());

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterInformation= driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        System.out.println(enterInformation.getText());
        enterInformation.isDisplayed();

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(faker.gameOfThrones().dragon());

        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkbox1= driver.findElement(By.xpath("//input[@name='newsletter']"));
        checkbox1.isSelected();

        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkbox2= driver.findElement(By.xpath("//input[@id='optin']"));
        checkbox2.isSelected();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        Actions action= new Actions(driver);

        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys(faker.company().name());
        driver.findElement(By.xpath("//*[@id='address1']")) .sendKeys(faker.address().fullAddress());
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(faker.address().streetName());
        WebElement country=driver.findElement(By.xpath("//*[@id='country']"));
        Select countryDrop =new Select(country);
        countryDrop.selectByVisibleText("Canada");
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys(faker.phoneNumber().phoneNumber());

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible

        WebElement accountCreated =driver.findElement(By.xpath("//b[text()='Account Created!']"));
        System.out.println(accountCreated.getText());
        accountCreated.isDisplayed();

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


        //16. Verify that 'Logged in as username' is visible
        WebElement LoggedIn =driver.findElement(By.partialLinkText("Logged in as"));
        System.out.println(LoggedIn.getText());
        LoggedIn.isDisplayed();

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeleted= driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        System.out.println(accountDeleted.getText());
        accountDeleted.isDisplayed();

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }

    @After
    public void tearDown(){
        driver.close();
    }
}