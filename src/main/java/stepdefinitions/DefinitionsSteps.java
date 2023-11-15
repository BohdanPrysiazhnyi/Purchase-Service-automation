package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
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

    private static int TIME_TO_WAIT = 40;


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
        loginPage.waitUntilElementToBeClickable(TIME_TO_WAIT,loginPage.getHfnButton());
        loginPage.clickOnHFNButton();
    }

    @And("User click on Login text field and enter {string}")
    public void userClickOnLoginTextFieldAndEnter(String login) {
        loginPage.clickOnLoginTextFieldAndEnterLogin(login);
    }

    @And("User click on Password text field and enter {string}")
    public void userClickOnPasswordTextFieldAndEnter(String password) {
        loginPage.clickOnPasswordTextFieldAndEnterPassword(password);
    }


    @Then("User verify that login to the system is successful")
    public void userVerifyThatLoginToTheSystemIsSuccessful() {
        backOfficeDashboardPage = new BackOfficeDashboardPage(driver);
        backOfficeDashboardPage.waitUntilElementToBeClickable(TIME_TO_WAIT,backOfficeDashboardPage.getAccountButton());
        Assert.assertTrue(backOfficeDashboardPage.getAccountButton().isDisplayed());
    }


    @And("User click on login button")
    public void userClickOnLoginButton() {
        loginPage.waitUntilElementToBeClickable(TIME_TO_WAIT,loginPage.getLoginButton());
        loginPage.clickOnLoginButton();
    }

    @When("User click on additional login methods button")
    public void userClickOnAdditionalLoginMethodsButton() {
        loginPage.clickOnAdditionalLoginMethodButton();
    }

    @And("User click on standart login button")
    public void userClickOnStandartLoginButton() {
        loginPage.waitUntilElementToBeClickable(TIME_TO_WAIT,loginPage.getStandartLoginButton());
        loginPage.clickOnStandartLoginButton();
    }

    @And("User click on standartLogin email field and enter {string}")
    public void userClickOnStandartLoginTextFieldAndEnter(String login) {
        loginPage.waitUntilElementToBeClickable(TIME_TO_WAIT,loginPage.getStandartLoginEmailTextField());
        loginPage.clickOnStandartEmailTextFieldAndTextLogin(login);
    }

    @And("User click on standartLogin Password text field and enter {string}")
    public void userClickOnStandartLoginPasswordTextFieldAndEnter(String arg0) {
        loginPage.clickOnStandartLoginPasswordTextFieldAndTextLogin(arg0);
    }

    @And("User click on signIn button")
    public void userClickOnSignInButton() {
        loginPage.clickOnSignInButton();
    }


    @Then("User verify that login to the system is not successful {string}")
    public void userVerifyThatLoginToTheSystemIsNotSuccessful(String errorMessage) {
        loginPage.waitForPageLoadComplete(TIME_TO_WAIT);
        Assert.assertTrue(loginPage.getAllertOnLoginPage());
        Assert.assertEquals(errorMessage,loginPage.getErrorMessageOnLoginPage());
    }
}
