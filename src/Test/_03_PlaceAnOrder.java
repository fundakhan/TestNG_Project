package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _03_PlaceAnOrder extends BaseDriver {

    LoginPageElements loginPageElements;
    HomePageElements homePageElements;

    MyAccountPageElements myAccountPageElements;

    String expectedResult = "Product successfully added to your shopping cart";

    String expectedOrderReference = "OOIBGADEG";

    @Test
    public void PlaceAnOrder(){

        loginPageElements = new LoginPageElements(driver);
        homePageElements = new HomePageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.signInBtn)).click();

        wait.until(ExpectedConditions.urlContains("my-account"));

        wait.until(ExpectedConditions.visibilityOf(loginPageElements.emailInput)).sendKeys("toffee@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(loginPageElements.passwordInput)).sendKeys("tof1234");
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.submitBtn)).click();

        myAccountPageElements.homeBtn.click();

        wait.until(ExpectedConditions.urlContains("index.php"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

//        actions = new Actions(driver);
//        actions.moveToElement(homePageElements.dress3).click().build();
//        action.perform();
//       //homePageElements.dress3.click();

//        for (int i = 0; i < homePageElements.productList.size(); i++) {
//            wait.until(ExpectedConditions.elementToBeClickable(homePageElements.productList.get(3))).click();
//            break;
//        }

       // homePageElements.firstProduct.click();
       // wait.until(ExpectedConditions.elementToBeClickable(homePageElements.addToCart)).click();

//        actions.moveToElement(homePageElements.firstProduct).build();
//        action.perform();
        homePageElements.firstProduct.click();
        homePageElements.addToCart.click();


        wait.until(ExpectedConditions.visibilityOf(homePageElements.successAddTxt));
        String actualResult = homePageElements.successAddTxt.getText();

        Assert.assertEquals(actualResult,expectedResult);

        homePageElements.checkoutBtn.click();

        homePageElements.myOrderBtn.click();

        Assert.assertEquals(homePageElements.orderReference.getText(),expectedOrderReference);











    }
}
