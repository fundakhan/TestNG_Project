package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountPageElements {

    public MyAccountPageElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[text()='My account']")
    public WebElement myAccountText;

    @FindBy(xpath = "//a[text()='Contact us']")
    public WebElement contactUsBtn;

    @FindBy(css = "select[id='id_contact']")
    public WebElement choose;
    @FindBy(css = "textarea[id='message']")
    public WebElement messageInput;

    @FindBy(id = "submitMessage")
    public WebElement sendBtn;

    @FindBy(css = "p[class='alert alert-success']")
    public WebElement successMessage;

    @FindBy(css = "i[class='icon-chevron-left']")
    public WebElement homeBtn;



}
