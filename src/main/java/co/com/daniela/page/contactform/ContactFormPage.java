package co.com.daniela.page.contactform;

import co.com.daniela.model.contactform.ContactFormModel;
import co.com.daniela.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class ContactFormPage extends CommonActionOnPages {
    private static final Logger LOGGER = Logger.getLogger(ContactFormPage.class);
    private ContactFormModel contactFormModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formuario es nulo";

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"footerPanel\"]/ul[1]/li[8]/a")
    private WebElement contact;

    @CacheLookup
    @FindBy(id = "name")
    private WebElement name;

    @CacheLookup
    @FindBy(id = "email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "phone")
    private WebElement phone;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[5]/td[2]/input")
    private WebElement submit;

    @CacheLookup
    @FindBy(id = "message")
    private WebElement message;

    @CacheLookup
    @FindBy(xpath="//*[@id=\'rightPanel\']/p[1]")
    private WebElement returnCustomer;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\'rightPanel\']/p[2]")
    private WebElement returnMessage;


    public ContactFormPage(WebDriver driver, ContactFormModel contactFormModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.contactFormModel = contactFormModel;
    }

    public ContactFormPage(WebDriver driver, int seconds, boolean  explicitTime, ContactFormModel contactFormModel){
        super(driver, seconds, explicitTime);
        pageFactoryInitElement(driver, this);
        this.contactFormModel = contactFormModel;
    }

    public void  fillContactFormModel() throws InterruptedException
    {
        scrollOn(contact);
        clickOn(contact);

        scrollOn(name);
        typeOn(name, contactFormModel.getName());

        scrollOn(email);
        typeOn(email,contactFormModel.getEmail());

        scrollOn(phone);
        typeOn(phone,contactFormModel.getPhone());

        scrollOn(message);
        typeOn(message, contactFormModel.getMessage());

        doSubmit(submit);
    }

    public List<String> isContactFormDone(){
        List<String> submitedContactFormResul = new ArrayList<String>();
        submitedContactFormResul.add (getText(returnCustomer).trim());
        submitedContactFormResul.add(getText(returnMessage).trim());
        return submitedContactFormResul;
    }
    public List<String> isContactFormDonewithExplicitWait(){
        List<String> submitedContactFormResul = new ArrayList<String>();
        submitedContactFormResul.add(withExplicitWaitGetText(returnCustomer).trim());
        submitedContactFormResul.add(withExplicitWaitGetText((WebElement) returnMessage).trim());
        return submitedContactFormResul;
    }


    //Espera explicita
    public void  fillContactFormModelwithExplicitWait() throws InterruptedException
    {
        scrollOn(contact);
        withExplicitWaitClickOn(contact);

        scrollOn(name);
        withExplicitWaitTypeOn(name, contactFormModel.getName());

        scrollOn(email);
        withExplicitWaitTypeOn(email,contactFormModel.getEmail());

        scrollOn(phone);
        withExplicitWaitTypeOn(phone,contactFormModel.getPhone());

        scrollOn(message);
        withExplicitWaitTypeOn(message, contactFormModel.getMessage());

        withExplicitWaitDoSubmit(submit);
    }
}
