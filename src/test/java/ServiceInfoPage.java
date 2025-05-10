import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ServiceInfoPage extends BasePage {
    public ServiceInfoPage(WebDriver driver) {
        super(driver);
    }

    public void verifyUrlAndReturnBack(String initialUrl) {
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty"));
        driver.navigate().back();
        wait.until(ExpectedConditions.urlToBe(initialUrl));
    }
}