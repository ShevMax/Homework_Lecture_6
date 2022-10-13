package cucumber.PageObject.PageElement;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

//определение локатора поля ввода логина
    public static SelenideElement loginField = $x("//input[@id='login-form-username']");

// определение локатора поля ввода пароля
    public static SelenideElement passwordField = $x("//input[@id='login-form-password']");

// определение локатора кнопки входа в аккаунт
    public static SelenideElement inputButton = $x("//input[@class='aui-button aui-button-primary']");

//  проверка на ошибку авторизации
    public static SelenideElement currentUsername = $x("//a[@id='header-details-user-fullname']");
//    public static SelenideElement forAssert = $x ("//h1");

}
