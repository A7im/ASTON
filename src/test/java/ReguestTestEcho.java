import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class ReguestTestEcho extends BaseTestEcho{

    @Test
    void testGetRequest() {
        Response response = given()
                .queryParam("foo1", "bar1")
                .when()
                .get("/get")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertEquals("bar1", response.jsonPath().getString("args.foo1"));
        assertNotNull(response.jsonPath().get("headers"));
    }

    @Test
    void testPostRequest() {
        JSONObject requestBody = new JSONObject()
                .put("data", "test_value");

        Response response = given()
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .post("/post")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertEquals("test_value", response.jsonPath().getString("json.data"));
        assertTrue(response.jsonPath().getMap("headers").containsKey("x-forwarded-port"));
    }

    @Test
    void testPutRequest() {
        JSONObject requestBody = new JSONObject()
                .put("update", "new_value");

        Response response = given()
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .put("/put")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertEquals("new_value", response.jsonPath().getString("json.update"));
    }

    @Test
    void testDeleteRequest() {
        Response response = given()
                .contentType("application/json")
                .when()
                .delete("/delete")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertTrue(response.jsonPath().getMap("headers").containsKey("host"));
    }

}
