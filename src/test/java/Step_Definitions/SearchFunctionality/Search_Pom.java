package Step_Definitions.SearchFunctionality;

import Pages.ParentPage;
import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class Search_Pom extends ParentPage {

    public Search_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "search")
    public WebElement searchBox;

    @FindBy(css = "button[title='Search']")
    public WebElement searchButton;

    @FindBy(css = "[id='ui-id-2'] li")
    public List<WebElement> tabMenu;

    @FindBy(css = "[class='item product product-item']")
    public List<WebElement> products;

    @FindBy(css = "[class='base']")
    public WebElement productTitle;

    @FindBy(css = "div[itemprop='sku']")
    public WebElement skuNumber;

    @FindBy(css = "[id='ui-id-2']>li")
    public List<WebElement> mainCategory;

    @FindBy(css = "ul[class='items'] li")
    public List<WebElement> categoryLink;
}
