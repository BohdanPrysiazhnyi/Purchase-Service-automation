package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
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
import pageFactory.AppManager;
import pageFactory.LoginPage;
import pageFactory.backofficepages.BackOfficeDashboardPage;
import pageFactory.purchaseservicepages.PurchaseServiceDashboardPage;
import pageFactory.purchaseservicepages.PurchaseServiceGeneral;
import pageFactory.purchaseservicepages.PurchaseServiceOrdersListPage;

import java.io.File;
import java.io.IOException;

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

    private static int TIME_TO_WAIT = 10;



    @Before
    public void setUp(){
        appManager = new AppManager();
        appManager.init();
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        driver.get(appManager.BASE_URL);

    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Attachment(value = "Screenshot", type = "image/png")

    @AfterStep
    public void afterStep(io.cucumber.java.Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            // Capture screenshot and attach to Allure report
            takeScreenshot();
        }
    }
    @Attachment(type = "image/png")
    private void takeScreenshot() throws IOException {
        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
    }

    @Given("User opens start page")
    public void userOpensStartPage() {
        loginPage = pageFactoryManager.getLoginPage();
        //loginPage.openLoginPage(appManager.BASE_URL);
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
        backOfficeDashboardPage.waitUntilElementToBeClickable(TIME_TO_WAIT,backOfficeDashboardPage.getLogOutButton());
        assertTrue(backOfficeDashboardPage.getLogOutButton().isDisplayed());

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
        Allure.parameter("Login", login);
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
        assertTrue(loginPage.getAllertOnLoginPage());
        assertEquals(errorMessage,loginPage.getErrorMessageOnLoginPage());
    }
}
