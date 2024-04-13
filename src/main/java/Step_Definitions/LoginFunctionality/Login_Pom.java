package Step_Definitions.LoginFunctionality;

import Utilities.GWD;
import org.openqa.selenium.support.PageFactory;

public class Login_Pom {

    public Login_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
}
