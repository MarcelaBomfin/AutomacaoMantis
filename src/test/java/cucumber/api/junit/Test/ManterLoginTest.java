package cucumber.api.junit.Test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature/ManterLogin.feature", glue = {
		"classpath:cucumber.api.junit.StepDefinitions", "classpath:cucumber.api.junit.Hooks" })
public class ManterLoginTest {
}
