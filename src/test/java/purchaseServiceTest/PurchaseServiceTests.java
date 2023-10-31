package purchaseServiceTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class PurchaseServiceTests {
    @BeforeTest
    public void setUp(){
        WebDriver driver = new ChromeDriver();
    }

    @BeforeMethod
    public void testSetUp(){

    }

    @AfterTest
    public void tearDown(){

    }
}
