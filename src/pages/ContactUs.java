package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {

    private WebDriver webDriver;



    @FindBy(xpath = "//option[contains(text(),'Webmaster')]")
    WebElement dropdownElement;
    @FindBy(id = "email")
    WebElement inputEmailField;
    @FindBy(id = "id_order")
    WebElement orderReference;
    @FindBy(id = "fileUpload")
    WebElement attachFile;
    @FindBy(id = "message")
    WebElement inputMessage;
    @FindBy(xpath = "//span[contains(text(),'Send')]")
    WebElement sendKey;


    public ContactUs(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);

    }
    public void selectSubjectHeading() {
        dropdownElement.click();
    }
    public void inputEmailField(String email) {
        inputEmailField.clear();
        inputEmailField.sendKeys(email);
    }
    public void inputOrderReference(String reference) {
        orderReference.clear();
        orderReference.sendKeys(reference);
    }
    public void setFile(String s) {
        attachFile.clear();
        attachFile.sendKeys(s);
    }
    public void setMessage(String message) {
        inputMessage.clear();
        inputMessage.sendKeys(message);
    }
    public void sendKeyButton() {
        sendKey.click();
    }

}