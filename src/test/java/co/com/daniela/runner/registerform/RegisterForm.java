package co.com.daniela.runner.registerform;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src\\test\\resources\\features\\registerform\\register.feature"},
        glue = "co.com.daniela.stepdefinition.registerform.RegisterFormStepDefinitions",
        tags = "@Regresion"
)
class RegisterForm {
}
