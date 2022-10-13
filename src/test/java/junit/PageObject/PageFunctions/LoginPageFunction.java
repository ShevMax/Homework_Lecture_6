package junit.PageObject.PageFunctions;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static junit.PageObject.PageElement.LoginPage.*;
import static utils.Configuration.getConfigurationValue;


public class LoginPageFunction {

    @Step("Открываем страницу по ссылке {jiraUrl}")
    public static void openPage(String url) {
        open(url);
    }

    @Step("Авторизуемся в системе под пользователем {login}")
    public static void authorization(String login) {
        loginField.shouldBe(visible).sendKeys(getConfigurationValue("login"));
        passwordField.sendKeys(getConfigurationValue("password"));
        inputButton.shouldBe(Condition.enabled).click();
        //String elementValue = forAssert.shouldBe(visible,Duration.ofSeconds(60) ).getText();
        //Assertions.assertEquals(elementValue, "System Dashboard", "Ошибка ввода");

    }
}