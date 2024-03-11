package pageobjects.account_screen;

import constants.Constant;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.common.CommonPage;
import utils.CommonUtil;

import javax.swing.plaf.TableHeaderUI;

public class AccountScreenPage extends CommonPage {
    @FindBy(xpath = "//div[contains(@class, 'content-header')]//button[contains(@class, 'menu-button')]")
    private WebElement avatar;

    @FindBy(xpath = "//div[contains(@class, 'user-account') and text() ='Account']")
    private  WebElement optionAccount;

    @FindBy(xpath = "//div[contains(@class, 'user-account') and text() ='Plan & billing']")
    private WebElement optionPlanAndBilling;

    @FindBy(xpath = "//div[text()='Basic Details']")
    private WebElement labelBasicDetail;

    @FindBy(xpath = "//div[text()='Email:']/following-sibling::div")
    private WebElement email;

    @FindBy(xpath = "//div[text()='Name:']/following-sibling::div")
    private WebElement name;

    @FindBy(xpath = "//div[text()='Name:']/parent::div/following-sibling::div")
    private WebElement btnEditName;

    @FindBy(xpath = "//div[text()='notifications']")
    private WebElement labelNotification;

    @FindBy(xpath = "//div[contains(text(), 'Receive emails')]/preceding::label/span")
    private WebElement checkboxNotification;

    @FindBy(xpath = "//div[text()='User API Key']")
    private WebElement labelUserApiKey;

    @FindBy(xpath = "//div[text()='Password:']/parent::div/following-sibling::div")
    private WebElement btnEditPassword;

    @FindBy(xpath = "//div[contains(text(), 'Receive emails')]")
    public WebElement labelReceiveEmail;

    @FindBy(xpath = "//input[contains(@class, 'user-api__input')]")
    private WebElement txbApiKey;

    @FindBy(xpath = "//div[contains(@class, 'user-api__action')]/div[contains(@class, 'btn-copy')][1]")
    private WebElement btnReloadApiKey;

    @FindBy(xpath = "//div[contains(@class, 'user-api__action')]/div[contains(@class, 'btn-copy')][2]")
    private WebElement btnCopyApiKey;

    @FindBy(xpath = "//div[contains(@class, 'modal__title')]")
    private WebElement titleOfPopup;

    @FindBy(xpath = "//div[contains(@class, 'modal__btn-close')]")
    private WebElement btnClosePopUp;

    @FindBy(xpath = "//a[text()='Our docs.']")
    private WebElement linkOurDocs;

    public AccountScreenPage(WebDriver driver){
        super(driver);
    }
    @Step("click avatar")
    public AccountScreenPage clickAvatar(){
        clickToElement(avatar);
        return this;
    }
    @Step("click to account option")
    public AccountScreenPage clickAccountOption(){
        clickToElement(optionAccount);
        return this;
    }

    @Step("check information default of account screen")
    public AccountScreenPage checkInfoDefaultAccountScreen(){
        Assert.assertTrue(isDisplayElement(labelBasicDetail));
        Assert.assertTrue(isDisplayElement(email));
        Assert.assertTrue(isDisplayElement(name));
        Assert.assertTrue(isDisplayElement(btnEditName));
        Assert.assertTrue(isDisplayElement(labelNotification));
        Assert.assertTrue(isDisplayElement(checkboxNotification));
        Assert.assertFalse(isSelectedElement(checkboxNotification));
        Assert.assertTrue(isDisplayElement(labelUserApiKey));
        Assert.assertTrue(isDisplayElement(txbApiKey));
        Assert.assertTrue(isEnableElement(btnReloadApiKey));
        Assert.assertTrue(isEnableElement(btnCopyApiKey));
        return this;
    }
    @Step("check information display at field")
    public AccountScreenPage checkInformationDisplayAtField(){
        Assert.assertEquals(email.getText(), Constant.EMAIL);
        Assert.assertEquals(name.getText().toUpperCase(), Constant.USER_NAME.toUpperCase());
        Assert.assertEquals(name.getText().toUpperCase(), Constant.USER_NAME.toUpperCase());
        Assert.assertTrue(CommonUtil.isUUID(txbApiKey.getAttribute("value")));
        return this;
    }
    public AccountScreenPage clickButtonEditName(){
        clickToElement(btnEditName);
        return this;
    }
    @Step("check popup edit basic detail display")
    public AccountScreenPage checkPopUpEditBasicDetailDisplay(){
        Assert.assertEquals(titleOfPopup.getText(), Constant.POPUP_EDIT_BASIC);
        return this;
    }
    @Step("check popup edit password display")
    public AccountScreenPage checkPopUpEditPasswordDisplay(){
        Assert.assertEquals(titleOfPopup.getText(), Constant.POPUP_EDIT_PASS);
        return this;
    }
    @Step("close popup")
    public AccountScreenPage closePopUp(){
        clickToElement(btnClosePopUp);
        return this;
    }
    @Step("click button edit password")
    public AccountScreenPage clickButtonEditPassword(){
        clickToElement(btnEditPassword);
        return this;
    }
    @Step("click to check box notification")
    public AccountScreenPage clickCheckBoxNotification(){
        clickToElement(checkboxNotification);
        return this;
    }
    @Step("click to button copy api key")
    public AccountScreenPage clickButtonCopyApiKey() {
        pressArrowDown(linkOurDocs);
        clickToElement(btnCopyApiKey);
        return this;
    }
    @Step("click to button reload api key")
    public AccountScreenPage clickButtonReloadApiKey(){
        clickToElement(btnReloadApiKey);
        return this;
    }
    @Step("click to button our docs")
    public AccountScreenPage clickOurDocs(){
        clickToElement(linkOurDocs);
        return this;
    }
}
