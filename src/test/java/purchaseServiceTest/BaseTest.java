package purchaseServiceTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageFactory.AppManager;
import pageFactory.backofficepages.BackOfficeDashboardPage;
import pageFactory.LoginPage;
import pageFactory.purchaseservicepages.PurchaseServiceDashboardPage;
import pageFactory.purchaseservicepages.PurchaseServiceGeneral;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private AppManager appManager;
//    private static final String PURCHASE_SERVICE_URL = "http://dashboard-5925.trademax-test.com/page/dashboard";


    @BeforeTest
    public void profileSetUp (){
        chromedriver().setup();
    }

    @BeforeMethod
    public void tests_setUp(){
        appManager = new AppManager();
        appManager.init();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(appManager.BASE_URL);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
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

}
