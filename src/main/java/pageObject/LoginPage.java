package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

import static org.openqa.selenium.By.*;

public class LoginPage extends BasePagePurchaseService{

    private static final String HFN_BUTTON = "//div[@id='authServiceWidget']";
    private static final String LOGIN_TEXT_FIELD = "//input[@name='username']";
    private static final String PASSWORD_TEXT_FIELD ="//input[@name='password']";
    private static final String LOGIN_BUTTON = "//button[@class='log-btn']";
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnHFNButton(){
        driver.findElement(xpath(HFN_BUTTON)).click();
    }

    public void clickOnLoginTextFieldAndEnterLogin(final String LOGIN){
        driver.findElement(xpath(LOGIN_TEXT_FIELD)).clear();
        driver.findElement(xpath(LOGIN_TEXT_FIELD)).sendKeys(LOGIN, Keys.TAB);
    }

    public void clickOnPasswordTextFieldAndEnterPassword(final String PASSWORD){
        driver.findElement(xpath(PASSWORD_TEXT_FIELD)).clear();
        driver.findElement(xpath(PASSWORD_TEXT_FIELD)).sendKeys(PASSWORD);
    }

    public void clickOnLoginButton(){
        driver.findElement(xpath(LOGIN_BUTTON)).click();
    }

    }

