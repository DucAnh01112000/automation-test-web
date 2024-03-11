package pageobjects.dashboard_mywork;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.common.CommonPage;
import utils.WaitUtil;

public class CreateDashboardPage extends CommonPage {
    @FindBy(xpath = "//div[normalize-space()='Create New']")
    private WebElement titlePopupCreateNew;

    @FindBy(xpath = "//div[contains(@class, 'content-create-modal')]/p[text()='Dashboard']")
    private WebElement optionCreateDashboard;

    @FindBy(xpath = "//div[contains(@class, 'content-create-modal')]/p[text()='Query']")
    private WebElement optionCreateQuery;

    @FindBy(xpath = "//div[normalize-space()='Create Dashboard']")
    private WebElement titlePopupCreateDashboard;

    @FindBy(xpath = "//input[@placeholder='My dashboard']")
    private WebElement inputDashboardTitle;

    @FindBy(xpath = "//input[@placeholder='tag1, tag2, tag3']")
    private WebElement inputTagsDashboard;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement btnCancel;

    @FindBy(xpath = "//button[text()='Add']")
    private WebElement btnAdd;

    @FindBy(xpath = "//div[normalize-space()='Create Dashboard']/ancestor::section/div[contains(@class, 'modal__btn-close')]")
    private WebElement btnClosePopUpCreateDashboard;

    @FindBy(xpath = "//div[normalize-space()='Create New']/ancestor::section/div[contains(@class, 'modal__btn-close')]")
    private WebElement btnClosePopUpCreateNew;

    @FindBy(xpath = "//ul//div[text()='Create new dashboard successfully!']")
    private WebElement toastMessageCreateNewDashboardSuccessfully;

    @FindBy(xpath = "//p[text()='The dashboard title may not be greater than 150 characters.']")
    private WebElement messageDashboardNameGreaterThan150;

    @FindBy(xpath = "//p[text()='The dashboard title field is required.']")
    private WebElement messageDashboardNameFieldRequired;

    @FindBy(xpath = "//p[text()='Tags must contain not more than 3 elements']")
    private WebElement messageTagsContainMoreThan3Elements;

    @FindBy(xpath = "//a[text()='Insights']")
    private WebElement tabInsights;
    public CreateDashboardPage(WebDriver driver){
        super(driver);
    }
    @Step("check information default of pop up create new")
    public void checkInfoDefaultPopupCreateNew(){
        Assert.assertTrue(isEnableElement(btnClosePopUpCreateNew));
        Assert.assertTrue(isDisplayElement(titlePopupCreateNew));
        Assert.assertTrue(isEnableElement(optionCreateDashboard));
        Assert.assertTrue(isEnableElement(optionCreateQuery));
    }
    @Step("click option create dashboard")
    public CreateDashboardPage clickOptionCreateDashboard(){
        clickToElement(optionCreateDashboard);
        return this;
    }
    @Step("check information of pop up create dashboad")
    public void checkInfoPopUpCreateDashboard(){
        Assert.assertTrue(isEnableElement(btnClosePopUpCreateDashboard));
        Assert.assertTrue(isDisplayElement(titlePopupCreateDashboard));
        Assert.assertEquals(inputDashboardTitle.getText(), "");
        Assert.assertEquals(inputDashboardTitle.getAttribute("placeholder"), "My dashboard");
        Assert.assertEquals(inputTagsDashboard.getText(), "");
        Assert.assertEquals(inputTagsDashboard.getAttribute("placeholder"), "tag1, tag2, tag3");
        Assert.assertTrue(isEnableElement(btnCancel));
        Assert.assertFalse(isEnableElement(btnAdd));
    }
    @Step("click button cancel on pop up create dashboard")
    public CreateDashboardPage clickButtonCancel(){
        clickToElement(btnCancel);
        return this;
    }
    @Step("check pop up create dashboard already closed")
    public CreateDashboardPage checkPopUpCreateDashboardClosed(){
        WaitUtil.waitForElementInvisible(titlePopupCreateDashboard);
        return this;
    }
    @Step("create new dashboard")
    public CreateDashboardPage createNewDashboard(String dashboardName, String tagName){
        sendKeyElement(inputDashboardTitle, dashboardName);
        sendKeyElement(inputTagsDashboard, tagName);
        return this;
    }
    @Step("click button add new dashboard")
    public CreateDashboardPage clickButtonAddNewDashboard(){
        WaitUtil.waitForElementClickable(btnAdd);
        clickToElement(btnAdd);
        return this;
    }
    @Step("check action click button add successfully")
    public void checkActionClickButtonAddSuccessfully(){
        WaitUtil.waitForElementInvisible(titlePopupCreateDashboard);
        closeToastMessage();
        WaitUtil.waitForElementVisible(toastMessageCreateNewDashboardSuccessfully);
    }
    @Step("click button close")
    public CreateDashboardPage clickButtonClose(){
        clickToElement(btnClosePopUpCreateDashboard);
        return this;
    }
    @Step("click tab insights")
    public CreateDashboardPage clickTabInsights(){
        clickToElement(tabInsights);
        return this;
    }
    @Step("check action enter invalid dashboard name")
    public void checkActionEnterInvalidDashboardName(){
        WaitUtil.waitForElementVisible(messageDashboardNameGreaterThan150);
        Assert.assertFalse(isEnableElement(btnAdd));
    }
    @Step("check action enter dashboard title is space")
    public void checkActionEnterSpaceIntoDashboardTitleField(){
        WaitUtil.waitForElementVisible(messageDashboardNameFieldRequired);
        Assert.assertFalse(isEnableElement(btnAdd));
    }
    @Step("check action enter invalid tags more than 3 elements")
    public void checkActionEnterTagsMoreThan3Elements(){
        WaitUtil.waitForElementVisible(messageTagsContainMoreThan3Elements);
        Assert.assertFalse(isEnableElement(btnAdd));
    }
}
