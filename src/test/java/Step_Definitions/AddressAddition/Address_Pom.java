package Step_Definitions.AddressAddition;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address_Pom {

    public Address_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "div[class='panel header'] li:nth-child(2)")
    WebElement signIn;
    @FindBy(css = "[id='email']")
    WebElement eMail;
    @FindBy(css = "[id='pass']")
    WebElement pass;
    @FindBy(css = "[class='action login primary'][id='send2']")
    WebElement submit;
    @FindBy(css = "button[type='button'][class='action switch']")
    WebElement drop;
    @FindBy(css = "ul[class='header links'] div li a")
    WebElement myAcc;
    @FindBy(css = "div[class='block block-dashboard-addresses'] [class='block-title'] a")
    WebElement manageAddress;
    @FindBy(css = "button[type='button'][title='Add New Address']")
    WebElement addAddress;
    @FindBy(id = "company")
    WebElement company;
    @FindBy(id = "telephone")
    WebElement phone;
    @FindBy(id = "street_1")
    WebElement street1;
    @FindBy(id = "street_2")
    WebElement street2;
    @FindBy(id = "street_3")
    WebElement street3;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "region_id")
    WebElement regionID;
    @FindBy(css = "button[type='submit'][title='Save Address']")
    WebElement saveAddress;
    @FindBy(css = "[class='messages'] div")
    WebElement confirmation;
    @FindBy(id = "zip")
    WebElement zip;
    @FindBy(id = "country")
    WebElement id;

    public WebElement getWebElement(String element) {
        switch (element) {
            case "zip":
                return this.zip;
            case "confirmation":
                return this.confirmation;
            case "saveAddress":
                return this.saveAddress;
            case "regionID":
                return this.regionID;
            case "city":
                return this.city;
            case "street1":
                return this.street1;
            case "street2":
                return this.street2;
            case "street3":
                return this.street3;
            case "phone":
                return this.phone;
            case "company":
                return this.company;
            case "manageAddress":
                return this.manageAddress;
            case "myAcc":
                return this.myAcc;
            case "drop":
                return this.drop;
            case "submit":
                return this.submit;
            case "pass":
                return this.pass;
            case "signIn":
                return this.signIn;
            case "eMail":
                return this.eMail;
            case "addAddress":
                return this.addAddress;
        }
        return null;


    }
}
