package Step_Definitions.AddressAddition;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Address_Steps extends ParentPage {

    Address_Pom aa = new Address_Pom();
    @When("User clicks on signin button")
    public void userClicksOnSigninButton(DataTable x) {
        List<String> a = x.asList(String.class);
        for (String s : a) {
            WebElement element = aa.getWebElement(s);
            myClick(element);
        }
    }
    @Then("User fills in to login")
    public void userFillsInToLogin(DataTable x) {

        List<List<String>> a = x.asLists(String.class);
        for (List<String> strings : a) {
            WebElement element = aa.getWebElement(strings.get(0));
            mySendKeys(element, strings.get(1));
        }

    }
    @And("User clicks submit")
    public void userClicksSubmit(DataTable table) {
        List<String> x = table.asList(String.class);
        for (String s : x) {
            WebElement element = aa.getWebElement(s);
            myClick(element);
        }
    }
    @Then("User clicks on my acc button")
    public void userClicksOnMyAccButton(DataTable t) {
        List<String> a = t.asList(String.class);
        for (String s : a) {
            WebElement x = aa.getWebElement(s);
            myClick(x);
        }
    }
    @And("User clicks on manage address button")
    public void userClicksOnManageAddressButton(DataTable table) {
        List<String> s = table.asList(String.class);
        for (String string : s) {
            WebElement as = aa.getWebElement(string);
            myClick(as);
        }
    }
    @When("User fills in the blank")
    public void userFillsInTheBlank(DataTable x) {
        List<List<String>> s = x.asLists(String.class);
        for (List<String> strings : s) {
            WebElement as = aa.getWebElement(strings.get(0));
            mySendKeys(as, strings.get(1));
        }
        Select dd = new Select(aa.id);
        dd.selectByIndex(12);
        mySendKeys(GWD.getDriver().findElement(By.id("zip")), "12341");
    }
    @Then("User saves the new address")
    public void userSavesTheNewAddress(DataTable q) {
        List<String> a = q.asList(String.class);
        for (String string : a) {
            WebElement s = aa.getWebElement(string);
            myClick(s);
        }
    }
    @And("User checks helper texts")
    public void userChecksHelperTexts(DataTable a) {
        List<List<String>> as = a.asLists(String.class);
        for (List<String> strings : as) {
            WebElement d = aa.getWebElement(strings.get(0));
            verifyContainsText(d, strings.get(1));
        }
    }
}
