package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class automationPracticeTests {
    private WebDriver webDriver;
    private SignIn signIn;
    private AccountPage accountPage;
    private RegistrationPage registrationPage;
    private ConfirmeMessagePage confirmeMessagePage;
    private ContactUs contactUs;
    private CustomerServiceContactUs customerServiceContactUs;
    private SummerDresses summerDresses;
    private ContactLinks contactLinks;
    private HomePage homePage;


    //region Radomir Lukovic-Automation prectice

    //region configure
    @BeforeMethod
    public void configure() {


        System.out.println("Ovo se izvrsva pre pokretanja test metode");
        System.setProperty("webdriver.chrome.driver",
                PropertiesReader.getInstance().getValue("WEBDRIVER.CHROMEDRIVER"));
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        signIn = new SignIn(webDriver);
        accountPage = new AccountPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        confirmeMessagePage = new ConfirmeMessagePage(webDriver);
        contactUs = new ContactUs(webDriver);
        customerServiceContactUs = new CustomerServiceContactUs(webDriver);
        summerDresses = new SummerDresses(webDriver);
        contactLinks = new ContactLinks(webDriver);
        homePage = new HomePage(webDriver);
        webDriver.get("http://automationpractice.com");
        webDriver.manage().window().maximize();

    }
    //endregion

    //region SignIn user with correct email and password
    @Test
    public void successfulSignIn() {


        signIn.clickSignInButton();
        String email = Faker.instance().bothify("????###@gmai.com");
        accountPage.inputEmalInputField(email);
        accountPage.clickSubmitButton();
        registrationPage.InputfirstNameInputField("radomir");
        registrationPage.InputlastNameInputField("lukovic");
        registrationPage.InputemailInputField(email);
        registrationPage.InputpasswordInputField(Faker.instance().bothify("????????"));
        registrationPage.InputFirstNameInputField2("radomir");
        registrationPage.InputLastNameInputField2("lukovic");
        registrationPage.InputCompanyNameInputField("malbex");
        registrationPage.InputAdressInputField(Faker.instance().address().streetAddress());
        registrationPage.InputAdress2InputField(Faker.instance().address().streetAddress());
        registrationPage.InputCityInputField("Beograd");
        registrationPage.selectStateInputField("Alaska");
        registrationPage.InputPosstalCodeInputField(Faker.instance().bothify("#####"));
        registrationPage.selectCountryButton("United States");
        registrationPage.InputOtherInputField("aloha");
        registrationPage.InputHomePhoneInputField(Faker.instance().phoneNumber().cellPhone());
        registrationPage.InputphoneInputField(Faker.instance().phoneNumber().cellPhone());
        registrationPage.SeccondAdressInputField(Faker.instance().address().streetAddress());
        registrationPage.clickOnRegistracionButton();

        Assert.assertTrue(confirmeMessagePage.confirmMessageIsDisplayed());
        Assert.assertEquals(confirmeMessagePage.confirmMessageText(), "radomir lukovic", "ime mora da se poklapa");

    }
    //endregion

    //region SignIn user with existing email
    @Test
    public void signInWithExistingEmail() throws InterruptedException {

        signIn.clickSignInButton();
        accountPage.inputEmalInputField("lakilukovic@yahoo.com");
        accountPage.clickSubmitButton();
        Thread.sleep(10000);
        Assert.assertEquals(accountPage.errorMassageExistingEmail(), "An account using this email address has already been registered. Please enter a valid password or request a new one.", "message shold be seen");
    }
    //endregion

    //region No SignIn user with incorrect email
    @Test
    public void badFormatEmail() {

        signIn.clickSignInButton();
        String email1 = Faker.instance().bothify("????####");
        accountPage.inputEmalInputField(email1);
        accountPage.clickSubmitButton();
        Assert.assertTrue(accountPage.errorMassageIsDisplayed());
        Assert.assertEquals(accountPage.errorMessageText(), "Invalid email address.", "email format mora da bude adekvatan");
    }
    //endregion

    // region No SignIn user with incorrect (empty) email

    @Test
    public void emptyEmailFormat() {

        signIn.clickSignInButton();
        String email2 = Faker.instance().bothify("");
        accountPage.inputEmalInputField(email2);
        accountPage.clickSubmitButton();
        Assert.assertTrue(accountPage.errorMassageIsDisplayed());
        Assert.assertEquals(accountPage.errorMessageText(), "Invalid email address.", "email polje nw smw da bude prazno");

    }
    // endregion

    // region No SignIn user with bad password

    @Test
    public void badPasswordFormat() {


        signIn.clickSignInButton();
        String email = Faker.instance().bothify("????###@gmai.com");
        accountPage.inputEmalInputField(email);
        accountPage.clickSubmitButton();


        registrationPage.InputfirstNameInputField("radomir");
        registrationPage.InputlastNameInputField("lukovic");
        registrationPage.InputemailInputField(email);
        registrationPage.InputpasswordInputField(Faker.instance().bothify("????"));
        registrationPage.InputFirstNameInputField2("radomir");
        registrationPage.InputLastNameInputField2("lukovic");
        registrationPage.InputCompanyNameInputField("malbex");
        registrationPage.InputAdressInputField(Faker.instance().address().streetAddress());
        registrationPage.InputAdress2InputField(Faker.instance().address().streetAddress());
        registrationPage.InputCityInputField("Beograd");
        registrationPage.selectStateInputField("Alaska");
        registrationPage.InputPosstalCodeInputField(Faker.instance().bothify("#####"));
        registrationPage.selectCountryButton("United States");
        registrationPage.InputOtherInputField("aloha");
        registrationPage.InputHomePhoneInputField(Faker.instance().phoneNumber().cellPhone());
        registrationPage.InputphoneInputField(Faker.instance().phoneNumber().cellPhone());
        registrationPage.SeccondAdressInputField(Faker.instance().address().streetAddress());
        registrationPage.clickOnRegistracionButton();
        Assert.assertTrue(registrationPage.errorPasswordMassage());
        Assert.assertEquals(registrationPage.confirmErrorPasswordMessageText(), "There is 1 error\n" +
                "passwd is invalid.", "password mora imati najmanje 5 simbola");
    }
    //endregion

    //region Testing the sending of a message

    @Test
    public void testSendAMessage() {


        signIn.clickContactUsButton();
        contactUs.selectSubjectHeading();
        String email = Faker.instance().bothify("????###@gmai.com");
        contactUs.inputEmailField(email);
        String reference = Faker.instance().bothify("?????????");
        contactUs.inputOrderReference(reference);
        contactUs.setFile("C:\\Users\\Win10\\Desktop\\CV\\RADOMIR LUKOVIC CV.pdf");
        contactUs.setMessage("Ja se zovem Radomir Lukovic");
        contactUs.sendKeyButton();
        Assert.assertTrue(customerServiceContactUs.confirmMessageIsDisplayed());
        Assert.assertEquals(customerServiceContactUs.confirmMessageText(), "Your message has been successfully sent to our team.", "the message shuld be seen");


    }

    //endregion

    //region Testing the dress shopp

    @Test
    public void testDressShop() throws InterruptedException {


        signIn.setHoverDressses();
        signIn.clickOnSummerDresses();
        summerDresses.clickSize();
        summerDresses.clickColor();
       /* summerDresses.clickCompositions();   previse podataka mi koci driver pa sam zakomentarisao visak
        summerDresses.clickStyles();
        summerDresses.clickProperties();
        summerDresses.clickAvailability();
        summerDresses.clickManufacturer();
        summerDresses.clickCondition();*/
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("scroll(0,700);");
        summerDresses.hoverAddCart();
        summerDresses.clickAddToCart();
        Thread.sleep(15000);
        Assert.assertEquals(summerDresses.confirmMessageAddToCart(), "Product successfully added to your shopping cart"
                , "text should be seen");


    }
    //endregion

    //region Testing kick out dress from cart
    @Test
    public void kickOutDressFromCart() throws InterruptedException {


        signIn.setHoverDressses();
        signIn.clickOnSummerDresses();
        summerDresses.clickSize();
        summerDresses.clickColor();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("scroll(0,700);");
        summerDresses.hoverAddCart();
        summerDresses.clickAddToCart();
        Thread.sleep(5000);
        summerDresses.exitWindow();
        JavascriptExecutor javas = (JavascriptExecutor) webDriver;
        javas.executeScript("scroll(0,-700);");
        Thread.sleep(10000);
        summerDresses.hoverToBoxCart();
        summerDresses.clickRemoveProduct();
        Thread.sleep(5000);
        Assert.assertEquals(summerDresses.confirmEmptyCart(), "(empty)", "text should be seen");


    }
    //endregion

    //  region Testing links
    @Test
    public void testLinks() {


        SoftAssert sa = new SoftAssert();
        contactLinks.clickContactUs();
        contactLinks.clickFacebook();
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertFacebookLink(sa);

        webDriver.switchTo().window(tabs.get(0));   // Change focus back to old tab
        contactLinks.clickTwitter(webDriver);
        tabs = new ArrayList<>(webDriver.getWindowHandles());     // Add the window to the list
        webDriver.switchTo().window(tabs.get(2));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertTwitterLink(sa);

        webDriver.switchTo().window(tabs.get(0));
        contactLinks.clickYouTube(webDriver);
        tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(3));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertYouTubeLink(sa);
        webDriver.switchTo().window(tabs.get(0));

        sa.assertAll();

    }

    private void assertFacebookLink(SoftAssert sa) {
        sa.assertEquals(webDriver.getCurrentUrl(), "https://www.facebook.com/groups/525066904174158/");
    }

    private void assertTwitterLink(SoftAssert sa) {
        sa.assertEquals(webDriver.getCurrentUrl(), "https://twitter.com/seleniumfrmwrk");
    }

    private void assertYouTubeLink(SoftAssert sa) {
        sa.assertEquals(webDriver.getCurrentUrl(), "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA");
    }
    //endregion

    //region Testing Home page URL
    @Test
    public void testHomePageUrl() {
        SoftAssert sa = new SoftAssert();

        homePage.hoverWomanDropdown();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage.clickSummerDresses();
        String urlExpected = "http://automationpractice.com/index.php?id_category=11&controller=category";
        String actualUrl_1 = webDriver.getCurrentUrl();
        sa.assertEquals(webDriver.getCurrentUrl(), urlExpected);

        homePage.hoverDressesDropdown();
        homePage.clickSummerDress();
        urlExpected = "http://automationpractice.com/index.php?id_category=11&controller=category";
        String actualUrl_2 = webDriver.getCurrentUrl();
        sa.assertEquals(webDriver.getCurrentUrl(), urlExpected);
        sa.assertTrue(actualUrl_1.equals(actualUrl_2));

        sa.assertAll();
    }

    //endregion

    // region Close Webdriver
    @AfterMethod
    public void closeWebDriver() {

        webDriver.close();
        webDriver.quit();
    }
    //endregion

    //endregion

}




