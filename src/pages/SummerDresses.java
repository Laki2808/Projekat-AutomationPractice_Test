package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SummerDresses {

    private WebDriver webDriver;
    private final String MODAL_HEADING_XPATH = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/h2[1]";
    private final String MODAL_HADING_TEXT = "Product successfully added to your shopping cart";

    @FindBy(id = "layered_id_attribute_group_1")
    WebElement checkSize;
    @FindBy(id = "layered_id_attribute_group_8")
    WebElement checkColor;
    @FindBy(id = "layered_id_feature_1")
    WebElement checkCompositions;
    @FindBy(id = "layered_id_feature_13")
    WebElement checkStyles;
    @FindBy(id = "layered_id_feature_19")
    WebElement checkProperties;
    @FindBy(id = "layered_quantity_1")
    WebElement checkAvailability;
    @FindBy(id = "layered_manufacturer_1")
    WebElement checkManufacturer;
    @FindBy(id = "layered_condition_new")
    WebElement checkCondition;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]")
    WebElement hoverAddCart;
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement addToCartBtnXpath;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/h2[1]")
    WebElement messageAddToCart;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/span[1]")
    WebElement exitWindow;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")
    WebElement hoverToCart;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/dl[1]/dt[1]/span[1]/a[1]")
    WebElement moveElementFromCart;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]/span[5]")
    WebElement emtyButton;


    public SummerDresses(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void clickSize() {
        checkSize.click();
    }

    public void clickColor() {
        checkColor.click();
    }

    public void clickCompositions() {
        checkCompositions.click();
    }

    public void clickStyles() {
        checkStyles.click();
    }

    public void clickProperties() {
        checkProperties.click();
    }

    public void clickAvailability() {
        checkAvailability.click();

    }

    public void clickManufacturer() {
        checkManufacturer.click();
    }

    public void clickCondition() {
        checkCondition.click();
    }

    public void hoverAddCart() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(hoverAddCart).perform();
    }

    public void clickAddToCart() {
        addToCartBtnXpath.click();
    }

    public String confirmMessageAddToCart() {
        return messageAddToCart.getText();
    }

    public void exitWindow() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        exitWindow.click();
    }

    public void hoverToBoxCart() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Actions actions = new Actions(webDriver);
        actions.moveToElement(hoverToCart).perform();
    }

    public void clickRemoveProduct() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        moveElementFromCart.click();
    }

    public String confirmEmptyCart() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return emtyButton.getText();
    }
}