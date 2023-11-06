package purchaseServiceTest;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import junit.framework.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.openqa.selenium.devtools.v85.page.Page.captureScreenshot;

public class LoginTest extends BaseTest{
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
        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

        screenshot();

        Assert.assertEquals(8, getPurchaseServiceDashboardPage().quantityOfDisplayedWidgets());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
