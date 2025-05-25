import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class BasePage18 {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage18(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Принять cookies, если отображаются")
    protected void acceptCookiesIfPresent() {
        try {
            WebElement acceptCookie = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Принять')]")));
            acceptCookie.click();
        } catch (TimeoutException ignored) {
        }
            }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}