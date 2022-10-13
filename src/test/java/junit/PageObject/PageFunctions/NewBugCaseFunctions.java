package junit.PageObject.PageFunctions;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static junit.PageObject.PageElement.NewBugCase.*;
import static junit.PageObject.PageElement.TestProjectPage.switchFilter;
import static junit.PageObject.PageElement.TestProjectPage.taskList;
import static utils.Configuration.getConfigurationValue;

public class NewBugCaseFunctions {
    @Step("Метод для нажатия кнопки отрытия нового тест-кейса")
    public static void NewBugCaseMethod(String topic) {
        newCaseButton.shouldBe(visible, Duration.ofSeconds(10)).click();
        createTaskPage.shouldBe(visible, Duration.ofSeconds(60));
        clickFieldTypeTask.shouldBe(visible, Duration.ofSeconds(30)).click();
        clickFieldTypeTask.sendKeys("Ошибка");
        clickFieldTypeTask.pressEnter();
        fieldTopic.shouldBe(visible).sendKeys(getConfigurationValue("topicJunit"));
        descriptionTask.click();
        switchTo().frame(descriptionTask);
        descriptionFieldTask.setValue("Тут должен быть какой-то комментарий");
        switchTo().defaultContent();
        affectedVersionsField.click();
        switchTo().frame(affectedVersionsField);
        descriptionFieldTask.setValue("Сетевое окружение");
        switchTo().defaultContent();
        fixVersion.scrollIntoView(true).click();
        choosingVersion.scrollIntoView(true).click();
        changePerformerButton.click();
        clickCreateButton.click();
        //clickCancelButton.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Метод поиска вновь заведёного тест-кейса в поле Поиск и его закрытие")
    public static void searchNewTestCase(String topic){
        taskList.shouldBe(visible,Duration.ofSeconds(20)).click();
        switchFilter.shouldBe(visible,Duration.ofSeconds(20)).click();
        myOpenTask.shouldBe(visible,Duration.ofSeconds(25)).click();
        openMyTestCase.shouldBe(visible,Duration.ofSeconds(25)).click();
        changeStatusButton.shouldBe(visible, Duration.ofSeconds(25)).click();
        Selenide.sleep(1000);
        String statusTestCase=statusValue.getText();
        Assertions.assertEquals(statusTestCase, "В РАБОТЕ", "Ошибка");
        businessProcessButton.shouldBe(visible, Duration.ofSeconds(35)).click();
        executedProcessButton2.shouldBe(visible, Duration.ofSeconds(10)).click();
        Selenide.sleep(1000);
        String statusTestCaseAgain=statusValue.getText();
        Assertions.assertEquals(statusTestCaseAgain, "ГОТОВО", "Ошибка");
    }
}
