import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTestEcho {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

}
