import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

class PaymentPage extends BasePage {
    private By paymentFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    private By amountDisplay = By.xpath("//div[@class = 'pay-description__cost']");
    private By phoneDisplay = By.xpath("//div[@class = 'pay-description__text']");
    private By cardNumberInput = By.xpath("//label[@class ='ng-tns-c2312288139-1 ng-star-inserted']");
    private By expiryDateInput = By.xpath("//label[@class = 'ng-tns-c2312288139-4 ng-star-inserted']");
    private By cvcInput = By.xpath("//label[@class = 'ng-tns-c2312288139-5 ng-star-inserted']");
    private By paymentSystemIcons = By.cssSelector("img[src*='system']:not([style*='opacity: 0'])");
    private By submitButton = By.xpath("//button[@class='colored disabled']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPaymentFrameDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentFrame)).isDisplayed();
    }

    public String getDisplayedAmount() {
        driver.switchTo().frame(driver.findElement(paymentFrame));
        String amount = wait.until(ExpectedConditions.visibilityOfElementLocated(amountDisplay)).getText();
        driver.switchTo().defaultContent();
        return amount;
    }

    public String getDisplayedPhoneNumber() {
        driver.switchTo().frame(driver.findElement(paymentFrame));
        String phone = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneDisplay)).getText();
        driver.switchTo().defaultContent();
        return phone;
    }

    public String getCardNumberLabel() {
        driver.switchTo().frame(driver.findElement(paymentFrame));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberInput)).getText();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public String getExpiryDateLabel() {
        driver.switchTo().frame(driver.findElement(paymentFrame));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(expiryDateInput)).getText();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public String getCvcLabel() {
        driver.switchTo().frame(driver.findElement(paymentFrame));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(cvcInput)).getText();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public int getPaymentSystemsCount() {
        driver.switchTo().frame(driver.findElement(paymentFrame));
        try {
            return driver.findElements(paymentSystemIcons).size();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    public String getSubmitButtonText() {
        driver.switchTo().frame(driver.findElement(paymentFrame));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).getText();
        driver.switchTo().defaultContent();
        return text;
    }

}
