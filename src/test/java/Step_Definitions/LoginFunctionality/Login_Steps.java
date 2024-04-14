package Step_Definitions.LoginFunctionality;

import Pages.*;
import Utilities.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.*;

public class Login_Steps extends ParentPage {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @Given("User navigates to the Magento website")
    public void userNavigatesToTheMagentoWebsite() {
        GWD.getDriver().get("https://magento.softwaretestingboard.com/");
    }

    @When("User clicks on an element within the TopNav")
    public void userClicksOnAnElementWithinTheTopNav(DataTable elements) {
        List<String> strElements = elements.asList(String.class);
        for (String strElement : strElements) {
            WebElement wee = tn.getWebElement(strElement);
            myClick(wee);
        }
    }

    @And("User sends keys to an element within the DialogContent")
    public void userSendsKeysToAnElementWithinTheDialogContent(DataTable elements) {
        ArrayList<ArrayList<String>> table = ExcelUtility.getData(
                "src/test/java/ApachePOI/AllInOne.xlsx",
                "AllInOne",
                2);
        List<String> strElements = elements.asList(String.class);
        for (String strElement : strElements) {
            WebElement wee = dc.getWebElement(strElement);
            for (ArrayList<String> row : table) {
                if (row.get(0).equals(strElement)) {
                    mySendKeys(wee, row.get(1));
                }
            }
        }
    }

    @And("User clicks on an element within the DialogContent")
    public void userClicksOnAnElementWithinTheDialogContent(DataTable elements) {
        List<String> strElements = elements.asList(String.class);
        for (String strElement : strElements) {
            if (strElement.equals("place order")) {
                WaitNano(30);
            }
            WebElement wee = dc.getWebElement(strElement);
            myClick(wee);
        }
    }

    @Then("User should successfully sign in")
    public void userShouldSuccessfullySignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(tn.welcomeDD));
        Assert.assertNotNull(tn.signOut, "Login failed!");
    }

    @Then("User should successfully sign out")
    public void userShouldSuccessfullySignOut() {
        verifyContainsText(dc.message, "You are signed out");
    }

    @Then("User should be directed to the Forgot Your Password page")
    public void userShouldBeDirectedToTheForgotYourPasswordPage() {
        verifyContainsText(dc.message, "Forgot Your Password?");
    }
}