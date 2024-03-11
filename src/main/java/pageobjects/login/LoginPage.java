package pageobjects.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import pageobjects.common.CommonPage;
import utils.WaitUtil;

public class LoginPage extends CommonPage {
    @FindBy(xpath = "//button[text()='Log In']")
    private WebElement btnLogIn;

    @FindBy(xpath = "//p[text()='Email']/parent::div/following-sibling::div/input")
    private WebElement txbEmail;

    @FindBy(xpath = "//p[text()='Password']/parent::div/following-sibling::div/input")
    private WebElement txbPassword;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement btnLogin;

    @FindBy(xpath = "//a[text()='Forgot your password?']")
    private WebElement btnForgetYourPassword;

    @FindBy(xpath = "//img[@alt='logo']")
    private WebElement imageLogo;

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @Step("click button login from dashboard")
    public LoginPage clickButtonLogIn(){
        clickToElement(btnLogIn);
        return this;
    }
    @Step("click button login from login page")
    public LoginPage clickButtonLoginFromLoginPage(){
        clickToElement(btnLogin);
        return this;
    }
    @Step("enter email address")
    public LoginPage enterEmail(String email){
        sendKeyElement(txbEmail, email);
        return this;
    }
    @Step("enter password")
    public LoginPage enterPassWord(String password){
        sendKeyElement(txbPassword, password);
        return this;
    }
    @Step("login")
    public LoginPage login(String email, String password ){
        clickToElement(btnLogIn);
        this.enterEmail(email);
        this.enterPassWord(password);
        this.clickButtonLoginFromLoginPage();
        this.closeToastMessage();
        return this;
    }
}
