package co.com.daniela.page.loginform;

import co.com.daniela.model.loginform.LoginFormModel;
import co.com.daniela.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginFormPage extends CommonActionOnPages {

    private static final Logger LOGGER = Logger.getLogger(LoginFormPage.class);
    private LoginFormModel loginFormModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo";


    @CacheLookup
    @FindBy(xpath = "//*[@id=\'loginPanel\']/form/div[1]/input" )
    private WebElement userName;

    @CacheLookup
    @FindBy(xpath ="//*[@id=\'loginPanel\']/form/div[2]/input" )
    private WebElement password;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\'loginPanel\']/form/div[3]/input")
    private WebElement submit;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\'rightPanel\']/div/div/h1")
    private WebElement accounts;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\'rightPanel\']/p")
    private WebElement messageError;


    public LoginFormPage(WebDriver driver, LoginFormModel loginFormModel){
        super(driver);
        pageFactoryInitElement(driver, this);
        this.loginFormModel = loginFormModel;
    }

    public LoginFormPage(WebDriver driver, int seconds, boolean explicitTime, LoginFormModel loginFormModel) {
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
        this.loginFormModel = loginFormModel;
    }

    public void fillLoginFormModel() throws InterruptedException{
        scrollOn(userName);
        typeOn(userName, loginFormModel.getLogin());

        scrollOn(password);
        typeOn(password, loginFormModel.getPassword());

        doSubmit(submit);
    }
    public String isLoginFormDone(){
     return getText(accounts).trim();

    }
    public String isLoginFormDoneWithExplicitWait(){
        return withExplicitWaitGetText(accounts).trim();
    }

    public String isLoginFalsePasswordDone(){
        return getText(messageError).trim();
    }

    public String isLoginFalsePasswordwithExplicitWait(){
        return withExplicitWaitGetText(messageError).trim();
    }

    //Espera explicita
    public void fillLoginFormModelwithExplicitWait() throws InterruptedException{
        scrollOn(userName);
        withExplicitWaitTypeOn(userName, loginFormModel.getLogin());

        scrollOn(password);
        withExplicitWaitTypeOn(password, loginFormModel.getPassword());

        withExplicitWaitDoSubmit(submit);
    }
}
