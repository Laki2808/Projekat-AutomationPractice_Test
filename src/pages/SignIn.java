package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

    private WebDriver webDriver;

    @FindBy(linkText = "Sign in")
    WebElement signInButton;
    @FindBy(id = "contact-link")
    WebElement contactUsButton;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
    WebElement hoverDressses;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]")
    WebElement setSummerDresses;


    public SignIn(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickContactUsButton() {
        contactUsButton.click();
    }

    public void setHoverDressses() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(hoverDressses).perform();

    }

    public void clickOnSummerDresses() {
        setSummerDresses.click();

    }

}