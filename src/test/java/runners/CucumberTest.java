package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/features",
    glue = "steps",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/report.html",
        "json:target/cucumber-reports/report.json"
    },
    tags = "@practice" // Run practice-automation scenarios; remove or change to run others
)
public class CucumberTest extends AbstractTestNGCucumberTests {
    // No code needed. Cucumber will scan src/test/java/features and glue in src/test/java/steps.

}
