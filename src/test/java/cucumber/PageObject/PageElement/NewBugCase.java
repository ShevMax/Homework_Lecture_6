package cucumber.PageObject.PageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NewBugCase {

// кнопка отрытия нового тест-кейса
    public static SelenideElement newCaseButton = $x("//a[@id='create_link']");

// заголовок окна Создание задачи
    public static SelenideElement createTaskPage=$x("//h2[text()='Создание задачи']");

// кнопка Настроить поля в Создании задачи
    public static SelenideElement configureFieldsButton = $x("//span[@class='aui-icon aui-icon-small aui-iconfont-configure']");

// кнопка выбора поля в Настройке поля
    public static SelenideElement clickFieldsButton = $x("//select[@id='configure-fields']");

// выбор значение поля Пользовательские поля
    public static SelenideElement clickUserFieldsButton = $x("//option[@class='qf-configurable']");

// поле Тип задачи в окне Создание задачи
    public static SelenideElement clickFieldTypeTask = $x("//input[@id='issuetype-field']");

// поле Тема в окне Создание задачи
    public static SelenideElement fieldTopic = $x("//input[@class='text long-field']");

// поле Описание в окне Создание задачи
    public static SelenideElement descriptionTask = $x("//div[@id='description-wiki-edit']//iframe");

// ввод данных в поле Описание в окне Создание задачи
    public static SelenideElement descriptionFieldTask = $x("//p");

// поле выбора Приоритета в окне Создание задачи
    public static SelenideElement fieldPrioritySelection = $x("//div[@id='priority-single-select']");

// поле Затронутые версии в окне Создание задачи
    public static SelenideElement affectedVersionsField = $x("//div[@id='environment-wiki-edit']//iframe");

// выбор версии 2 в поле Исправить версии в окне Создание задачи
    public static SelenideElement fixVersion = $x("(//option[@value='10001'])[1]");

// выбор версии в поле Затронутые версии в окне Создание задачи
    public static SelenideElement choosingVersion = $x("(//option[@value='10001'])[2]");

// Назначить меня Исполнителем тест-кейса
    public static SelenideElement changePerformerButton = $x("//button[contains(text(), 'Назначить меня')]");

// кнопка Создать в окне Создания задачи
    public static SelenideElement clickCreateButton = $x("//input[@id='create-issue-submit']");

// кнопка Отменить в окне Создание задачи
    public static SelenideElement clickCancelButton = $x("//button[@class='aui-button aui-button-link cancel']");

// кнопка изменения статуса вновь заведенного тест-кейса
    public static SelenideElement changeStatusButton = $x("//span[@class='trigger-label' and text()='В работе']");

// кнопка Бизнесс-процесс в окне вновь заведенного тест-кейса
    public static SelenideElement businessProcessButton = $x("//a[@id='opsbar-transitions_more']");

// кнопка Выполнено в окне Бизнес-процесс
    public static SelenideElement executedProcessButton2 = $x("//span[@class='trigger-label' and text()='Выполнено']");

// строка Мои открытые задачи в поле Переключить фильтр
    public static SelenideElement myOpenTask = $x ("//a[@data-item-id='myopenissues']");

// открытие тест-кейса с названием Test-case for solving a bug
    public static SelenideElement openMyTestCase = $x("//li[contains(@title,'test-case for solving a bug') and @class='focused']");

// статус тест-кейса с названием Test-case for solving a bug
    public static SelenideElement statusValue = $x("//span[contains(@class,'jira-issue-status-lozenge')]");















}
