import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Lesson15 {
    static WebDriver driver = new ChromeDriver();

    @BeforeAll
    static void setUp() {

        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
    }

    @AfterAll
    static void closeDriver() {
        driver.quit();
    }

    @Test
    @Order(1)
    void checkBlockName() {
        try {
            WebElement acceptCookie = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(., 'Принять')]")));
            acceptCookie.click();
        } catch (TimeoutException ignored) {
        }
        WebElement blockName = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']//h2")));
        assertEquals("Онлайн пополнение\nбез комиссии", blockName.getText().trim());
    }

    @Test
    @Order(2)
    void checkPaymentLogos() {
        try {
            WebElement acceptCookie = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(., 'Принять')]")));
            acceptCookie.click();
        } catch (TimeoutException ignored) {
        }

        List<WebElement> logos = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='pay__partners']//img")));
        Assertions.assertTrue(logos.size() == 5);
    }

    @Test
    @Order(3)
    void moreAboutServiceSameWindow() {
        try {
            WebElement acceptCookie = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(., 'Принять')]")));
            acceptCookie.click();
        } catch (TimeoutException ignored) {
        }

        String initialUrl = driver.getCurrentUrl();

        WebElement aboutLink = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.linkText("Подробнее о сервисе")));
        aboutLink.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("poryadok-oplaty"));

        driver.navigate().back();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(initialUrl));
    }

    @Test
    @Order(4)
    void paymentContinueButton() {
        try {
            WebElement acceptCookie = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(., 'Принять')]")));
            acceptCookie.click();
        } catch (TimeoutException ignored) {
        }

        WebElement phoneNumber = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
        phoneNumber.sendKeys("297777777");

        WebElement paySum = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-sum")));
        paySum.sendKeys("2");

        WebElement continueButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button__default '][1]")));
        continueButton.click();

        WebElement payWindow = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class = 'bepaid-iframe']")));

        Assertions.assertTrue(payWindow.isDisplayed());
    }
}
