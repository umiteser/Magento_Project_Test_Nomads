package Step_Definitions.SearchFunctionality;

import Utilities.GWD;
import org.openqa.selenium.support.PageFactory;

public class Search_Pom {

    public Search_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
}
