package junit;

import com.codeborne.selenide.junit.ScreenShooter;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import junit.WebHooks.WebHooks;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static junit.PageObject.PageFunctions.LoginPageFunction.authorization;
import static junit.PageObject.PageFunctions.NewBugCaseFunctions.NewBugCaseMethod;
import static junit.PageObject.PageFunctions.NewBugCaseFunctions.searchNewTestCase;
import static junit.PageObject.PageFunctions.TestProjectPageFunctions.*;
import static utils.Configuration.getConfigurationValue;

public class JiraTest extends WebHooks {
    @Epic(value = "UI-aвтотест")
    @Feature(value = "Тестирование баг-трекера Jira компании iFellow")
    @Story(value = "JUnit + Selenide")
    @Test
    @Tag("Test1")
    @DisplayName("1. Авторизоваться в edujira.ifellow.ru")
    public void Test_1() {
        authorization(getConfigurationValue("login"));
    }

    @Epic(value = "UI-aвтотест")
    @Feature(value = "Тестирование баг-трекера Jira компании iFellow")
    @Story(value = "JUnit + Selenide")
    @Test
    @Tag("Test2")
    @DisplayName("2. Открыть страницу проекта TestProject и список задач")
    public void Test_2() {
        authorization(getConfigurationValue("login"));
        clickProjectButton();
    }

    @Epic(value = "UI-aвтотест")
    @Feature(value = "Тестирование баг-трекера Jira компании iFellow")
    @Story(value = "JUnit + Selenide")
    @Test
    @Tag("Test3")
    @DisplayName("3. Открыть список задач в проекте TestProject и вывести общее количество заведенных задач")
    public void Test_3() {
        authorization(getConfigurationValue("login"));
        clickProjectButton();
        clickTaskList();
    }

    @Epic(value = "UI-aвтотест")
    @Feature(value = "Тестирование баг-трекера Jira компании iFellow")
    @Story(value = "JUnit + Selenide")
    @Test
    @Tag("Test4")
    @DisplayName("4. Открыть задачу TestSelenium_bug, проверить статус и привязку к версии - Version 2.0")
    public void Test_4() {
        authorization(getConfigurationValue("login"));
        clickProjectButton();
        clickTaskList();
        searchTaskMethod(getConfigurationValue("task"));
    }

    @Epic(value = "UI-aвтотест")
    @Feature(value = "Тестирование баг-трекера Jira компании iFellow")
    @Story(value = "JUnit + Selenide")
    @Test
    @Tag("Test5")
    @DisplayName("5. Создать новый тест-кейс с описанием")
    public void Test_5() {
        authorization(getConfigurationValue("login"));
        clickProjectButton();
        clickTaskList();
        searchTaskMethod(getConfigurationValue("task"));
        NewBugCaseMethod(getConfigurationValue("topicJunit"));
    }

    @Epic(value = "UI-aвтотест")
    @Feature(value = "Тестирование баг-трекера Jira компании iFellow")
    @Story(value = "JUnit + Selenide")
    @Test
    @Tag("Test6")
    @DisplayName("6. Поиск вновь заведённого тест-кейса и его закрытие")
    public void Test_6() {
        authorization(getConfigurationValue("login"));
        clickProjectButton();
        clickTaskList();
        searchTaskMethod(getConfigurationValue("task"));
        NewBugCaseMethod(getConfigurationValue("topicJunit"));
        searchNewTestCase(getConfigurationValue("topicJunit"));
        searchNewTestCase(getConfigurationValue("topicJunit"));
    }
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();
}
