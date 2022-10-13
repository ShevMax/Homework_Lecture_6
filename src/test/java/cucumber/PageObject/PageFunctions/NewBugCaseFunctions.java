package cucumber.PageObject.PageFunctions;

import cucumber.PageObject.PageElement.NewBugCase;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;

import static cucumber.PageObject.PageElement.TestProjectPage.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static utils.Configuration.getConfigurationValue;

public class NewBugCaseFunctions extends NewBugCase {

    @Step("в верхем трее меню баг-трекера Jira нажать кнопку \"Создать\"")
    @When("в верхем трее меню баг-трекера Jira нажать кнопку \"Создать\"")
    public static void NewBugCaseMethod() {
        newCaseButton.shouldBe(visible, Duration.ofSeconds(10)).click();
        createTaskPage.shouldBe(visible, Duration.ofSeconds(60));
    }
    @Step("в открывшемся окне \"Создание задачи\" заполнить необходимые поля")
    @Then("в открывшемся окне \"Создание задачи\" заполнить необходимые поля")
     public void fillBugCasePage() {
         clickFieldTypeTask.shouldBe(visible, Duration.ofSeconds(30)).click();
         clickFieldTypeTask.sendKeys("Ошибка");
         clickFieldTypeTask.pressEnter();
         fieldTopic.shouldBe(visible).sendKeys(getConfigurationValue("topicCucumber"));
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
     }

    @Step("далее нажать кнопку \"Создать\"")
     @And("далее нажать кнопку \"Создать\"")
     public static void pressCreateButton() {
          clickCreateButton.click();
        //clickCancelButton.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    @Step("в поле \"Поиск\" вводим название \"Test-case for solving a bug\" вновь заведенного тест-кейса")
    @When("в поле \"Поиск\" вводим название \"Test-case for solving a bug\" вновь заведенного тест-кейса")
    public static void searchNewTestCase() {
        taskList.shouldBe(visible, Duration.ofSeconds(20)).click();
        switchFilter.shouldBe(visible, Duration.ofSeconds(20)).click();
        myOpenTask.shouldBe(visible, Duration.ofSeconds(25)).click();
        openMyTestCase.shouldBe(visible, Duration.ofSeconds(25)).click();
    }

    @Step("в открывшемся окне заполняем все необходимы поля")
    @And("в открывшемся окне заполняем все необходимы поля")
     public void fillNewBugCasePage() {
         changeStatusButton.shouldBe(visible, Duration.ofSeconds(25)).click();
         Selenide.sleep(1000);
         String statusTestCase = statusValue.getText();
         Assertions.assertEquals(statusTestCase, "В РАБОТЕ", "Ошибка");
     }

    @Step("переводим тест-кейс \"Test-case for solving a bug\" в статус \"Выполнено\"")
    @Then("переводим тест-кейс \"Test-case for solving a bug\" в статус \"Выполнено\"")
      public static void changeStatusNewBugCase() {
        businessProcessButton.shouldBe(visible, Duration.ofSeconds(35)).click();
        executedProcessButton2.shouldBe(visible, Duration.ofSeconds(10)).click();
        Selenide.sleep(1000);
        String statusTestCaseAgain=statusValue.getText();
        Assertions.assertEquals(statusTestCaseAgain, "ГОТОВО", "Ошибка");
    }
    @Step("еще раз переводим  тест-кейс \"Test-case for solving a bug\" в статус \"Выполнено\" для его закрытия после выполнения Теста 4")
    @And("еще раз переводим  тест-кейс \"Test-case for solving a bug\" в статус \"Выполнено\" для его закрытия после выполнения Теста 4")
    public static void againChangeStatusNewBugCase() {
        taskList.shouldBe(visible, Duration.ofSeconds(20)).click();
        switchFilter.shouldBe(visible, Duration.ofSeconds(20)).click();
        myOpenTask.shouldBe(visible, Duration.ofSeconds(25)).click();
        openMyTestCase.shouldBe(visible, Duration.ofSeconds(25)).click();
        changeStatusButton.shouldBe(visible, Duration.ofSeconds(25)).click();
        Selenide.sleep(1000);
        String statusTestCase = statusValue.getText();
        Assertions.assertEquals(statusTestCase, "В РАБОТЕ", "Ошибка");
        businessProcessButton.shouldBe(visible, Duration.ofSeconds(35)).click();
        executedProcessButton2.shouldBe(visible, Duration.ofSeconds(10)).click();
        Selenide.sleep(1000);
        String statusTestCaseAgain=statusValue.getText();
        Assertions.assertEquals(statusTestCaseAgain, "ГОТОВО", "Ошибка");
    }
}