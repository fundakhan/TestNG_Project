package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

    public LoginPageElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[id='email']")
    public WebElement emailInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(css = "button[id='SubmitLogin']")
    public WebElement submitBtn;

}
