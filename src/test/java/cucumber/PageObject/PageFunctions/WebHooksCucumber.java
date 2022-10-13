package cucumber.PageObject.PageFunctions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.open;
import static utils.Configuration.getConfigurationValue;

public class WebHooksCucumber {
    @Before(order=1, value="@JiraTestFromCucumber")
    public void openStartPage() {
        Configuration.startMaximized = true;
        open(getConfigurationValue("jiraUrl"));
    }

    @After(order=1, value="@JiraTestFromCucumber")
    public void webDriverClose() {
        WebDriverRunner.closeWebDriver();
        Configuration.reportsFolder = "build/reports/tests";
    }
}