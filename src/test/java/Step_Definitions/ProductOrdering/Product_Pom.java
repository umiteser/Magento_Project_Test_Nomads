package Step_Definitions.ProductOrdering;

import Utilities.GWD;
import org.openqa.selenium.support.PageFactory;

public class Product_Pom {

    public Product_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
}
