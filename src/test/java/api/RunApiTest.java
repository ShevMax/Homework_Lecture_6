package api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static api.RickAndMorty.RickAndMortyApiJava.*;
import static api.Tomato.TomatoApiJava.createUser;

public class RunApiTest {

    @Epic(value = "API-aвтотест")
    @Feature(value = "Тестирование API веб-сайта https://rickandmortyapi.com")
    @Story(value = "JUnit + RestAssured")
    @Test
    @DisplayName("Задача 1. Погружение в API")

    public void resultsRickAndMortyTest() {
        searchMortySmith("2");
        searchLastPersonageToLastEpisode();
        searchLocationAndSpeciesLastPersonage();
        assertSpecies();
        assertLocation();
    }

    @Epic(value = "API-aвтотест")
    @Feature(value = "Тестирование API веб-сайта https://reqres.in/")
    @Story(value = "JUnit + RestAssured")
    @Test
    @DisplayName("Задача 2. Углубление в API")

    public void resultsReqresTest() throws IOException {
        createUser();
    }
}
