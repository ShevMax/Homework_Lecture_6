package cucumber.PageObject.PageFunctions;

import cucumber.PageObject.PageElement.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Configuration.getConfigurationValue;


public class LoginPageFunction extends LoginPage {

    @Step("в поле Логин ввести: {login}")
    @When("в поле Логин ввести: {string}")
    public void loginMethod(String login) {
        loginField.shouldBe(visible).sendKeys(login);
    }

    @Step("в поле Пароль ввести: {password}")
    @And("в поле Пароль ввести: {string}")
    public void passwordMethod(String password) {
        passwordField.sendKeys(password);
    }

    @Step("далее нажать кнопку Войти")
    @And("далее нажать кнопку Войти")
    public void pressInputButton () {
        inputButton.shouldBe(enabled).click();
    }

    @Step("из Профиля пользователя извлекается текущее имя пользователя")
    @Then("из Профиля пользователя извлекается текущее имя пользователя")
    public String getCurrentUsername() {
        return currentUsername.shouldHave(attribute("data-username")).attr("data-username");
    }

    @Step("сравниватеся с ранее введённым значением login, что является проверкой успешности авторизации")
    @And("сравниватеся с ранее введённым значением login, что является проверкой успешности авторизации")
    public void checkAuthorizationSuccessful() {
        assertTrue(currentUsername.is(visible));
        assertEquals(getConfigurationValue("login"), getCurrentUsername());
    }
}