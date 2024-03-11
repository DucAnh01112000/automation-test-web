package tests.account_screen;

import base.BaseTest;
import constants.Constant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.account_screen.AccountScreenPage;
import pageobjects.login.LoginPage;
import utils.PageFactoryManager;

public class CheckInformationAccountScreenTest extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void login() throws Exception{
        PageFactoryManager.get(LoginPage.class).login(Constant.EMAIL, Constant.PASSWORD);
    }

    @Test(description = "check information initialization of screen")
    public void checkInformationInitial() throws Exception{
        PageFactoryManager.get(AccountScreenPage.class).clickAvatar()
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
        PageFactoryManager.get(AccountScreenPage.class).clickCheckBoxNotification()
                .closeToastMessage();
        //check when user click to copy api key
        PageFactoryManager.get(AccountScreenPage.class).clickButtonCopyApiKey()
                .verifyToastMessageCopiedDisplay();
        PageFactoryManager.get(AccountScreenPage.class).clickOurDocs();

    }
}
