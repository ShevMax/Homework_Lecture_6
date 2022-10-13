# lecture_6
Лекция 6. (Allure)
Задание.
Обернуть готовые проекты в кукумбер, объеденить их.

Задача 1. Подключаем Allure к UI (с использованием Cucumber) 
Подключить аллюр по изученному материалу 
В созданном проекте Maven подключить библиотеку Allure для формирования отчетов.(<allure.version>2.13.2, <artifactId>allure-selenide, <artifactId>allure-rest-assured 
<artifactId>allure-cucumber6-jvm, <cucumber.6.jvm.version>2.13.6) 
Написать менеджер для формирования UI шагов в отчетности Allure.
Для помощи гуглить Allure Selenide Screenshot.
При подключении библиотеки в проекте в разделе Plugins появится allure 
 
Вызовом функции report или serve сформировать отчет. 

Задача 2. Подключаем Allure к API
Написать фильтрацию запросов и ответов для API, для того чтобы все отображалось в отчетности Allure. Для понимания логики следует обратиться во встроенный класс AllureRestAssured (он уже есть в библиотеке allureRestAssured).
