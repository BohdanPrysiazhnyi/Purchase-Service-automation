package manager;

import org.openqa.selenium.WebDriver;
import pageFactory.LoginPage;
import pageFactory.backofficepages.BackOfficeDashboardPage;
import pageFactory.purchaseservicepages.PurchaseServiceDashboardPage;
import pageFactory.purchaseservicepages.PurchaseServiceGeneral;
import pageFactory.purchaseservicepages.PurchaseServiceOrdersListPage;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public BackOfficeDashboardPage getBackOfficeDashboardPage() {
        return new BackOfficeDashboardPage(driver);
    }

    public PurchaseServiceGeneral getPurchaseServiceGeneral() {
        return new PurchaseServiceGeneral(driver);
    }

    public PurchaseServiceDashboardPage getPurchaseServiceDashboardPage() {
        return new PurchaseServiceDashboardPage(driver);
    }

    public PurchaseServiceOrdersListPage getPurchaseServiceOrdersListPage() {
        return new PurchaseServiceOrdersListPage(driver);
    }
}
