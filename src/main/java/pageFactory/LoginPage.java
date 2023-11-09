package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
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
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHFNButtonVisible(){
        return hfnButton.isDisplayed();
    }
    public void clickOnHFNButton(){
        hfnButton.click();
    }

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


    public void click(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click", loginButton);
    }

    }

