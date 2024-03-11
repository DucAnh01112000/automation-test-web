package tests.account_screen;

import base.BaseTest;
import constants.Constant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.account_screen.AccountScreenPage;
import pageobjects.login.LoginPage;

public class CheckInformationAccountScreenTest extends BaseTest {
    @BeforeMethod(alwaysRun = true)
        public void login(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
    }

    @Test(description = "check information initialization of screen")
    public void checkInformationInitial(){

        AccountScreenPage accountScreenPage = new AccountScreenPage(getDriver());
        accountScreenPage.clickAvatar()
                .clickAccountOption()
                .checkInfoDefaultAccountScreen()
                .checkInformationDisplayAtField()
                .clickButtonEditName()
                .checkPopUpEditBasicDetailDisplay()
                .closePopUp()
                .clickButtonEditPassword()
                .checkPopUpEditPasswordDisplay()
                .closePopUp();
        //check when user click to check box notification
        accountScreenPage.clickCheckBoxNotification()
                .closeToastMessage();
        //check when user click to copy api key
        accountScreenPage.clickButtonCopyApiKey()
                .verifyToastMessageCopiedDisplay();
        accountScreenPage.clickOurDocs();

    }
}
