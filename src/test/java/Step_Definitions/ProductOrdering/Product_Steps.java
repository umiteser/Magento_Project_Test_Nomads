package Step_Definitions.ProductOrdering;

import Pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.util.List;

public class Product_Steps extends ParentPage {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @Then("User should be able to see Water Bottle in the cart")
    public void userShouldBeAbleToSeeWaterBottle() {
        wait.until(ExpectedConditions.textToBePresentInElement(tn.counter, "1"));
        myClick(tn.cart);
        wait.until(ExpectedConditions.visibilityOfAllElements(tn.cartItems));
        Assert.assertTrue(ListContainsString(tn.cartItems, "Affirm Water Bottle"), "The product could not be found in the cart!");
    }

    @And("User selects an element within the DialogContent")
    public void userSelectsAnElementWithinTheDialogContent(DataTable elements) {
        List<List<String>> strElements = elements.asLists(String.class);
        for (List<String> strElement : strElements) {
            WebElement wee = dc.getWebElement(strElement.get(0));
            wait.until(ExpectedConditions.visibilityOf(wee));
            Select select = new Select(wee);
            select.selectByVisibleText(strElement.get(1));
        }
    }

    @Then("User should successfully complete the order")
    public void userShouldSuccessfullyCompleteTheOrder() {
        verifyContainsText(dc.message, "Thank you for your purchase!");
    }
}