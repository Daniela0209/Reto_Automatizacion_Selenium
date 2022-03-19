package co.com.daniela.runner.contactform;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/contactform/contact.feature"},
        glue ="co.com.daniela.stepdefinition.contactform.ContactFormStepDefinition",
        tags = "@regresion"
)
public class ContactForm {
}
