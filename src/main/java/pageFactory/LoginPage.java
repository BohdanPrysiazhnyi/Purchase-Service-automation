package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//div[@id='authServiceWidget']")
    private WebElement hfnButton;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement loginTextField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//button[@class='log-btn']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[contains(text(),\"Show additional login methods\")]")
    private WebElement additionalLoginMethods;
    @FindBy(xpath = "//span[contains(text(),\"Standard Login\")]")
    private WebElement standartLoginButton;
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement standartLoginEmailTextField;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement standartLoginPasswordTextField;
    @FindBy(xpath = "//button[@type='button']")
    private WebElement signInButton;
    @FindBy(xpath = "//span[@class='alert']")
    private WebElement errorMessageOnLogin;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage(String url) {
        driver.get(url);
    }
    public void clickOnHFNButton(){
        hfnButton.click();
    }
    public WebElement getHfnButton(){return hfnButton;}
    public WebElement getLoginButton(){return loginButton;}

    public void clickOnLoginTextFieldAndEnterLogin(final String LOGIN){
        loginTextField.clear();
        loginTextField.sendKeys(LOGIN);
    }

    public void clickOnPasswordTextFieldAndEnterPassword(final String PASSWORD){
        passwordTextField.clear();
        passwordTextField.sendKeys(PASSWORD);
    }

    public void clickOnLoginButton(){

        loginButton.click();
    }
    public void clickOnAdditionalLoginMethodButton(){
        additionalLoginMethods.click();
    }
    public void clickOnStandartLoginButton(){
        standartLoginButton.click();
    }
    public WebElement getStandartLoginButton(){
        return standartLoginButton;
    }
    public void clickOnStandartEmailTextFieldAndTextLogin(String email){
        standartLoginPasswordTextField.clear();
        standartLoginEmailTextField.sendKeys(email);
    }
    public WebElement getStandartLoginEmailTextField(){
        return standartLoginEmailTextField;
    }
    public void clickOnStandartLoginPasswordTextFieldAndTextLogin(String password){
        standartLoginPasswordTextField.clear();
        standartLoginPasswordTextField.sendKeys(password);
    }
    public void clickOnSignInButton(){
        signInButton.click();
    }
    public boolean getAllertOnLoginPage(){
        return errorMessageOnLogin.isDisplayed();
    }
    public String getErrorMessageOnLoginPage (){
        return errorMessageOnLogin.getText();
    }

    }

