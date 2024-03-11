package tests.create_dashboard_my_work;

import base.BaseTest;
import constants.Constant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.dashboard_mywork.CreateDashboardPage;
import pageobjects.dashboard_mywork.DashboardDetail;
import pageobjects.login.LoginPage;
public class CreateDashboardTest extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void login(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
    }
    @Test(description = "confirm initializing the screen create dashboard")
    public void confirmInitialScreen() throws InterruptedException {
        CreateDashboardPage createDashboardPage = new CreateDashboardPage(getDriver());
        DashboardDetail dashboardDetail = new DashboardDetail(getDriver());
        // check information of pop up create new
        createDashboardPage.clickButtonCreate();
        createDashboardPage.checkInfoDefaultPopupCreateNew();
        createDashboardPage.clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
        // check button cancel
        createDashboardPage.clickButtonCancel()
                .checkPopUpCreateDashboardClosed()
                .clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
        //check button add
        createDashboardPage.createNewDashboard("aah", "tag1")
                .clickButtonAddNewDashboard()
                .checkActionClickButtonAddSuccessfully();
        //delete dashboard just created
        dashboardDetail.clickButtonMenu()
                .selectOptionDelete()
                .clickButtonDeleteConfirm();
        //check button close
        createDashboardPage.clickTabInsights()
                .clickButtonCreate();
        createDashboardPage
                .clickOptionCreateDashboard()
                .clickButtonClose()
                .checkPopUpCreateDashboardClosed()
                .clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
    }
    @Test(description = "Check create dashboard unsuccessfully")
    public void checkCreateDashboardUnsuccessfully(){

        String invalidDashboardName = "151mwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm151";
        String invalidTags = "a, b, c, d";
        CreateDashboardPage createDashboardPage = new CreateDashboardPage(getDriver());
        createDashboardPage.clickButtonCreate();
        createDashboardPage.clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
        // check enter dashboard title invalid greater than 150 characters
        createDashboardPage.createNewDashboard(invalidDashboardName, "tag1")
                .checkActionEnterInvalidDashboardName();
        // check enter dashboard title is space
        createDashboardPage.createNewDashboard("   ", "tag1")
                .checkActionEnterSpaceIntoDashboardTitleField();
        // check enter dashboard title is empty
        createDashboardPage.createNewDashboard("", "tag1")
                .checkActionEnterSpaceIntoDashboardTitleField();
        // check enter tag more than 3 elements
        createDashboardPage.createNewDashboard("aaa", invalidTags)
                .checkActionEnterTagsMoreThan3Elements();
    }
}
