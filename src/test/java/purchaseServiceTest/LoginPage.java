package purchaseServiceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage extends PurchaseServiceTests{

@Test
    public void clickOnLoginButton(){
    WebElement revealed = driver.findElement(By.xpath("//div[@id='authServiceWidget']"));
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='authServiceWidget']")));

    driver.findElement(By.xpath("//div[@id='authServiceWidget']")).click();
    }
}
