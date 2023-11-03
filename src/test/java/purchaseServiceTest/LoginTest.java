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
        getBackOfficeDashboardPage().waitForAjaxToComplete(30);
        getLoginPage().waitVisibilityOfElement(30,getBackOfficeDashboardPage().getChangeServiceButton());
        getBackOfficeDashboardPage().clickOnChangeServiceButton();
    }
}
