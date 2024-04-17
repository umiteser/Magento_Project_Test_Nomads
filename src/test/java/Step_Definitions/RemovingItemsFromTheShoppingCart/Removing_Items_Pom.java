package Step_Definitions.RemovingItemsFromTheShoppingCart;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Removing_Items_Pom {

    public Removing_Items_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "Men")
    public WebElement Men;
    @FindBy(css = "div[index='3']")
    public WebElement size;
    @FindBy(css = "div[aria-label='Red']")
    public WebElement color;
    @FindBy(css = "input[name='qty']")
    public WebElement Qty;
    @FindBy(css = "[class='action showcart']")
    public WebElement cart;
    @FindBy(css = " div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    public WebElement MSG;
    @FindBy(css ="a[title='Remove item']")
    public WebElement Delete;
    @FindBy(css ="a[title='Geo Insulated Jogging Pant']")
    public WebElement GeoInsulatedJoggingPant;
    @FindBy(css ="button[class='action-primary action-accept']")
    public WebElement OK;
    @FindBy(xpath ="//*[@id=\"minicart-content-wrapper\"]/div[2]/strong")
    public WebElement DMSG;

    public WebElement getWebElement(String strElement) {
        switch (strElement) {

            case "Men":
                return this.Men;
            case "size":
                return this.size;
            case "color":
                return this.color;
            case "Qty":
                return this.Qty;
            case "cart":
                return this.cart;
            case "delete":
                return this.Delete;
            case "Geo Insulated Jogging Pant":
                return this.GeoInsulatedJoggingPant;
            case "ok":
                return this.OK;
            case "DMSG":
                return this.DMSG;
        }
        return null;
    }

}
