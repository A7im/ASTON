import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class ReguestTestEcho extends BaseTestEcho {

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
    void testFormDataRequest() {

        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("username", "Fix")
                .formParam("email", "fix@gmail.com")
                .when()
                .post("/post")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertEquals("Fix", response.jsonPath().getString("form.username"));
        assertEquals("fix@gmail.com", response.jsonPath().getString("form.email"));
        assertNotNull(response.jsonPath().getString("headers.content-type"));
        assertTrue(response.jsonPath().getString("headers.content-type").contains("x-www-form-urlencoded"));
    }

    @Test
    void testPutRequest() {
        JSONObject requestBody = new JSONObject()
                .put("update", "505");

        Response response = given()
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .put("/put")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertEquals("505", response.jsonPath().getString("json.update"));
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
