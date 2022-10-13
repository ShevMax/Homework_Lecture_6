package cucumber;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"utils", "api", "RickAndMorty", "Tomato", "cucumber", "PageElement",
                "PageFunctions","StepDefinition"},
        plugin= {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "html:target/cucumber-html-reports",
                "json:target/cucumber.json"},
        tags = "@Calculator or @JiraTestFromCucumber or @ApiTestFromCucumber",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunCucumberTest {
    @BeforeClass
    public static void addListener (){
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().
                        screenshots(true).
                        savePageSource(false));
    }
}
