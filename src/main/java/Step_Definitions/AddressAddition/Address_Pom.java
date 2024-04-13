package Step_Definitions.AddressAddition;

import Utilities.GWD;
import org.openqa.selenium.support.PageFactory;

public class Address_Pom {

    public Address_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
}
