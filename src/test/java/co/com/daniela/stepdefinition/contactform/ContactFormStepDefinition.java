package co.com.daniela.stepdefinition.contactform;

import co.com.daniela.model.contactform.ContactFormModel;
import co.com.daniela.page.contactform.ContactFormPage;
import co.com.daniela.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class ContactFormStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(ContactFormPage.class);
    private ContactFormPage contactFormPage;
    private ContactFormModel contactFormModel;

    //Escenario correcto
    @Given("que el usuario desea enviar un mensaje a soporte")
    public void que_el_usuario_desea_enviar_un_mensaje_a_soporte() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();

            contactFormModel = new ContactFormModel();
            contactFormModel.setName("Dani");
            contactFormModel.setEmail("prueba2@gmail.com");
            contactFormModel.setPhone("3218115325");
            contactFormModel.setMessage("Tengo error de cuenta");
            LOGGER.info("GIVEN: se envia mensaje correctamente"+
                    contactFormModel.getName()+","+
                    contactFormModel.getEmail()+","+
                    contactFormModel.getPhone()+","+
                    contactFormModel.getMessage()+"");

        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }

    }

    @When("el usuario ingresa e la plataforma un nombre, telefono,email y mensaje correctos")
    public void el_usuario_ingresa_e_la_plataforma_un_nombre_telefono_email_y_mensaje_correctos() {

        try {
            contactFormPage = new ContactFormPage(driver, contactFormModel);
            contactFormPage.fillContactFormModel();
            LOGGER.info("WHEN: se obtiene el mensaje");
        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }

    }

    @Then("se mostrara un mensaje")
    public void se_mostrara_un_mensaje() {
        String result = Boolean.toString(forContactSubmittedForm().equals(contactFormPage.isContactFormDone()));
        LOGGER.info("THEN: Resultado = "+result+" "+forContactSubmittedForm()+" | "+contactFormPage.isContactFormDone());
        Assertions.assertEquals(forContactSubmittedForm(), contactFormPage.isContactFormDone());
        quiteDriver();
    }


    private List<String> forContactSubmittedForm() {
        List<String> submitedContactFormResult = new ArrayList<String>();
        submitedContactFormResult.add("Thank you " + contactFormModel.getName());
        submitedContactFormResult.add("A Customer Care Representative will be contacting you.");
        return submitedContactFormResult;
    }


    //Escenario con email incorrecto
    @Given("que el usuario desea enviar un mensaje")
    public void que_el_usuario_desea_enviar_un_mensaje() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();

            contactFormModel = new ContactFormModel();
            contactFormModel.setName("Dani");
            contactFormModel.setEmail("d7cs5");
            contactFormModel.setPhone("3218115325");
            contactFormModel.setMessage("Tengo error de cuenta");
            LOGGER.info("GIVEN: El email esta incorrecto"+
                    contactFormModel.getEmail()+",");


        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }

    @When("el usuario ingresa e la plataforma un nombre, telefono y mensaje validos y un email invalido")
    public void el_usuario_ingresa_e_la_plataforma_un_nombre_telefono_y_mensaje_validos_y_un_email_invalido() {
        try {
            contactFormPage = new ContactFormPage(driver, contactFormModel);
            contactFormPage.fillContactFormModel();
            LOGGER.info("WHEN: se obtiene un email incorrecto");
        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Then("se mostrara un mensaje de error")
    public void se_mostrara_un_mensaje_de_error() {
        String result = Boolean.toString(forContactSubmittedForm().equals(contactFormPage.isContactFormDone()));
        LOGGER.info("THEN: Resultado = "+result+" "+forContactSubmittedForm()+" | "+contactFormPage.isContactFormDone());
        Assertions.assertNotEquals(forContactSubmittedForm(), contactFormPage.isContactFormDone());
        quiteDriver();
    }


    //Escenario telefono invalido
    @Given("que el usuario desea enviar un mensaje pero con numero de telefono invalido")
    public void que_el_usuario_desea_enviar_un_mensaje_pero_con_numero_de_telefono_invalido() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();

            contactFormModel = new ContactFormModel();
            contactFormModel.setName("Dani");
            contactFormModel.setEmail("prueba2@gmail.com");
            contactFormModel.setPhone("SoyDani");
            contactFormModel.setMessage("Tengo error de cuenta");
            LOGGER.info("GIVEN: El telefono es incorrecto"+
                    contactFormModel.getPhone()+",");

        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }

    }

    @When("el usuario ingresa e la plataforma un nombre,email y mensaje validos y un telefono invalido")
    public void el_usuario_ingresa_e_la_plataforma_un_nombre_email_y_mensaje_validos_y_un_telefono_invalido() {
        try {
            contactFormPage = new ContactFormPage(driver, contactFormModel);
            contactFormPage.fillContactFormModel();
            LOGGER.info("WHEN: se obtiene un email incorrecto");
        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Then("se va a mostrar un mensaje de error")
    public void se_va_a_mostrar_un_mensaje_de_error() {
        String result = Boolean.toString(forContactSubmittedForm().equals(contactFormPage.isContactFormDone()));
        LOGGER.info("THEN: Resultado = "+result+" "+forContactSubmittedForm()+" | "+contactFormPage.isContactFormDone());
        Assertions.assertNotEquals(forContactSubmittedForm(), contactFormPage.isContactFormDone());
        quiteDriver();
    }

    //Escenario nombre invalido
    @Given("que el usuario desea enviar un mensaje pero no quiere poner su nombre")
    public void que_el_usuario_desea_enviar_un_mensaje_pero_no_quiere_poner_su_nombre() {
        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();


            contactFormModel = new ContactFormModel();
            contactFormModel.setName("894$#");
            contactFormModel.setEmail("prueba2@gmail.com");
            contactFormModel.setPhone("3218115325");
            contactFormModel.setMessage("Tengo error de cuenta");
            LOGGER.info("GIVEN: El nombre es invalido"+
                    contactFormModel.getName()+",");

        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }

    @When("el usuario ingresa e la plataforma un telefono,email y mensaje validos y un nombre invalido")
    public void el_usuario_ingresa_e_la_plataforma_un_telefono_email_y_mensaje_validos_y_un_nombre_invalido() {
        try {
            contactFormPage = new ContactFormPage(driver, contactFormModel);
            contactFormPage.fillContactFormModel();
            LOGGER.info("WHEN: se obtiene un nombre incorrecto");
        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Then("se va a mostrar un mensaje erroneo")
    public void se_va_a_mostrar_un_mensaje_erroneo() {
        Assertions.assertNotEquals(forContactSubmittedForm(), contactFormPage.isContactFormDone());
        quiteDriver();
        String result = Boolean.toString(forContactSubmittedForm().equals(contactFormPage.isContactFormDone()));
        LOGGER.info("THEN: Resultado = "+result+" "+forContactSubmittedForm()+" | "+contactFormPage.isContactFormDone());
        Assertions.assertNotEquals(forContactSubmittedForm(), contactFormPage.isContactFormDone());
        quiteDriver();

    }
}