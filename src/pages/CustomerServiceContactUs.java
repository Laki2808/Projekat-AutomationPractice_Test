package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerServiceContactUs {


    WebDriver webDriver;


    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement messageSucess;


    public CustomerServiceContactUs(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public boolean confirmMessageIsDisplayed() {
        messageSucess = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='alert alert-success']")));

        return messageSucess.isDisplayed();
    }
    public String confirmMessageText() {
        // messageSucess = new WebDriverWait(webDriver, Duration.ofSeconds(5))
        //   .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='alert alert-success']")));
        return messageSucess.getText();
    }
}
