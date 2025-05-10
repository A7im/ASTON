import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Lesson16 {
    static WebDriver driver;
    static MainPage mainPage;
    static String initialUrl;

    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
        mainPage = new MainPage(driver);
        initialUrl = driver.getCurrentUrl();
    }

    @AfterAll
    static void closeDriver() {
        driver.quit();
    }

    @Test
    @Order(1)
    void checkBlockName() {
        assertEquals("Онлайн пополнение\nбез комиссии", mainPage.getBlockTitleText());
    }

    @Test
    @Order(2)
    void checkPaymentLogos() {
        assertEquals(5, mainPage.getPaymentLogosCount());
    }

    @Test
    @Order(3)
    void moreAboutServiceSameWindow() {
        ServiceInfoPage serviceInfoPage = mainPage.clickDetailsLink();
        serviceInfoPage.verifyUrlAndReturnBack(initialUrl);
    }

    @Test
    @Order(4)
    void verifyPaymentOptionsPlaceholders() {
        String[] paymentTypes = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};

        for (String type : paymentTypes) {
            mainPage.selectPaymentType(type);

            switch (type) {
                case "Услуги связи":
                    assertEquals("Номер телефона", mainPage.getPhoneFieldPlaceholder());
                    assertEquals("Сумма", mainPage.getSumInput());
                    assertEquals("E-mail для отправки чека", mainPage.getEmailCommunicationService());
                    break;
                case "Домашний интернет":
                    assertEquals("Номер абонента", mainPage.getSubscriptionFieldPlaceholder());
                    assertEquals("Сумма", mainPage.getSumInputHomeInternet());
                    assertEquals("E-mail для отправки чека", mainPage.getEmailHomeInternet());
                    break;
                case "Рассрочка":
                    assertEquals("Номер счета на 44", mainPage.getInstallmentPlanNumberPlaceholder());
                    assertEquals("Сумма", mainPage.getSumInputSubscription());
                    assertEquals("E-mail для отправки чека", mainPage.getEmailInstallmentPlan());
                    break;
                case "Задолженность":
                    assertEquals("Номер счета на 2073", mainPage.getDebtPlaceholder());
                    assertEquals("Сумма", mainPage.getSumInputDebt());
                    assertEquals("E-mail для отправки чека", mainPage.getEmailDebt());
                    break;
            }
        }

        mainPage.selectPaymentType("Услуги связи");
    }

    @Test
    @Order(5)
    void paymentContinueButton() {
        PaymentPage paymentPage = mainPage.fillAndSubmitPaymentForm("297777777", "2");
        assertTrue(paymentPage.isPaymentFrameDisplayed());
        assertEquals("2.00 BYN", paymentPage.getDisplayedAmount());
        assertTrue(paymentPage.getDisplayedPhoneNumber().contains("375297777777"));
        assertEquals("Номер карты", paymentPage.getCardNumberLabel());
        assertEquals("Срок действия", paymentPage.getExpiryDateLabel());
        assertEquals("CVC", paymentPage.getCvcLabel());
        assertTrue(paymentPage.getPaymentSystemsCount() == 4);
        assertTrue(paymentPage.getSubmitButtonText().contains("2.00 BYN"));
    }

}