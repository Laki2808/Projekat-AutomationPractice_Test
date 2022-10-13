package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

    public class AccountPage {

        private WebDriver webDriver;

        @FindBy(id = "email_create")
        WebElement emailInputField;
        @FindBy(id = "SubmitCreate")
        WebElement submitButton;
        @FindBy(xpath= "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/ol[1]/li[1]")
        WebElement errorMassage;
        @FindBy(id = "create_account_error")
        WebElement errorMassageExistingEmail;



        public AccountPage(WebDriver webDriver) {
            this.webDriver = webDriver;
            PageFactory.initElements(this.webDriver, this);
        }
        public void inputEmalInputField(String mail) {
            emailInputField.clear();
            emailInputField.sendKeys(mail);
        }
        public void clickSubmitButton() {
            submitButton = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("SubmitCreate")));
            submitButton.click();
        }
        public boolean errorMassageIsDisplayed() {
            errorMassage = new WebDriverWait(webDriver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/ol[1]/li[1]")));

            return errorMassage.isDisplayed();

        }
        public String errorMessageText() {
            // errorMassage = new WebDriverWait(webDriver, Duration.ofSeconds(10))
            //       .until(ExpectedConditions.presenceOfElementLocated(By.className("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/ol[1]/li[1]")));
            return errorMassage.getText();
        }
        public String errorMassageExistingEmail() {
            return errorMassageExistingEmail.getText();
        }




    }
