package api;

import api.RickAndMorty.RickAndMortyApiJava;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static api.Specifications.requestRickAndMorty;
import static io.restassured.RestAssured.given;

public class TestRickAndMortyApiUsingCucumber extends RickAndMortyApiJava {
    public static String locationMortySmith;
    public static String speciesMortySmith;
    public static int lastEpisodeIdMortySmith;
    public static int lastEpisodeMortySmith;
    public static String lastEpisodeNumberMortySmith;
    public static String numberLastPersonageToLastEpisode;
    public static int idLastPersonageToLastEpisode;
    public static int LastPersonageToLastEpisode;
    public static String nameLastPersonageToLastEpisode;
    public static String locationLastPersonageToLastEpisode;
    public static String speciesLastPersonageToLastEpisode;

    @Step("найти информацию о персонаже Морти Смит зная его ID {id}")
    @When("найти информацию о персонаже Морти Смит зная его ID {string}")
    public static void searchMortySmith(String id) {
        Response responseOK200 = given()
                .when()
                .spec(requestRickAndMorty())
                .get("/character/" + id)
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract().response();
        JSONObject namePersonage = new JSONObject(responseOK200.getBody().asString());
        locationMortySmith = namePersonage.getJSONObject("location").get("name").toString();
        speciesMortySmith = namePersonage.get("species").toString();
        lastEpisodeIdMortySmith = namePersonage.getJSONArray("episode").length() - 1;
        lastEpisodeNumberMortySmith = namePersonage.getJSONArray("episode").get(lastEpisodeIdMortySmith).toString();
        lastEpisodeMortySmith = Integer.parseInt(lastEpisodeNumberMortySmith.replaceAll("\\D", ""));
    }

    @Step("из полученного списка эпизодов найти последний эпизод, в нем найти индекс последнего задействованного в этом эпизоде персонажа")
    @Then("из полученного списка эпизодов найти последний эпизод, в нем найти индекс последнего задействованного в этом эпизоде персонажа")
    public static void searchLastPersonageToLastEpisode() {
        Response responseOK200 = given()
                .spec(requestRickAndMorty())
                .when()
                .get("/episode/" + lastEpisodeMortySmith)
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract().response();
        JSONObject lastPersonage = new JSONObject(responseOK200.getBody().asString());
        idLastPersonageToLastEpisode = lastPersonage.getJSONArray("characters").length() - 1;
        numberLastPersonageToLastEpisode = lastPersonage.getJSONArray("characters").get(idLastPersonageToLastEpisode).toString();
        LastPersonageToLastEpisode = Integer.parseInt(numberLastPersonageToLastEpisode.replaceAll("\\D", ""));
    }

    @Step("получить данные о его имени, местонахождении и расе")
    @And("получить данные о его имени, местонахождении и расе")
    public static void searchLocationAndSpeciesLastPersonage() {
        Response responseOK200 = given()
                .spec(requestRickAndMorty())
                .when()
                .get("/character/" + LastPersonageToLastEpisode)
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract().response();
        JSONObject lastPersonage = new JSONObject(responseOK200.getBody().asString());
        nameLastPersonageToLastEpisode = lastPersonage.get("name").toString();
        locationLastPersonageToLastEpisode = lastPersonage.getJSONObject("location").get("name").toString();
        speciesLastPersonageToLastEpisode = lastPersonage.get("species").toString();
    }

    @Step("сравнить: расу и локацию этого персонажа с аналогичными данными Морти")
    @And("сравнить: расу и локацию этого персонажа с аналогичными данными Морти")
    public static void assertSpecies() {
        Assertions.assertEquals(speciesMortySmith, speciesLastPersonageToLastEpisode, "Персонажы относятся к разным расам!");
    }
    public static void assertLocation(){
        Assertions.assertNotEquals(locationMortySmith, locationLastPersonageToLastEpisode, "Персонажы находятся в разных местах!");
    }
}

