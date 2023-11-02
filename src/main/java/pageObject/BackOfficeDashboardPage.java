package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BackOfficeDashboardPage extends BasePagePurchaseService {


    @FindBy(xpath = "//div[@class='ivu-menu-submenu-title']//span[contains(text(),'Sales Orders')]")
    private WebElement changeServiceButton;
    public BackOfficeDashboardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getChangeServiceButton(){
        return changeServiceButton;
    }
    public  void clickOnChangeServiceButton(){
        changeServiceButton.click();
    }




}
