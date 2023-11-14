package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactory.LoginPage;
import pageFactory.backofficepages.BackOfficeDashboardPage;
import pageFactory.purchaseservicepages.PurchaseServiceDashboardPage;
import pageFactory.purchaseservicepages.PurchaseServiceGeneral;
import pageFactory.purchaseservicepages.PurchaseServiceOrdersListPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class DefinitionsSteps {
  
    LoginPage loginPage;
    BackOfficeDashboardPage backOfficeDashboardPage;
    PurchaseServiceGeneral purchaseServiceGeneral;
    PurchaseServiceOrdersListPage purchaseServiceOrdersListPage;
    PurchaseServiceDashboardPage purchaseServiceDashboardPage;
    PageFactoryManager pageFactoryManager;

    WebDriver driver;


    @Before
    public void setUp(){
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       pageFactoryManager = new PageFactoryManager(driver);
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("User opens start page {string}")
    public void userOpensStartPage(String loginPageUrl) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.openLoginPage(loginPageUrl);
    }

    @When("User click on HFN login button")
    public void userClickOnHFNLoginButton() {
        loginPage.clickOnHFNButton();
    }

    @And("User click on Login text field and enter {string}")
    public void userClickOnLoginTextFieldAndEnter(String login) {
    }

    @And("User click on Password text field and enter {string}")
    public void userClickOnPasswordTextFieldAndEnter(String password) {
    }


    @Then("User verify that login to the system is successful")
    public void userVerifyThatLoginToTheSystemIsSuccessful() {
    }



}
