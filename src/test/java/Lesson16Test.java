import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование сайта МТС")
@Feature("Основной функционал оплаты")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ScreenshotWatcher.class)
public class Lesson16Test {
    static WebDriver driver;
    static MainPage mainPage;
    static String initialUrl;
    @RegisterExtension
    ScreenshotWatcher watcher = new ScreenshotWatcher();


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
    @DisplayName("Проверка корректности заголовка блока")
    @Description("Тест проверяет, что заголовок блока соответствует ожидаемому")
    void checkBlockName() {
        assertEquals("Онлайн пополнениЯ\nбез комиссии", mainPage.getBlockTitleText());
    }

    @Test
    @Order(2)
    @DisplayName("Проверка количества платежных логотипов")
    @Description("Тест проверяет наличие 5 логотипов платежных систем")
    void checkPaymentLogos() {
        assertEquals(5, mainPage.getPaymentLogosCount());
    }

    @Test
    @Order(3)
    @DisplayName("Переход на страницу информации о сервисе")
    @Description("Тест проверяет переход по ссылке и возврат на исходную страницу")
    void moreAboutServiceSameWindow() {
        ServiceInfoPage serviceInfoPage = mainPage.clickDetailsLink();
        serviceInfoPage.verifyUrlAndReturnBack(initialUrl);
    }

    @Test
    @Order(4)
    @DisplayName("Проверка плейсхолдеров для всех типов оплаты")
    @Description("Тест проверяет корректность плейсхолдеров для 4 типов оплаты")
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
    @DisplayName("Проверка формы оплаты")
    @Description("Тест проверяет отображение фрейма оплаты, суммы, номера телефона и полей")
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