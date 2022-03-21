package co.com.daniela.stepdefinition.loginform;

import co.com.daniela.model.loginform.LoginFormModel;
import co.com.daniela.page.loginform.LoginFormPage;
import co.com.daniela.stepdefinition.setup.WebUI;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LoginFormStepDefinitions extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(LoginFormStepDefinitions.class);
    private LoginFormModel loginFormModel;
    private LoginFormPage loginFormPage;


    private String forLoginSumitForm(){
        return "Accounts Overview";
    }

    @Given("que el usuario desea poder entrar a su cuenta")
    public void que_el_usuario_desea_poder_entrar_a_su_cuenta() {
       try {
           setUpLog4j2();
           setUpWebDriver();
           generalStUp();

           loginFormModel = new LoginFormModel();
           loginFormModel.setLogin("HolaMundo");
           loginFormModel.setPassword("12345678");
            LOGGER.info("SCENARIO: Datos validos");
            LOGGER.info("Given: el usuario desea ingresar a la cuenta"+
            loginFormModel.getLogin()+","+
            loginFormModel.getPassword()+",");

       }catch (Exception e){
           quiteDriver();
           Assertions.fail(e.getMessage(), e);
           LOGGER.error(e.getMessage(),e);
       }
    }
    @When("el usuario ingresa en la pagina el usuario y contrasena correctos")
    public void el_usuario_ingresa_en_la_pagina_el_usuario_y_contrasena_correctos() {

        try {
            loginFormPage = new LoginFormPage(driver,10,true,loginFormModel);
            loginFormPage.fillLoginFormModel();
            LOGGER.info("WHEN:El usuario ingresa correctamente");
        }
        catch (Exception e){

            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.error(e.getMessage(),e);
        }
    }
    @Then("Se muestra informacion de la cuenta")
    public void se_muestra_informacion_de_la_cuenta() {
        String result = Boolean.toString(forLoginSumitForm().equals(loginFormPage.isLoginFormDone()));
        LOGGER.info("THEN: Resultado = "+result+" "+forLoginSumitForm()+" | "+loginFormPage.isLoginFormDone());
        Assertions.assertEquals(forLoginSumitForm(), loginFormPage.isLoginFormDone());
        quiteDriver();
    }

}
