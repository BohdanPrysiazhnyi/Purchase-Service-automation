package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackOfficeDashboardPage extends BasePagePurchaseService {

    private final static String CHANGE_SERVICE_BUTTON= "//a[contains(text(),'Change Service')]";
    public BackOfficeDashboardPage(WebDriver driver) {
        super(driver);
    }


    public  void clickOnChangeServiceButton(){
        driver.findElement(By.xpath(CHANGE_SERVICE_BUTTON)).click();
    }




}
