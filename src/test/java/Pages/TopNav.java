package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class TopNav extends ParentPage {
    public TopNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(partialLinkText = "Sign In")
    public WebElement signIn;

    @FindBy(css = "[class='action switch']")
    public WebElement welcomeDD;

    @FindBy(partialLinkText = "Sign Out")
    public WebElement signOut;

    @FindBy(linkText = "Gear")
    public WebElement gear;

    @FindBy(css = "[class='action showcart']")
    public WebElement cart;

    @FindBy(css = "[id='mini-cart'] strong[class='product-item-name']>a")
    public List<WebElement> cartItems;

    @FindBy(id = "top-cart-btn-checkout")
    public WebElement proceed;

    @FindBy(css = "[class='counter-number']")
    public WebElement counter;

    public WebElement getWebElement(String strElement) {
        switch (strElement) {
            case "sign in":
                return this.signIn;
            case "welcome":
                return this.welcomeDD;
            case "sign out":
                return this.signOut;
            case "gear":
                return this.gear;
            case "cart":
                return this.cart;
            case "proceed":
                return this.proceed;
        }
        return null;
    }
}