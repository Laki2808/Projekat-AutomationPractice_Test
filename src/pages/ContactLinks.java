package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ContactLinks {

    WebDriver webDriver;

    public ContactLinks(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }


    @FindBy(xpath = "//div[@id='contact-link']//a[contains(text(),'Contact us')]")
    WebElement contactUsXpath;
    @FindBy(xpath = "//li[@class='facebook']")
    WebElement facebookXpath;
    @FindBy(xpath = "//li[@class='twitter']")
    WebElement twitterXpath ;
    @FindBy(xpath = "//li[@class='youtube']")
    WebElement youTubeXpath;





    public void clickContactUs() {
        contactUsXpath.click();
    }
    public void clickFacebook() {
        facebookXpath.click();
    }
    public  void clickTwitter(WebDriver wd) {
        twitterXpath.click();
    }
    public  void clickYouTube(WebDriver wd) {
        youTubeXpath.click();
    }

}
