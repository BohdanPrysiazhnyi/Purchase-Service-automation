package pageFactory.purchaseservicepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactory.BasePage;

import java.util.List;

public class PurchaseServiceOrdersListPage extends BasePage {
    @FindBy(xpath = "//div[@class='ag-cell-wrapper']")
    private List<WebElement>  listOfPurchaseOrdersDocNo;
    @FindBy(xpath = "//a[contains(text(),\"Purchase Lines\")]")
    private WebElement purchaseLinesTabButton;
    public PurchaseServiceOrdersListPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstPurchaseOrderDocNo(){
        listOfPurchaseOrdersDocNo.get(0).click();
    }

    public WebElement getFirstPurchaseOrdersDocNo(){
       return listOfPurchaseOrdersDocNo.get(0);
    }
    public int quantityOfPurchaseOrdersDisplayedOnThePage(){
        return listOfPurchaseOrdersDocNo.size();
    }
    public void clickOnPurchaseLinesTabButton(){
        purchaseLinesTabButton.click();
    }
    public WebElement getPurchaseLinesTabButton(){
        return purchaseLinesTabButton;
    }
    public List<WebElement> getListOfPurchaseOrdersDocNo(){
        return listOfPurchaseOrdersDocNo;
    }
}
