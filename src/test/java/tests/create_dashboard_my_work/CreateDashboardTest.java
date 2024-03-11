package tests.create_dashboard_my_work;

import base.BaseTest;
import constants.Constant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.dashboard_mywork.CreateDashboardPage;
import pageobjects.dashboard_mywork.DashboardDetail;
import pageobjects.login.LoginPage;
import utils.PageFactoryManager;

public class CreateDashboardTest extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void login() throws Exception{
        PageFactoryManager.get(LoginPage.class).login(Constant.EMAIL, Constant.PASSWORD);
    }
    @Test(description = "confirm initializing the screen create dashboard")
    public void confirmInitialScreen() throws Exception {
        // check information of pop up create new
        PageFactoryManager.get(CreateDashboardPage.class).clickButtonCreate();
        PageFactoryManager.get(CreateDashboardPage.class).checkInfoDefaultPopupCreateNew();
        PageFactoryManager.get(CreateDashboardPage.class).clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
        // check button cancel
        PageFactoryManager.get(CreateDashboardPage.class).clickButtonCancel()
                .checkPopUpCreateDashboardClosed()
                .clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
        //check button add
        PageFactoryManager.get(CreateDashboardPage.class).createNewDashboard("aah", "tag1")
                .clickButtonAddNewDashboard()
                .checkActionClickButtonAddSuccessfully();
        //delete dashboard just created
        PageFactoryManager.get(DashboardDetail.class).clickButtonMenu()
                .selectOptionDelete()
                .clickButtonDeleteConfirm();
        //check button close
        PageFactoryManager.get(CreateDashboardPage.class).clickTabInsights()
                .clickButtonCreate();
        PageFactoryManager.get(CreateDashboardPage.class)
                .clickOptionCreateDashboard()
                .clickButtonClose()
                .checkPopUpCreateDashboardClosed()
                .clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
    }
    @Test(description = "Check create dashboard unsuccessfully")
    public void checkCreateDashboardUnsuccessfully() throws Exception{
        String invalidDashboardName = "151mwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm151";
        String invalidTags = "a, b, c, d";

        PageFactoryManager.get(CreateDashboardPage.class).clickButtonCreate();
        PageFactoryManager.get(CreateDashboardPage.class).clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
        // check enter dashboard title invalid greater than 150 characters
        PageFactoryManager.get(CreateDashboardPage.class).createNewDashboard(invalidDashboardName, "tag1")
                .checkActionEnterInvalidDashboardName();
        // check enter dashboard title is space
        PageFactoryManager.get(CreateDashboardPage.class).createNewDashboard("   ", "tag1")
                .checkActionEnterSpaceIntoDashboardTitleField();
        // check enter dashboard title is empty
        PageFactoryManager.get(CreateDashboardPage.class).createNewDashboard("", "tag1")
                .checkActionEnterSpaceIntoDashboardTitleField();
        // check enter tag more than 3 elements
        PageFactoryManager.get(CreateDashboardPage.class).createNewDashboard("aaa", invalidTags)
                .checkActionEnterTagsMoreThan3Elements();
    }
}
