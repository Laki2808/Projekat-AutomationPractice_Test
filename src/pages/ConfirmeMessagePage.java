package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmeMessagePage {

    private WebDriver webDriver;


    @FindBy(className = "account")
    WebElement confirmMessage;


    public ConfirmeMessagePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public boolean confirmMessageIsDisplayed() {
        confirmMessage = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("account")));

        return confirmMessage.isDisplayed();
    }
    public String confirmMessageText() {
        confirmMessage = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("account")));
        return confirmMessage.getText();
    }
}
