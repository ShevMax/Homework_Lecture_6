package junit.PageObject.PageFunctions;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static junit.PageObject.PageElement.TestProjectPage.*;
import static com.codeborne.selenide.Condition.visible;
import static utils.Configuration.getConfigurationValue;


public class TestProjectPageFunctions {

    @Step("Метод для перехода в проект {TestProject} и вывода списка задач")
    public static void clickProjectButton() {
        menuProjectsButton.shouldBe(visible,Duration.ofSeconds(25)).click();
        selectElementTestProject.shouldBe(visible,Duration.ofSeconds(25)).click();
        taskList.shouldBe(visible,Duration.ofSeconds(20)).click();
    }
    @Step("Метод для вывода списка задач и общего их количества")
    public static void clickTaskList() {
        switchFilter.shouldBe(visible,Duration.ofSeconds(20)).click();
        allTasks.shouldBe(visible,Duration.ofSeconds(40)).click();
        String totalNumberOfTasks = valueAllTasks.shouldBe(visible,Duration.ofSeconds(25)).getText();
        System.out.println("Общее количество заведённых задач = " + totalNumberOfTasks);
    }

    @Step("Метод поиска задачи {TestSelenium_bug} в поле Поиск, проверка её статуса и номера версии")
    public static void searchTaskMethod(String task) {
        searchString.shouldBe(visible).sendKeys(getConfigurationValue("task"));
        searchString.pressEnter();
        String statusTask = checkStatus.shouldBe(visible,Duration.ofSeconds(25)).getText();
        String versionTask = checkVersion.shouldBe(visible,Duration.ofSeconds(25)).getText();
        System.out.println("Статус тест-кейса TEST-21967 = " + statusTask + "\n" + "Номер версии тест-кейса = " + versionTask);
        Assertions.assertEquals(statusTask, "СДЕЛАТЬ", "Ошибка");
        Assertions.assertEquals(versionTask, "Version 2.0", "Ошибка");
    }
}
