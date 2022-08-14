package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageElements {

    public HomePageElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Sign in")
    public WebElement signInBtn;

    @FindAll(@FindBy(id = "homefeatured"))
    public List<WebElement> productList;

    @FindBy(xpath = "(//h5[@itemprop='name'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "(//span[text()='Add to cart'])[1]")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2")
    public WebElement successAddTxt;

    @FindBy(linkText = "Proceed to checkout")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//a[text()='My orders']")
    public WebElement myOrderBtn;

    @FindBy(css = "a[class='color-myaccount']")
    public WebElement orderReference;






}
