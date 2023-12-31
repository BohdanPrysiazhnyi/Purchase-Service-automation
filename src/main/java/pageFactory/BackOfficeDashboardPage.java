package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BackOfficeDashboardPage extends BasePage {


    @FindBy(xpath = "//i[@class='ivu-icon ivu-icon-ios-arrow-down']")
    private WebElement changeServiceButton;
    @FindBy(xpath = "//a[contains(text(),\"Purchase Service\")]")
    private WebElement purchaseServiceButton;

    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Create widget')]")
    private WebElement createWidgetButton;
    public BackOfficeDashboardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getChangeServiceButton(){
        return changeServiceButton;
    }
    public  void clickOnChangeServiceButton(){
        changeServiceButton.click();
    }
    public void clickOnPurchaseServiceButton(){purchaseServiceButton.click();}
    public void clickOnCreateWidgetButton(){ createWidgetButton.click();}




}
