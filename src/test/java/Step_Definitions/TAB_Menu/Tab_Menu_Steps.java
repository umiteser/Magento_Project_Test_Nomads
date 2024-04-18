package Step_Definitions.TAB_Menu;

import Pages.DialogContent;
import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Tab_Menu_Steps extends ParentPage {

    Tab_Menu_Pom tmp = new Tab_Menu_Pom();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    @Given("Navigate to the Magento website")
    public void navigateToTheMagentoWebsite() {
        GWD.getDriver().get("https://magento.softwaretestingboard.com/");
    }

    @When("Click on the element in panel header")
    public void clickOnTheElementInPanelHeader(DataTable dt) {
        List<String> strDtList = dt.asList(String.class);
        for (String s : strDtList) {
            WebElement dtWebElement = tmp.getWebElementPageHeader(s);
            tmp.myClick(dtWebElement);
        }
    }

    @Then("Enter email as {string} password as {string} click sing in button")
    public void enterEmailAsPasswordAsClickSingInButton(String email,String password) {
        tmp.mySendKeys(tmp.email, email);
        tmp.mySendKeys(tmp.password, password);
        tmp.myClick(tmp.singInButton);

    }

    @And("The main categories of the TAB menu should be displayed")
    public void theMainCategoriesOfTheTABMenuShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(tmp.mainCategory));
        tmp.verifyContainsText(tmp.mainCategory.get(0), "What's New");
        tmp.verifyContainsText(tmp.mainCategory.get(1), "Women");
        tmp.verifyContainsText(tmp.mainCategory.get(2), "Men");
        tmp.verifyContainsText(tmp.mainCategory.get(3), "Gear");
        tmp.verifyContainsText(tmp.mainCategory.get(4), "Training");
        tmp.verifyContainsText(tmp.mainCategory.get(5), "Sale");
    }

    @Then("Check the TAB menu")
    public void checkTheTABMenu() {

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='ui-id-2'] li")));
        String[] categories = {"Tops", "Bottoms", "Jackets", "Hoodies & Sweatshirts", "Tees", "Bras & Tanks", "Pants", "Shorts",
                "Tops", "Bottoms", "Jackets", "Hoodies & Sweatshirts", "Tees", "Tanks", "Pants", "Shorts",
                "Bags", "Fitness Equipment", "Watches",
                "Video Download"};

        for (int i = 1; i < tmp.tabMenu.size(); i++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='ui-id-2'] li")));
            tabMenuDisplay(i);
            tmp.myClickNoScroll(tmp.tabMenu.get(i));

            switch (i) {
                case 1:
                    assertSubcategoriesVisible(tmp.sidebar, categories, 0, 2);
                    break;
                case 2:
                    tmp.myClick(tmp.sidebarCategory);
                    assertSubcategoriesVisible(tmp.sidebarCategoryList, categories, 2, 6);
                    break;
                case 7:
                    tmp.myClick(tmp.sidebarCategory);
                    assertSubcategoriesVisible(tmp.sidebarCategoryList, categories, 6, 8);
                    break;
                case 10:
                    assertSubcategoriesVisible(tmp.sidebar, categories, 8, 10);
                    break;
                case 11:
                    tmp.myClick(tmp.sidebarCategory);
                    assertSubcategoriesVisible(tmp.sidebarCategoryList, categories, 10, 14);
                    break;
                case 16:
                    tmp.myClick(tmp.sidebarCategory);
                    assertSubcategoriesVisible(tmp.sidebarCategoryList, categories, 14, 16);
                    break;
                case 19:
                    assertSubcategoriesVisible(tmp.sidebar, categories, 16, 19);
                    break;
                case 23:
                    assertSubcategoriesVisible(tmp.sidebar, categories, 19, 20);
                    break;
            }
        }
    }

    private void tabMenuDisplay(int i) {
        if (i > 1 && i < 10) {
            tmp.hoverFunction(tmp.tabMenu.get(1));
            if (i > 2 && i < 7) {
                tmp.hoverFunction(tmp.tabMenu.get(2));
            } else if (i > 7) {
                tmp.hoverFunction(tmp.tabMenu.get(7));
            }
        } else if (i > 10 && i < 19) {
            tmp.hoverFunction(tmp.tabMenu.get(10));
            if (i > 11 && i < 16) {
                tmp.hoverFunction(tmp.tabMenu.get(11));
            } else if (i > 16) {
                tmp.hoverFunction(tmp.tabMenu.get(16));
            }
        } else if (i > 19 && i < 23) {
            tmp.hoverFunction(tmp.tabMenu.get(19));
        } else if (i == 24) {
            tmp.hoverFunction(tmp.tabMenu.get(23));
        }
    }

    private void assertSubcategoriesVisible(List<WebElement> elementList, String[] categories, int start, int end) {
        for (int k = start; k < end; k++) {
            Assert.assertTrue(ListContainsString(elementList, categories[k]));
        }
    }
}