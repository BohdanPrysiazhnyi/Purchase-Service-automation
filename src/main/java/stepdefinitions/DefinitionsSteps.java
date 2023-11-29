package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import manager.PageFactoryManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageFactory.AppManager;
import pageFactory.LoginPage;
import pageFactory.backofficepages.BackOfficeDashboardPage;
import pageFactory.purchaseservicepages.PurchaseServiceDashboardPage;
import pageFactory.purchaseservicepages.PurchaseServiceGeneral;
import pageFactory.purchaseservicepages.PurchaseServiceOrdersListPage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;


public class DefinitionsSteps {

    LoginPage loginPage;
    BackOfficeDashboardPage backOfficeDashboardPage;
    PurchaseServiceGeneral purchaseServiceGeneral;
    PurchaseServiceOrdersListPage purchaseServiceOrdersListPage;
    PurchaseServiceDashboardPage purchaseServiceDashboardPage;
    PageFactoryManager pageFactoryManager;

    WebDriver driver;
    AppManager appManager;

    private static int TIME_TO_WAIT = 20;


    @Before
    public void setUp() {
        appManager = new AppManager();
        appManager.init();
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        driver.get(appManager.BASE_URL);

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        }
        driver.quit();
    }

    @Given("User opens start page")
    public void userOpensStartPage() {
        loginPage = pageFactoryManager.getLoginPage();
        //loginPage.openLoginPage(appManager.BASE_URL);
    }

    @When("User click on HFN login button")
    public void userClickOnHFNLoginButton() {
        loginPage.waitUntilElementToBeClickable(TIME_TO_WAIT, loginPage.getHfnButton());
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
        backOfficeDashboardPage.waitForPageLoadComplete(TIME_TO_WAIT);
        backOfficeDashboardPage.waitUntilElementToBeClickable(TIME_TO_WAIT, backOfficeDashboardPage.getLogOutButton());
        assertTrue(backOfficeDashboardPage.getLogOutButton().isDisplayed());

    }


    @And("User click on login button")
    public void userClickOnLoginButton() {
        loginPage.waitUntilElementToBeClickable(TIME_TO_WAIT, loginPage.getLoginButton());
        loginPage.clickOnLoginButton();
    }

    @When("User click on additional login methods button")
    public void userClickOnAdditionalLoginMethodsButton() {
        loginPage.clickOnAdditionalLoginMethodButton();
    }

    @And("User click on standart login button")
    public void userClickOnStandartLoginButton() {
        loginPage.waitUntilElementToBeClickable(TIME_TO_WAIT, loginPage.getStandartLoginButton());
        loginPage.clickOnStandartLoginButton();
    }

    @And("User click on standartLogin email field and enter {string}")
    public void userClickOnStandartLoginTextFieldAndEnter(String login) {
        Allure.parameter("Login", login);
        loginPage.waitUntilElementToBeClickable(TIME_TO_WAIT, loginPage.getStandartLoginEmailTextField());
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
        assertTrue(loginPage.getAllertOnLoginPage());
        assertEquals(errorMessage, loginPage.getErrorMessageOnLoginPage());
    }

    @Then("User verify that login to the system is not successful")
    public void userVerifyThatLoginToTheSystemIsNotSuccessful() {
        loginPage.waitVisibilityOfElement(TIME_TO_WAIT, loginPage.getErrorMessagePopup());
        assertTrue(loginPage.isErrorPopUpDisplayed());
    }

    @And("User click on change service button")
    public void userClickOnChangeServiceButton() {
        backOfficeDashboardPage = pageFactoryManager.getBackOfficeDashboardPage();
        backOfficeDashboardPage.waitUntilElementToBeClickable(TIME_TO_WAIT, backOfficeDashboardPage.getChangeServiceButton());
        backOfficeDashboardPage.clickOnChangeServiceButton();
    }

    @Then("User verify that all default widgets are displayed on the Purchase Service Dashboard page")
    public void userVerifyThatAllDefaultWidgetsAreDisplayedOnThePurchaseServiceDashboardPage() {
        purchaseServiceDashboardPage = pageFactoryManager.getPurchaseServiceDashboardPage();
        purchaseServiceDashboardPage.waitForVisibilityOfListOfElements(TIME_TO_WAIT, purchaseServiceDashboardPage.getList());
        purchaseServiceDashboardPage.waitUntilElementToBeClickable(TIME_TO_WAIT, purchaseServiceDashboardPage.widget());
        assertEquals(purchaseServiceDashboardPage.quantityOfDisplayedWidgets(), 8);
    }

    @And("User click on Purchase Service button")
    public void userClickOnPurchaseServiceButton() {
        backOfficeDashboardPage.clickOnPurchaseServiceButton();
    }

    @And("User click on the Purchase Orders list tab")
    public void userClickOnThePurchaseOrdersListTab() {
        purchaseServiceGeneral = pageFactoryManager.getPurchaseServiceGeneral();
        purchaseServiceGeneral.waitUntilElementToBeClickable(TIME_TO_WAIT, purchaseServiceGeneral.getPurchaseOrdersListButton());
        purchaseServiceGeneral.clickOnPurchaseOrdersListPage();
    }

    @And("User click on the first Purchase Order docNo from list")
    public void userClickOnTheFirstPurchaseOrderDocNoFromList() {
        purchaseServiceOrdersListPage = pageFactoryManager.getPurchaseServiceOrdersListPage();
        purchaseServiceOrdersListPage.waitForVisibilityOfListOfElements(TIME_TO_WAIT, purchaseServiceOrdersListPage.getListOfPurchaseOrdersDocNo());
        purchaseServiceOrdersListPage.clickOnFirstPurchaseOrderDocNo();
    }
}
