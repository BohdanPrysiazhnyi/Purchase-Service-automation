package purchaseServiceTest;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    private static final String LOGIN ="test.testsson";
    private static final String PASSWORD= "pt72r=P+=_";
    private static final long TIME_TO_WAIT = 30;



    @Test
    public void loginToTheSystem(){
        getLoginPage().implicitWait(TIME_TO_WAIT);

        getLoginPage().clickOnHFNButton();
        getLoginPage().clickOnLoginTextFieldAndEnterLogin(LOGIN);
        getLoginPage().clickOnPasswordTextFieldAndEnterPassword(PASSWORD);
        getLoginPage().clickOnLoginButton();
        getLoginPage().waitForPageLoadComplete(TIME_TO_WAIT);
        getLoginPage().implicitWait(TIME_TO_WAIT);
    }
}
