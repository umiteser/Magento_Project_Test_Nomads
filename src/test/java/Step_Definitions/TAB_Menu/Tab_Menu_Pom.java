package Step_Definitions.TAB_Menu;

import Pages.ParentPage;
import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class Tab_Menu_Pom extends ParentPage {

    public Tab_Menu_Pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='panel header']/ul/li[2]/a")
    public WebElement singIn;

    public WebElement getWebElementPageHeader(String strElement) {
        switch (strElement) {
            case "singIn":
                return this.singIn;
        }
        return null;
    }

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(name = "login[password]")
    public WebElement password;

    @FindBy(css = "button[class='action login primary']")
    public WebElement singInButton;

    @FindBy(css = "[id='ui-id-2'] li")
    public List<WebElement> tabMenu;

    @FindBy(css = "[id='ui-id-2']>li")
    public List<WebElement> mainCategory;

    @FindBy(css = "[class='item']>a")
    public List<WebElement> sidebar;

    @FindBy(xpath = "//div[@id='narrow-by-list']/div[1]//div[1]")
    public WebElement sidebarCategory;

    @FindBy(xpath = "//div[@id='narrow-by-list']/div[1]//div[2]/ol/li")
    public List<WebElement> sidebarCategoryList;
}