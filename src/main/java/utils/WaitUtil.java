package utils;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {
    private static final int TIME_OUT = 1;
    private static WebDriverWait driverWait = new WebDriverWait(BasePage.getDriver(), Duration.ofMinutes(TIME_OUT));

    public static WebElement waitForElementVisible(WebElement element) {
        return driverWait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForElementVisible(String xpath) {
        WebElement element = BasePage.getDriver().findElement(By.xpath(xpath));
        return driverWait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForElementClickable(WebElement element){
        return driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForElementClickable(String xpath){
        return driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
    public static void waitForElementInvisible(WebElement element){
        driverWait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static void waitForElementInvisible(String xpath){
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }
    public static void waitForElementToBeSelected(WebElement element){
        driverWait.until(ExpectedConditions.elementToBeSelected(element));
    }
    public static void waitForElementToBeSelected(String xpath){
        driverWait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
    }
    public static void waitForElementPresence(String xpath){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
    public static void waitForWebPageLoad(){
        JavascriptExecutor js = (JavascriptExecutor) BasePage.getDriver();
        driverWait.until((ExpectedCondition<Boolean>) wd -> js.executeScript("return document.readyState").toString().equals("complete"));
    }
}
