
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ServiceInfoPage18 extends BasePage18 {
    public ServiceInfoPage18(WebDriver driver) {
        super(driver);
    }
    @Step("Проверить URL и вернуться назад")
    public void verifyUrlAndReturnBack(String initialUrl) {
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty"));
        driver.navigate().back();
        wait.until(ExpectedConditions.urlToBe(initialUrl));
    }
}
