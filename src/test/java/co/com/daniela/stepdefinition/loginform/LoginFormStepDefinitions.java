package co.com.daniela.stepdefinition.loginform;

import co.com.daniela.model.loginform.LoginFormModel;
import co.com.daniela.page.loginform.LoginFormPage;
import co.com.daniela.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LoginFormStepDefinitions extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(LoginFormStepDefinitions.class);
    private LoginFormModel loginFormModel;
    private LoginFormPage loginFormPage;
    private Boolean withExplicitWait = true;


    private String forLoginSumitForm(){
        return "Accounts Overview";
    }
    private String forLoginFailPasswordForm(){
        return "The username and password could not be verified.";
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
            if (withExplicitWait){
                loginFormPage = new LoginFormPage(driver,5,withExplicitWait,loginFormModel);
                loginFormPage.fillLoginFormModelwithExplicitWait();
            }else{
                loginFormPage = new LoginFormPage(driver,10,true,loginFormModel);
                loginFormPage.fillLoginFormModel();
            }

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
        String result;
        if (withExplicitWait){
            result= Boolean.toString(forLoginSumitForm().equals(loginFormPage.isLoginFormDoneWithExplicitWait()));
            LOGGER.info("THEN: Resultado = "+result+" "+forLoginSumitForm()+" | "+loginFormPage.isLoginFormDoneWithExplicitWait());
            Assertions.assertEquals(forLoginSumitForm(), loginFormPage.isLoginFormDoneWithExplicitWait());
        }else {
            result= Boolean.toString(forLoginSumitForm().equals(loginFormPage.isLoginFormDone()));
            LOGGER.info("THEN: Resultado = "+result+" "+forLoginSumitForm()+" | "+loginFormPage.isLoginFormDone());
            Assertions.assertEquals(forLoginSumitForm(), loginFormPage.isLoginFormDone());
        }
        quiteDriver();
    }

    @Given("que el usuario desea poder ingresar a su cuenta")
    public void que_el_usuario_desea_poder_ingresar_a_su_cuenta() {

        try {
            setUpLog4j2();
            setUpWebDriver();
            generalStUp();

            loginFormModel = new LoginFormModel();
            loginFormModel.setLogin("HolaMundo");
            loginFormModel.setPassword("1234");
            LOGGER.info("SCENARIO: Datos invalidos");
            LOGGER.info("Given: el usuario es invalido"+
                    loginFormModel.getLogin()+",");

        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
        }
    }
    @When("el usuario ingresa en la pagina el usuario invalido y contrasena correcta")
    public void el_usuario_ingresa_en_la_pagina_el_usuario_invalido_y_contrasena_correcta() {

        try {
            if (withExplicitWait){
                loginFormPage = new LoginFormPage(driver,5,withExplicitWait,loginFormModel);
                loginFormPage.fillLoginFormModelwithExplicitWait();
            }else {
                loginFormPage = new LoginFormPage(driver,loginFormModel);
                loginFormPage.fillLoginFormModel();
            }

            LOGGER.info("WHEN:Se obtiene el usuario invalido");
        }
        catch (Exception e){

            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.error(e.getMessage(),e);
        }
    }
    @Then("Se muestra un mensaje de error en los datos ingresados")
    public void se_muestra_un_mensaje_de_error_en_los_datos_ingresados() {

        String result;
        if (withExplicitWait){
            result= Boolean.toString(forLoginFailPasswordForm().equals(loginFormPage.isLoginFalsePasswordwithExplicitWait()));
            LOGGER.info("THEN: Resultado = "+result+" "+forLoginFailPasswordForm()+" | "+loginFormPage.isLoginFalsePasswordwithExplicitWait());
            Assertions.assertEquals(forLoginFailPasswordForm(), loginFormPage.isLoginFalsePasswordwithExplicitWait());
        }else {
            result= Boolean.toString(forLoginFailPasswordForm().equals(loginFormPage.isLoginFalsePasswordDone()));
            LOGGER.info("THEN: Resultado = "+result+" "+forLoginFailPasswordForm()+" | "+loginFormPage.isLoginFalsePasswordDone());
            Assertions.assertEquals(forLoginFailPasswordForm(), loginFormPage.isLoginFalsePasswordDone());
        }

        quiteDriver();

    }


}
