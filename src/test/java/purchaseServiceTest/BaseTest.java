package purchaseServiceTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageFactory.*;
import utils.CapabilityFactory;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
//    protected static ThreadLocal<RemoteWebDriver> driver= new ThreadLocal<>();
//    private CapabilityFactory capabilityFactory = new CapabilityFactory();

   private WebDriver driver;
    private WebDriverWait wait;
    private static final String PURCHASE_SERVICE_URL = "http://dashboard-5925.trademax-test.com";


    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

//    @BeforeMethod
//    @Parameters(value = {"browser"})
//    public void setUp(@Optional("chrome") String browser) throws  MalformedURLException {
//    driver.set(new RemoteWebDriver(new URL("http://192.168.220.236:5555/wd/hub"),capabilityFactory.getCapabilities()));
//    getDriver().manage().window().maximize();
//    getDriver().get(PURCHASE_SERVICE_URL);
//    }
    @BeforeMethod
    public void tests_setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PURCHASE_SERVICE_URL);
}


    @AfterMethod
    public void tearDown(){
        getDriver().close();
    }

    @AfterTest
    public void closeAllWindows(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public LoginPage getLoginPage (){
        return new LoginPage(getDriver());
    }

    public BackOfficeDashboardPage getBackOfficeDashboardPage(){
        return new BackOfficeDashboardPage(getDriver());
    }
    public PurchaseServiceDashboardPage getPurchaseServiceDashboardPage(){return new PurchaseServiceDashboardPage(getDriver());}
    public PurchaseServiceGeneral getPurchaseServiceGeneral(){return new PurchaseServiceGeneral(getDriver());}
    public PurchaseServiceOrdersListPage getPurchaseServiceOrdersListPage (){return new PurchaseServiceOrdersListPage(getDriver());}

}
