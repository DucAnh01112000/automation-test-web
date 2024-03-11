package pageobjects.dashboard_mywork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import pageobjects.common.CommonPage;

import java.nio.file.WatchEvent;

public class DashboardDetail extends CommonPage {
    @FindBy(xpath = "//button[contains(@class, 'app-query-menu')]")
    private WebElement btnMenu;

    @FindBy(xpath = "//button//div[text() ='Delete']")
    private WebElement optionDelete;

    @FindBy(xpath = "//div[@class= 'modal-delete__title']")
    private WebElement titlePopUpDeleteDashboard;

    @FindBy(xpath = "//button[text()='Delete']")
    private WebElement btnDeleteConfirm;

    public DashboardDetail(WebDriver driver){
        super(driver);
    }

    public DashboardDetail clickButtonMenu(){
        clickToElement(btnMenu);
        return this;
    }

    public DashboardDetail selectOptionDelete(){
        clickToElement(optionDelete);
        return this;
    }
    public DashboardDetail clickButtonDeleteConfirm(){
        clickToElement(btnDeleteConfirm);
        closeToastMessage();
        return this;
    }
}
