import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void acceptCookiesIfPresent() {
        try {
            WebElement acceptCookie = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Принять')]")));
            acceptCookie.click();
        } catch (TimeoutException ignored) {
        }
    }
}