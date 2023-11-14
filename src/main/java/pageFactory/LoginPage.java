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

    }

