package api;

import api.Tomato.TomatoApiJava;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static api.Specifications.requestReqres;
import static io.restassured.RestAssured.given;
import static utils.Configuration.getConfigurationValue;

public class TestTomatoApiUsingCucumber extends TomatoApiJava {
    private static JSONObject TomatoJson;
    private static JSONObject newTomatoJson;
        @Step("создать post-запрос для создания нового пользователя, передать в нём значение Tomato атрибута name, добавить атрибут job со значением Eat market")
        @When("создать post-запрос для создания нового пользователя, передать в нём значение Tomato атрибута name, добавить атрибут job со значением Eat market")
        public static void createUser() throws IOException {

        TomatoJson = new JSONObject(new String(Files.readAllBytes(Paths.get(getConfigurationValue("JsonPath")))));
        TomatoJson.put("name", "Tomato");
        TomatoJson.put("job", "Eat market");

        Response responseOK201 = given()
                .spec(requestReqres())
                .when()
                .body(TomatoJson.toString())
                .post("api/users")
                .then()
                .assertThat().statusCode(201)
                .log().all()
                .extract().response();

        newTomatoJson = new JSONObject(responseOK201.getBody().asString());
    }

        @Step("проверить, что ответ от веб-сервиса имеет статус-код 200 и валидные значения key и value")
        @Then("проверить, что ответ от веб-сервиса имеет статус-код 200 и валидные значения key и value")
        public static void chekArguments(){

        Assertions.assertEquals(newTomatoJson.getString("name"), TomatoJson.getString("name"), "Ошибка: имена работников не совпадают!");
        Assertions.assertEquals(newTomatoJson.getString("job"), TomatoJson.getString("job"), "Ошибка: виды работ не совпадают!");
        Assertions.assertNotNull(newTomatoJson.getString("id"), "Ошибка: поле 'id' отсутствует!");
        Assertions.assertNotNull(newTomatoJson.getString("createdAt"), "Ошибка: поле 'createdAt' отсутствует!");
    }
}

