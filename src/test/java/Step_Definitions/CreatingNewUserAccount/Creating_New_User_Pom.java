package Step_Definitions.CreatingNewUserAccount;

import Pages.ParentPage;
import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creating_New_User_Pom {

    public Creating_New_User_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "div[class='panel header'] li:nth-child(3) a")
    WebElement register;
    @FindBy(css = "input[id='firstname']")
    WebElement firstName;
    @FindBy(css = "input[id='lastname'")
    WebElement lastName;
    @FindBy(css = "input[id='email_address']")
    WebElement eMail;
    @FindBy(css = "input[id='password']")
    WebElement pass;
    @FindBy(css = "input[id='password-confirmation']")
    WebElement passConf;
    @FindBy(css = "button[type='submit'][title='Create an Account']")
    WebElement submit;
    @FindBy(css = "[class='messages'] div")
    WebElement confirmation;

    public WebElement getWebElement(String element) {
        switch (element) {

            case "confirmation":
                return this.confirmation;
            case "submit":
                return this.submit;
            case "pass":
                return this.pass;
            case "eMail":
                return this.eMail;
            case "passConf":
                return this.passConf;
            case "firstName":
                return this.firstName;
            case "lastName":
                return this.lastName;
            case "register":
                return this.register;
        }
        return null;


    }
}
