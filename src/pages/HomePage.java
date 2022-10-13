package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }


    @FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
    WebElement womanDropdown;
    @FindBy(xpath = "//li[@class='sfHover']//ul//li//a[contains(text(),'Summer Dresses')]")
    WebElement summerDresses;
    @FindBy(xpath = "//body[@id='category']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")
    WebElement dressesDropdown;
    @FindBy(xpath = "//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]")
    WebElement summerDressesDresses;


    public  void hoverWomanDropdown() {
        Actions action=new Actions(webDriver);
        action.moveToElement(womanDropdown).perform();
    }

    public void clickSummerDresses() {
        summerDresses.click();
    }

    public  void hoverDressesDropdown() {
        Actions action=new Actions(webDriver);
        action.moveToElement(dressesDropdown).perform();
    }

    public  void clickSummerDress() {
        summerDressesDresses.click();
    }




}
