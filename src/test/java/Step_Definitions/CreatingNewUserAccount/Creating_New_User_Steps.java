package Step_Definitions.CreatingNewUserAccount;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Creating_New_User_Steps extends ParentPage {

    Creating_New_User_Pom nu = new Creating_New_User_Pom();

    @Given("User navigates to the website")
    public void userNavigatesToTheWebsite() {
        GWD.getDriver().get("https://magento.softwaretestingboard.com/");
        System.out.println("website on");
    }

    @When("User clicks on register button")
    public void userClicksOnRegisterButton(DataTable table) {
        List<String> x = table.asList(String.class);
        for (String eleman : x) {
            WebElement element = nu.getWebElement(eleman);
            myClick(element);
        }
        // myClick(GWD.getDriver().findElement(By.cssSelector("div[class='panel header'] li:nth-child(3) a")));
        System.out.println("register button clicked");
    }

    @Then("User fills in the blanks")
    public void userFillsInTheBlanks(DataTable a) {
        List<List<String>> list = a.asLists(String.class);
        for (List<String> e : list) {
            WebElement s = nu.getWebElement(e.get(0));
            mySendKeys(s, e.get(1));
        }
//        mySendKeys(GWD.getDriver().findElement(By.cssSelector("input[id='firstname']")), "samo");
//        mySendKeys(GWD.getDriver().findElement(By.cssSelector("input[id='lastname']")), "sam");
//        mySendKeys(GWD.getDriver().findElement(By.cssSelector("input[id='email_address']")), "samAos@hotmail.com");
//        mySendKeys(GWD.getDriver().findElement(By.cssSelector("input[id='password']")), "samO.@04#");
//        mySendKeys(GWD.getDriver().findElement(By.cssSelector("input[id='password-confirmation']")), "samO.@04#");

    }

    @And("User clicks submit button")
    public void userClicksSubmitButton(DataTable a) {
        List<String> s = a.asList(String.class);
        for (String x : s) {
            WebElement d = nu.getWebElement(x);
            myClick(d);
        }
        //   myClick(GWD.getDriver().findElement(By.cssSelector("button[type='submit'][title='Create an Account']")));
    }

    @Then("User checks helper text")
    public void userChecksHelperText(DataTable a) {
        List<List<String>> s = a.asLists(String.class);
        for (List<String> x : s) {
            WebElement d = nu.getWebElement(x.get(0));
            verifyContainsText(d, x.get(1));
        }
    }
}

