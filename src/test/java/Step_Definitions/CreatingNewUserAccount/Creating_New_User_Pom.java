package Step_Definitions.CreatingNewUserAccount;

import Utilities.GWD;
import org.openqa.selenium.support.PageFactory;

public class Creating_New_User_Pom {

    public Creating_New_User_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
}
