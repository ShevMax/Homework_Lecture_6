package api.Tomato;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static api.Specifications.requestReqres;
import static io.restassured.RestAssured.given;
import static utils.Configuration.getConfigurationValue;

public class TomatoApiJava {
    public static void createUser() throws IOException {

        JSONObject TomatoJson = new JSONObject(new String(Files.readAllBytes(Paths.get(getConfigurationValue("JsonPath")))));
        TomatoJson.put("name","Tomato");
        TomatoJson.put("job","Eat market");

        Response responseOK201 = given()
            .spec(requestReqres())
            .when()
            .body(TomatoJson.toString())
            .post("api/users")
            .then()
            .assertThat().statusCode(201)
            .log().all()
            .extract().response();

        JSONObject newTomatoJson = new JSONObject(responseOK201.getBody().asString());
        Assertions.assertEquals(newTomatoJson.getString("name"), TomatoJson.getString("name"), "Ошибка: имена работников не совпадают!");
        Assertions.assertEquals(newTomatoJson.getString("job"), TomatoJson.getString("job"), "Ошибка: виды работ не совпадают!");
        Assertions.assertNotNull(newTomatoJson.getString("id"), "Ошибка: поле 'id' отсутствует!");
        Assertions.assertNotNull(newTomatoJson.getString("createdAt"), "Ошибка: поле 'createdAt' отсутствует!");
    }
}
