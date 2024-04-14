package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends ParentPage {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "pass")
    public WebElement password;

    @FindBy(name = "send")
    public WebElement signIn;

    @FindBy(css = "[class='action remind']")
    public WebElement fyp;

    @FindBy(css = "[class='page-title']")
    public WebElement message;

    @FindBy(partialLinkText = "Affirm Water Bottle")
    public WebElement waterBottle;

    @FindBy(id = "product-addtocart-button")
    public WebElement addCart;

    @FindBy(name = "street[0]")
    public WebElement street;

    @FindBy(name = "city")
    public WebElement city;

    @FindBy(name = "postcode")
    public WebElement zip;

    @FindBy(name = "telephone")
    public WebElement phoneNo;

    @FindBy(name = "ko_unique_1")
    public WebElement fixed;

    @FindBy(name = "region_id")
    public WebElement state;

    @FindBy(css = "[id='shipping-method-buttons-container'] button")
    public WebElement next;

    @FindBy(css = "button[class='action primary checkout']")
    public WebElement placeOrder;

    public WebElement getWebElement(String strElement) {
        switch (strElement) {
            case "email":
                return this.email;
            case "password":
                return this.password;
            case "sign in":
                return this.signIn;
            case "forgot your password":
                return this.fyp;
            case "water bottle":
                return this.waterBottle;
            case "add to cart":
                return this.addCart;
            case "street":
                return this.street;
            case "city":
                return this.city;
            case "zip":
                return this.zip;
            case "phoneNo":
                return this.phoneNo;
            case "fixed":
                return this.fixed;
            case "state":
                return this.state;
            case "next":
                return this.next;
            case "place order":
                return this.placeOrder;
        }
        return null;
    }
}