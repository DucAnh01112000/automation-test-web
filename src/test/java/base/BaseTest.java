package base;

import constants.Url;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest{
    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/baymax/Documents/Project_Owner/automation-test-web/chromedriver_mac64.zip ");
        driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get(Url.BASE_URL);

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(driver!=null){ driver.quit();}
    }
}
