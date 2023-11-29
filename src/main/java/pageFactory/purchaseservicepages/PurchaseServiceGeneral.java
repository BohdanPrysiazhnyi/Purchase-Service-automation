package pageFactory.purchaseservicepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.BasePage;

public class PurchaseServiceGeneral extends BasePage {
    @FindBy(xpath = "//a//span[contains(text(),\"Purchase Orders\")]")
    private WebElement purchaseOrdersListPageButton;

    public PurchaseServiceGeneral(WebDriver driver) {
        super(driver);
    }


    public void clickOnPurchaseOrdersListPage() {
        purchaseOrdersListPageButton.click();
    }

    public WebElement getPurchaseOrdersListButton() {
        return purchaseOrdersListPageButton;
    }
}
