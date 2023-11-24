package pageFactory.purchaseservicepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.BasePage;

public class PurchaseServiceGeneral extends BasePage {
    public PurchaseServiceGeneral(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a//span[contains(text(),\"Purchase Orders\")]")
    private WebElement purchaseOrdersListPageButton;




    public void clickOnPurchaseOrdersListPage(){
        purchaseOrdersListPageButton.click();
    }
    public WebElement getPurchaseOrdersListButton (){return purchaseOrdersListPageButton;}
}
