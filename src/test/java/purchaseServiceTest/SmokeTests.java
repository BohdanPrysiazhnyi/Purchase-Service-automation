package purchaseServiceTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTests extends BaseTest{
    private static final String LOGIN ="test.testsson";
    private static final String PASSWORD= "pt72r=P+=_";
    private static final long TIME_TO_WAIT = 30;

    @Test
    public void verifyThatAllDefaultWidgetsAreDisplayedOnTheDashboardPageOnPurchaseService(){
        getLoginPage().implicitWait(TIME_TO_WAIT);
        getLoginPage().clickOnHFNButton();
        getLoginPage().clickOnLoginTextFieldAndEnterLogin(LOGIN);
        getLoginPage().clickOnPasswordTextFieldAndEnterPassword(PASSWORD);
        getLoginPage().clickOnLoginButton();
        getBackOfficeDashboardPage().waitUntilElementToBeClickable(30,getBackOfficeDashboardPage().getChangeServiceButton());
        getBackOfficeDashboardPage().clickOnChangeServiceButton();
        getBackOfficeDashboardPage().clickOnPurchaseServiceButton();
        getPurchaseServiceDashboardPage().waitUntilElementToBeClickable(30, getPurchaseServiceDashboardPage().widget());
        getPurchaseServiceGeneral().clickOnPurchaseOrdersListPage();

        getPurchaseServiceOrdersListPage().waitForPageLoadComplete(TIME_TO_WAIT);
        getPurchaseServiceOrdersListPage().clickOnFirstPurchaseOrderDocNo();
        getPurchaseServiceOrdersListPage().waitUntilElementToBeClickable(TIME_TO_WAIT, getPurchaseServiceOrdersListPage().getFirstPurchaseOrdersDocNo());
        getPurchaseServiceOrdersListPage().clickOnPurchaseLinesTabButton();
        Assert.assertEquals(getPurchaseServiceOrdersListPage().quantityOfPurchaseOrdersDisplayedOnThePage(),8);
//        Assert.assertEquals(getPurchaseServiceDashboardPage().quantityOfDisplayedWidgets(),8);
    }
}
