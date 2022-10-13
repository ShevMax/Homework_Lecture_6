package cucumber.StepDefinition;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.junit.Assert;


public class CalculatorTestSteps {
    private Calculator calculator;
    double x;
    double y;
    double total;

    @Step("два числа {x} и {y}")
    @Given("два числа {double} и {double}")
    public void twoNumbers(double x, double y) {
        this.x = x;
        this.y = y;
        this.calculator = new Calculator();
    }

    @Step("вычисляем сумму двух чисел")
    @When("вычисляем сумму двух чисел")
    public void  sumOfTwoNumbers() {
        total = calculator.sum(x, y);
    }

    @Step("результат должен быть равен {total}")
    @Then("результат должен быть равен {double}")
    public void resultIsEqualTo(double result) {
        Assert.assertEquals(result, total, 0);
    }
}
