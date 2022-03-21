package co.com.daniela.stepdefinition.registerform;

import co.com.daniela.model.registerform.RegisterFormModel;
import co.com.daniela.page.contactform.ContactFormPage;
import co.com.daniela.page.registerform.RegisterFormPage;
import co.com.daniela.stepdefinition.setup.WebUI;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class RegisterFormStepDefinitions extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(RegisterFormStepDefinitions.class);
    private RegisterFormModel registerFormModel;
    private RegisterFormPage registerFormPage;


    @Given("que quiere crear una cuenta para ingresar")
    public void queQuiereCrearUnaCuentaParaIngresar() {

        Faker falseador = new Faker();

        String firsName = "Dani7";
        String lastName = "Grajales";
        String address = "calle 93 # 47 14";
        String city = "Medellín";
        String state = "Antioquia";
        String phone = "3006933166";
        String ssn = "1002655516";
        String zipCode = "0202";
        String user = falseador.name().username();
        String password = "090909";

        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();

            registerFormModel = new RegisterFormModel();
            registerFormModel.setFirstName(firsName);
            registerFormModel.setLastName(lastName);
            registerFormModel.setAddress(address);
            registerFormModel.setCity(city);
            registerFormModel.setState(state);
            registerFormModel.setPhone(phone);
            registerFormModel.setSsn(ssn);
            registerFormModel.setCodezip(zipCode);
            registerFormModel.setUser(user);
            registerFormModel.setPassword(password);
            LOGGER.info("GIVEN: Se envia el usuario correctamente"+firsName+","+
                    lastName+","+
                    address+","+
                    city+","+
                    state+","+
                    phone+","+
                    ssn+","+
                    zipCode+","+
                    user+","+
                    password);

        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }

    }

    @When("El usuario ingresa los siguientes datos: nombre, apellido,  direccion, ciudad, estado, codigozip, numero telefono, identificacion, usuario y contrasena")
    public void elUsuarioIngresaLosSiguientesDatosNombreApellidoDireccionCiudadEstadoCodigozipNumeroTelefonoIdentificacionUsuarioYContrasena() {

        try {
            registerFormPage = new RegisterFormPage(driver, 10, true, registerFormModel);
            registerFormPage.fillRegisterFormModel();
            LOGGER.info("WHEN: se obtiene el usuario");
        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Then("se creara un usuario valido para poder ingresar a la plataforma")
    public void seCrearaUnUsuarioValidoParaPoderIngresarALaPlataforma() {
        String result = Boolean.toString(registerFormDone().equals(registerFormPage.isRegisterFormDone()));
        LOGGER.info("THEN: Respuesta = "+result+" "+registerFormDone()+" | "+registerFormPage.isRegisterFormDone());
        Assertions.assertEquals(registerFormDone(), registerFormPage.isRegisterFormDone());
        quiteDriver();
    }

    private List<String> registerFormDone() {
        List<String> submitRegisterFormResult = new ArrayList<String>();
        submitRegisterFormResult.add("Welcome " + registerFormModel.getUser());
        submitRegisterFormResult.add("Your account was created successfully. You are now logged in." );
        return submitRegisterFormResult;
    }

    @Given("que desea crear una cuenta para ingresar")
    public void que_desea_crear_una_cuenta_para_ingresar() {

        Faker falseador = new Faker();

        String firsName = "";
        String lastName = "Grajales";
        String address = "calle 93 # 47 14";
        String city = "Medellín";
        String state = "Antioquia";
        String phone = "3006933166";
        String ssn = "1002655516";
        String zipCode = "0202";
        String user = falseador.name().username();
        String password = "090909";

        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();

            registerFormModel = new RegisterFormModel();
            registerFormModel.setFirstName(firsName);
            registerFormModel.setLastName(lastName);
            registerFormModel.setAddress(address);
            registerFormModel.setCity(city);
            registerFormModel.setState(state);
            registerFormModel.setPhone(phone);
            registerFormModel.setSsn(ssn);
            registerFormModel.setCodezip(zipCode);
            registerFormModel.setUser(user);
            registerFormModel.setPassword(password);
            LOGGER.info("GIVEN: El nombre es invalido"+
                    registerFormModel.getFirstName()+",");


        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }
    @When("El usuario ingresa los siguientes datos: apellido,  direccion, ciudad, estado, codigozip, numero telefono, identificacion, usuario y contrasena")
    public void el_usuario_ingresa_los_siguientes_datos_apellido_direccion_ciudad_estado_codigozip_numero_telefono_identificacion_usuario_y_contrasena() {
        try {
            registerFormPage = new RegisterFormPage(driver, registerFormModel);
            registerFormPage.fillRegisterFormModel();
            LOGGER.info("WHEN: se obtiene un nombre incorrecto");
        } catch (Exception e) {
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(), e);
        }
    }
    @Then("sale un mensaje de error por no ingresar el nombre")
    public void sale_un_mensaje_de_error_por_no_ingresar_el_nombre() {

        String result = Boolean.toString(registerFormDone().equals(registerFormPage.isRegisterFormDone()));
        LOGGER.info("THEN: Respuesta = "+result+" "+registerFormDone()+" | "+registerFormPage.isRegisterFormDone());
        Assertions.assertNotEquals(registerFormDone(), registerFormPage.isRegisterFormDone());
        quiteDriver();
    }

}
