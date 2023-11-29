package pageFactory.purchaseservicepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.BasePage;

import java.util.ArrayList;
import java.util.List;

public class PurchaseServiceDashboardPage extends BasePage {
    @FindBy(xpath = "//div[@class='LUeq']")
    private List<WebElement> purchaseServiceWidgets;

    public PurchaseServiceDashboardPage(WebDriver driver) {
        super(driver);
    }


    public int quantityOfDisplayedWidgets() {
        return purchaseServiceWidgets.size();
    }

    public WebElement widget() {
        return purchaseServiceWidgets.get(0);
    }
    public List<WebElement> getList(){
        return purchaseServiceWidgets;
    }
}
