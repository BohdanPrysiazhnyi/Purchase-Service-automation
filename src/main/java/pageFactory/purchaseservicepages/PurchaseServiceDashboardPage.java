package pageFactory.purchaseservicepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.BasePage;

import java.util.List;

public class PurchaseServiceDashboardPage extends BasePage {
    public PurchaseServiceDashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='LUeq']")
    private List<WebElement> purchaseServiceWidgets;


    public int quantityOfDisplayedWidgets(){
        return purchaseServiceWidgets.size();
    }
    public WebElement widget(){
        return purchaseServiceWidgets.get(0);
    }
}
