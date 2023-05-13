package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features = "src/test/resource/Feature/login.feature",
					glue= {"StepDefinition","Hooks"},
					plugin = { "pretty", "html:target/tutorialNinja/loginfeature.html" })

public class TestRunner {

}
