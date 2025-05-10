import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

class MainPage extends BasePage {
    private By blockTitle = By.xpath("//div[@class='pay__wrapper']//h2");
    private By paymentLogos = By.xpath("//div[@class='pay__partners']//img");
    private By detailsLink = By.linkText("Подробнее о сервисе");
    private By phoneInput = By.id("connection-phone");
    private By phoneSubscription = By.id("internet-phone");
    private By sumInput = By.id("connection-sum");
    private By sumInputHomeInternet = By.id("internet-sum");
    private By sumInputSubscription = By.id("instalment-sum");
    private By sumInputDebt = By.id("arrears-sum");
    private By continueButton = By.xpath("//button[@class='button button__default ']");
    private By paymentTypeDropdown = By.xpath("//button [@class='select__header']");
    private By paymentTypeItems = By.xpath("//p[@class='select__option']");
    private By installmentPlanNumber = By.id("score-instalment");
    private By debtNumber = By.id("score-arrears");
    private By emailCommunicationService = By.id("connection-email");
    private By emailHomeInternet = By.id("internet-email");
    private By emailInstallmentPlan = By.id("instalment-email");
    private By emailDebt = By.id("arrears-email");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getBlockTitleText() {
        acceptCookiesIfPresent();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText().trim();
    }

    public int getPaymentLogosCount() {
        acceptCookiesIfPresent();
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentLogos)).size();
    }

    public ServiceInfoPage clickDetailsLink() {
        acceptCookiesIfPresent();
        wait.until(ExpectedConditions.elementToBeClickable(detailsLink)).click();
        return new ServiceInfoPage(driver);
    }

    public PaymentPage fillAndSubmitPaymentForm(String phone, String sum) {
        acceptCookiesIfPresent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput)).sendKeys(phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sumInput)).sendKeys(sum);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        return new PaymentPage(driver);
    }

    public void selectPaymentType(String typeName) {
        acceptCookiesIfPresent();

        wait.until(ExpectedConditions.elementToBeClickable(paymentTypeDropdown)).click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentTypeItems));
        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(typeName)) {
                option.click();
                break;
            }
        }
    }

    public String getPhoneFieldPlaceholder() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }


    public String getSubscriptionFieldPlaceholder() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneSubscription)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }

    public String getInstallmentPlanNumberPlaceholder() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentPlanNumber)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }

    public String getDebtPlaceholder() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(debtNumber)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }

    public String getSumInput() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(sumInput)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }

    public String getSumInputHomeInternet() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(sumInputHomeInternet)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }

    public String getSumInputSubscription() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(sumInputSubscription)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }

    public String getSumInputDebt() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(sumInputDebt)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }

    public String getEmailCommunicationService() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emailCommunicationService)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }

    public String getEmailHomeInternet() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emailHomeInternet)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }

    public String getEmailInstallmentPlan() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emailInstallmentPlan)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }

    public String getEmailDebt() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emailDebt)).getAttribute("placeholder");
        } catch (TimeoutException e) {
            return null;
        }
    }
}