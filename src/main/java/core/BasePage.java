package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtil;

import java.time.Duration;

public class BasePage {
    private static final int TIME_OUT = 20;
    public static WebDriver driver;
    private WebDriverWait wait;
    private Actions builder;
    private JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver driver){
        this.driver = driver;
//        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
        PageFactory.initElements(driver, this);
        builder = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
    public WebDriverWait getExplicitWait(){
        return wait;
    }

    public void clickToElement(WebElement e){
        WaitUtil.waitForElementClickable(e);
        e.click();
    }
    public void pressArrowDown(WebElement element){
        for(int i =0; i<=10; i++){
            element.sendKeys(Keys.ARROW_DOWN);
        }
    }
    public void sendKeyElement(WebElement e, String key){
        WaitUtil.waitForElementVisible(e);
//        this.javascriptExecutor = (JavascriptExecutor) getDriver();
//        javascriptExecutor.executeScript("arguments[0].value='';", e);
        e.sendKeys(Keys.CONTROL, "a");
        e.sendKeys(Keys.DELETE);
        e.sendKeys(key);
    }
    public void clickEnter(WebElement e){
        e.sendKeys(Keys.ENTER);
    }
    public boolean isEnableElement(WebElement e){
        WaitUtil.waitForElementVisible(e);
        return e.isEnabled();
    }
    public boolean isSelectedElement(WebElement e){
        WaitUtil.waitForElementVisible(e);
        return e.isSelected();
    }
    public boolean isDisplayElement(WebElement e){
        return e.isDisplayed();
    }
    public void doubleClick(WebElement e){
        builder.doubleClick(e).perform();
    }
    public void navigateTo(String url){
        getDriver().navigate().to(url);
    }
}
