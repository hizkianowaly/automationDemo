package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"cucumber/stepDefinitions"},
        plugin = {"pretty", "html:target/regression-report.html", "json:target/regression-report.json","io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        features = {"src/test/java/cucumber/features"},
        strict = true
)

public class regressrunner {
}
