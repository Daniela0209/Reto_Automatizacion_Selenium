package co.com.daniela.page.registerform;

import co.com.daniela.model.registerform.RegisterFormModel;
import co.com.daniela.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.List;

public class RegisterFormPage extends CommonActionOnPages {

    private static final Logger LOGGER = Logger.getLogger(RegisterFormPage.class);
    private RegisterFormModel registerFormModel;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/p[2]/a")
    private WebElement linkRegister;

    @CacheLookup
    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "customer.address.street")
    private WebElement address;

    @CacheLookup
    @FindBy(id = "customer.address.city")
    private WebElement city;

    @CacheLookup
    @FindBy(id = "customer.address.zipCode")
    private WebElement codeZip;

    @CacheLookup
    @FindBy(id = "customer.phoneNumber")
    private WebElement phone;

    @CacheLookup
    @FindBy(id = "customer.ssn")
    private WebElement snn;

    @CacheLookup
    @FindBy(id = "customer.username")
    private WebElement username;

    @CacheLookup
    @FindBy(id = "customer.password")
    private WebElement password;

    @CacheLookup
    @FindBy(id = "customer.address.state")
    private WebElement state;

    @CacheLookup
    @FindBy(id = "repeatedPassword")
    private WebElement repeatedPassword;

     @CacheLookup
     @FindBy(xpath = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input" )
     private WebElement register;

     @CacheLookup
     @FindBy(xpath = "//*[@id=\"rightPanel\"]/h1")
     private WebElement welcome;

     @CacheLookup
     @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
     private WebElement welcomeMessage;



    public RegisterFormPage(WebDriver driver, RegisterFormModel registerFormModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.registerFormModel = registerFormModel;
    }

    public RegisterFormPage(WebDriver driver, int seconds, boolean explicitTime, RegisterFormModel registerFormModel) {
        super(driver,seconds,explicitTime);
        pageFactoryInitElement(driver, this);
        this.registerFormModel = registerFormModel;
    }

    public void fillRegisterFormModel() throws InterruptedException{

        scrollOn(linkRegister);
        clickOn(linkRegister);

        scrollOn(firstName);
        typeOn(firstName, registerFormModel.getFirstName());

        scrollOn(lastName);
        typeOn(lastName, registerFormModel.getLastName());

        scrollOn(address);
        typeOn(address, registerFormModel.getAddress());

        scrollOn(city);
       typeOn(city, registerFormModel.getCity());

       scrollOn(state);
       typeOn(state, registerFormModel.getState());

       scrollOn(codeZip);
       typeOn(codeZip, registerFormModel.getCodezip());

       scrollOn(phone);
       typeOn(phone, registerFormModel.getPhone());

       scrollOn(snn);
       typeOn(snn, registerFormModel.getSsn());

       scrollOn(username);
       typeOn(username, registerFormModel.getUser());

       scrollOn(password);
       typeOn(password, registerFormModel.getPassword());

       scrollOn(repeatedPassword);
       typeOn(repeatedPassword, registerFormModel.getPassword());

       doSubmit(register);
    }

    public List<String> isRegisterFormDone(){
        List<String> submitregisterResult = new ArrayList<String>();
        submitregisterResult.add(getText(welcome).trim());
         submitregisterResult.add(getText(welcomeMessage).trim());
         return submitregisterResult;
    }
}
