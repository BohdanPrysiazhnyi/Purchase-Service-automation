package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseServiceGeneral extends BasePage{
    public PurchaseServiceGeneral(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a//span[contains(text(),\"Purchase Orders\")]")
    private WebElement purchaseOrdersListPage;




    public void clickOnPurchaseOrdersListPage(){
        purchaseOrdersListPage.click();
    }
}
