package QaClickAcademy.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/QaClickAcademy/features",
		glue = "QaClickAcademy.stepDefinitions"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
