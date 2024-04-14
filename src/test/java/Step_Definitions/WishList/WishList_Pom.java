package Step_Definitions.WishList;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishList_Pom {

    public WishList_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "div[class='panel header'] li:nth-child(2)")
    public WebElement signIn;
    @FindBy(css = "[id='email']")
    public WebElement eMail;
    @FindBy(css = "[id='pass']")
    public WebElement password;
    @FindBy(css = "[class='action login primary'][id='send2']")
    public WebElement registerSignIn;
    @FindBy(css = "[class='level-top ui-corner-all'][id='ui-id-3']")
    public WebElement menButton;
    @FindBy(css = "[class='product-image-photo'][alt='Argus All-Weather Tank']")
    public WebElement product;
    @FindBy(css = "[class='action towishlist']")
    public WebElement wishList;
    @FindBy(css = "[data-ui-id='message-success']")
    public WebElement verifyMessage;
    @FindBy(css = "[class='nav item']>a")
    public WebElement myAccount;
    @FindBy(css = "[class='nav item current']")
    public WebElement myWishList;
    @FindBy(css = "[class='btn-remove action delete']")
    public WebElement removeItem;
    @FindBy(css = "[class='page messages']")
    public WebElement removeMessage;

    public WebElement getWebElement(String element) {
        switch (element) {
            case "eMail": return this.eMail;
            case "password": return this.password;
           case "My Account": return this.myAccount;
           case "My Wish List": return this.myWishList;
        }
        return null;

    }
}
