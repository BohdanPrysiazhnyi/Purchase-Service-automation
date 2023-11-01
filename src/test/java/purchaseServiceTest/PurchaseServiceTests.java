package purchaseServiceTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class PurchaseServiceTests {

    WebDriver driver;


    @BeforeTest
    public void setUp(){
    }

    @BeforeMethod
    public void testSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dashboard-2645.trademax-test.com/spa/login");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
