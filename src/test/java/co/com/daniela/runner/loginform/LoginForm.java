package co.com.daniela.runner.loginform;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/loginform/login.feature"},
        glue = "co.com.daniela.stepdefinition.loginform.LoginFormStepDefinitions",
        tags = "@Regresion"
)
public class LoginForm {
}
