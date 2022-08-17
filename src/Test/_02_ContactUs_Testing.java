package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_ContactUs_Testing extends BaseDriver {

    LoginPageElements loginPageElements;
    HomePageElements homePageElements;

    MyAccountPageElements myAccountPageElements;

    String expectedResult = "Your message has been successfully sent to our team.";

    @Parameters({"message","username","password"})
    @Test(groups = "Regression")
    public void ContactUsTest(String input,String username, String password){

        loginPageElements = new LoginPageElements(driver);
        homePageElements = new HomePageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        wait.until(ExpectedConditions.urlContains("index.php"));

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.signInBtn)).click();

        wait.until(ExpectedConditions.urlContains("my-account"));

        wait.until(ExpectedConditions.visibilityOf(loginPageElements.emailInput)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(loginPageElements.passwordInput)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.submitBtn)).click();

        myAccountPageElements.contactUsBtn.click();

        myAccountPageElements.choose.click();
        Select selectCustomerService = new Select(myAccountPageElements.choose);
        selectCustomerService.selectByIndex(1);

        myAccountPageElements.messageInput.sendKeys(input);

        myAccountPageElements.sendBtn.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(),expectedResult);

    }
}
