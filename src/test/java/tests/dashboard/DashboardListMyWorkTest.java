package tests.dashboard;

import base.BaseTest;
import constants.Constant;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pageobjects.common.CommonPage;
import pageobjects.dashboard_mywork.DashboardMyWorkPage;
import pageobjects.login.LoginPage;
import utils.PageFactoryManager;

import static constants.Constant.NAME_DASHBOARD_EXIST;
import static constants.Constant.NAME_DASHBOARD_NOT_EXIST;


public class DashboardListMyWorkTest extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void login() throws Exception{
        PageFactoryManager.get(LoginPage.class).login(Constant.EMAIL, Constant.PASSWORD);
    }
    @Test(description = "confirm initializing the screen my dashboard")
    public void confirmInitializingScreen() throws Exception {
        //check information default of dashboard my work
        PageFactoryManager.get(DashboardMyWorkPage.class).clickTabMyWork()
                .verifyDefaultValueOfSelectionDashboard("Dashboard")
                .clickToSelectionDashboard()
                .verifyDropDownListType()
                .clickDisplayTypeDashboard()
                .checkButtonFilterEnable()
                .clickButtonFilter()
                .checkSearchBoxEmpty()
                .clickDropDownListDate()
                .checkValueDefaultDropDownListDate()
                .checkButtonCreateEnable();
        //check button filter
        PageFactoryManager.get(DashboardMyWorkPage.class).checkButtonFilterDisplay()
                .openFilterSection()
                .checkListTagTrendingDisplay()
                .checkDropdownListDateDisplay()
                .checkFilterSectionOpen()
                .closeFilterSection()
                .checkSectionFilterClose();
    }

    @Test(description = "check filter section")
    public void checkFilterSection() throws Exception{
        int numberOfDashboardMyWork = PageFactoryManager.get(DashboardMyWorkPage.class).getNumberDashboard();
        //check text box search default
        PageFactoryManager.get(DashboardMyWorkPage.class).openFilterSection()
                .checkSearchBoxEmpty();
        //check enter empty into search box
        PageFactoryManager.get(DashboardMyWorkPage.class).enterTextBoxSearch("");
        PageFactoryManager.get(DashboardMyWorkPage.class).checkDisplayAllOfDashboard(numberOfDashboardMyWork);
        //dashboard text box search have results
        PageFactoryManager.get(DashboardMyWorkPage.class).enterTextBoxSearch(NAME_DASHBOARD_EXIST);
//        Thread.sleep(3000);
        PageFactoryManager.get(DashboardMyWorkPage.class).checkNameListDashboard(NAME_DASHBOARD_EXIST);
        //dashboard text box search with data not exist
        PageFactoryManager.get(DashboardMyWorkPage.class).enterTextBoxSearch(NAME_DASHBOARD_NOT_EXIST)
                .checkHaveNotData();

        //check space empty into search box
        PageFactoryManager.get(DashboardMyWorkPage.class).enterTextBoxSearch("   ");
        PageFactoryManager.get(DashboardMyWorkPage.class).checkDisplayAllOfDashboard(numberOfDashboardMyWork);
        //check name dashboard have space
        PageFactoryManager.get(DashboardMyWorkPage.class).enterTextBoxSearch("  "+ NAME_DASHBOARD_EXIST);
        PageFactoryManager.get(DashboardMyWorkPage.class).checkNameListDashboard(NAME_DASHBOARD_EXIST);

        //check search tag default
        PageFactoryManager.get(DashboardMyWorkPage.class).checkNumberTagTrending();
        //check search by one tag
        PageFactoryManager.get(DashboardMyWorkPage.class).checkSearchByOneTag();
        //check double click to one tag
        PageFactoryManager.get(DashboardMyWorkPage.class).checkDoubleClickOneTag(numberOfDashboardMyWork);

        //check default value of dropdown list date
        PageFactoryManager.get(DashboardMyWorkPage.class).checkValueDefaultDropDownListDate();
        //check click to dropdown list date
        PageFactoryManager.get(DashboardMyWorkPage.class).clickDropDownListDate()
                .checkDropdownListDateDisplay();

        //check sort by date high to low
        PageFactoryManager.get(DashboardMyWorkPage.class).checkDashboardSortedHighToLow();
        //check sort by date low to high
        PageFactoryManager.get(DashboardMyWorkPage.class).selectDateLowToHigh();
        PageFactoryManager.get(DashboardMyWorkPage.class).checkDashboardSortedLowToHigh();
    }
}
