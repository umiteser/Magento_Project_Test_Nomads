package Step_Definitions.TAB_Menu;

import Utilities.GWD;
import org.openqa.selenium.support.PageFactory;

public class Tab_Menu_Pom {

    public Tab_Menu_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
}
