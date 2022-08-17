package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseDriver {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(String browser){

        if (browser.equals("chrome")){

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\funda\\OneDrive\\Belgeler\\chromedriver_win32\\chromedriver.exe");

            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.get("http://automationpractice.com/index.php");



        }else if (browser.equals("firefox")){

            System.setProperty("webdriver.gecko.driver", "C:\\Users\\funda\\OneDrive\\Belgeler\\geckodriver-v0.31.0-win64\\geckodriver.exe");

            driver = new FirefoxDriver();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("http://automationpractice.com/index.php");
        }



    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        driver.quit();
    }
}
