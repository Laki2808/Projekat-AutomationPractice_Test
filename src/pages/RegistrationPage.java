package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {


    private WebDriver webDriver;



    @FindBy(id = "customer_firstname")
    WebElement firstNameInputField;
    @FindBy(id = "customer_lastname")
    WebElement lastNameInputField;
    @FindBy(id = "email")
    WebElement emailInputField;
    @FindBy(id = "passwd")
    WebElement passwordInputField;
    @FindBy(id = "firstname")
    WebElement firstNameInputField2;
    @FindBy(id = "lastname")
    WebElement lastNameInputField2;
    @FindBy(id = "company")
    WebElement companyNameInputField;
    @FindBy(id = "address1")
    WebElement adressInputField;
    @FindBy(id = "address2")
    WebElement adress2InputField;
    @FindBy(id = "city")
    WebElement cityInputField;
    @FindBy(id = "id_state")
    WebElement stateInputField;
    @FindBy(id = "postcode")
    WebElement posstalCodeInputField;
    @FindBy(id = "id_country")
    WebElement selectCountry;
    @FindBy(id = "other")
    WebElement other;
    @FindBy(id = "phone")
    WebElement phoneHomeInputField;
    @FindBy(id = "phone_mobile")
    WebElement phoneInputField;
    @FindBy(id = "alias")
    WebElement secondAdressInputField;
    @FindBy(id = "submitAccount")
    WebElement registracionButton;
    @FindBy(css = ".alert.alert-danger")
    WebElement errorMassage;


    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public void InputfirstNameInputField(String ime){
        firstNameInputField=new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));
        firstNameInputField.clear();
        firstNameInputField.sendKeys(ime);
    }
    public void  InputlastNameInputField(String prezime){
        lastNameInputField.clear();
        lastNameInputField.sendKeys(prezime);
    }
    public void InputemailInputField(String email){
        emailInputField.clear();
        emailInputField.sendKeys(email);


    }
    public void InputpasswordInputField(String password){
        passwordInputField.clear();
        passwordInputField.sendKeys(password);

    }
    public void InputFirstNameInputField2(String ime2) {
        firstNameInputField2.clear();
        firstNameInputField2.sendKeys(ime2);


    }
    public void InputLastNameInputField2(String prezime2) {
        lastNameInputField2.clear();
        lastNameInputField2.sendKeys(prezime2);

    }
    public void InputCompanyNameInputField(String company) {
        companyNameInputField.clear();
        companyNameInputField.sendKeys(company);

    }
    public void InputAdressInputField(String adress) {
        adressInputField.clear();
        adressInputField.sendKeys(adress);

    }
    public void InputAdress2InputField(String adress2) {
        adress2InputField.clear();
        adress2InputField.sendKeys(adress2);}
    public void InputCityInputField(String city) {
        cityInputField.clear();
        cityInputField.sendKeys(city);

    }
    public void selectStateInputField(String state) {
        Select stateDropDown = new Select(stateInputField);
        stateDropDown.selectByVisibleText(state);
    }
    public void InputPosstalCodeInputField(String code) {
        posstalCodeInputField.clear();
        posstalCodeInputField.sendKeys(code);
    }
    public void selectCountryButton(String country) {
        Select coutryDropDown = new Select(selectCountry);
        coutryDropDown.selectByVisibleText(country);
    }
    public void InputOtherInputField(String other) {
        this.other.clear();
        this.other.sendKeys(other);
    }
    public void InputHomePhoneInputField(String homephone) {
        phoneHomeInputField.clear();
        phoneHomeInputField.sendKeys(homephone);
    }
    public void InputphoneInputField(String phone) {
        phoneInputField.clear();
        phoneInputField.sendKeys(phone);
    }
    public void SeccondAdressInputField(String adresss) {
        secondAdressInputField.clear();
        secondAdressInputField.sendKeys(adresss);

    }
    public void clickOnRegistracionButton() {
        registracionButton.click();


    }
    public boolean errorPasswordMassage() {
        errorMassage = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-danger")));

        return errorMassage.isDisplayed();
    }
    public String confirmErrorPasswordMessageText() {
        errorMassage = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-danger")));
        return errorMassage.getText();
    }
}