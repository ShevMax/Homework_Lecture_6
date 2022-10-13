package cucumber.PageObject.PageElement;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class TestProjectPage {

// переход в проект TestProject
    public static SelenideElement menuProjectsButton = $x("//a[@id='browse_link']");

// выбор элемента Test в поле Текущие проекты
    public static SelenideElement selectElementTestProject = $x("//a[@id='admin_main_proj_link_lnk']");

// кнопка подменю Задачи
    public static SelenideElement taskList = $x("//span[@class='aui-icon aui-icon-large icon-sidebar-issues aui-iconfont-issues']");

// переключение фильтра на Все задачи
    public static SelenideElement switchFilter = $x("//button[@id='subnav-trigger']");

// кнопка Переключить фильтр
    public static SelenideElement allTasks = $x("//a[@data-item-id='allissues']");

// значение общего количества открытых задач
    public static SelenideElement valueAllTasks = $x("//span[starts-with(text(),'1')]");
    //div[@class='showing']/child::span

// поле Поиск для последующего ввода тест-кейса TestSelenium_bug
    public static SelenideElement searchString = $x("//input[@placeholder='Поиск']");

// проверка статуса
    public static SelenideElement checkStatus = $x("//span[@id='status-val']");

// проверка версии
    public static SelenideElement checkVersion = $x("//span[@id='fixVersions-field']");
//a[contains(@title,'Version')]



}
