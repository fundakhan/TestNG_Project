package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_LoginTest extends BaseDriver {

    LoginPageElements loginPageElements;
    HomePageElements homePageElements;

    MyAccountPageElements myAccountPageElements;

    String expectedResult = "MY ACCOUNT";


    @Test
    public void LoginTest(){

     loginPageElements = new LoginPageElements(driver);
     homePageElements = new HomePageElements(driver);
     myAccountPageElements = new MyAccountPageElements(driver);

     wait.until(ExpectedConditions.elementToBeClickable(homePageElements.signInBtn)).click();

     wait.until(ExpectedConditions.visibilityOf(loginPageElements.emailInput)).sendKeys("toffee@gmail.com");
     wait.until(ExpectedConditions.visibilityOf(loginPageElements.passwordInput)).sendKeys("tof1234");
     wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.submitBtn)).click();

        Assert.assertTrue(myAccountPageElements.myAccountText.isDisplayed());
        Assert.assertEquals(myAccountPageElements.myAccountText.getText(),expectedResult);

   }
}
