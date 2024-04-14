package Step_Definitions.WishList;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WishList_Steps extends ParentPage {

    WishList_Pom wp = new WishList_Pom();

    @Given("Navigate to the Magento")
    public void navigateToTheMagento() {
        GWD.getDriver().get("https://magento.softwaretestingboard.com/");
    }
    @When("User clicks on sign in button")
    public void userClicksOnSignInButton() {
    myClick(wp.signIn);
    }
    @Then("Enter username and password")
    public void enterUsernameAndPassword(DataTable userPass) {
        List<List<String>> login = userPass.asLists(String.class);
        for (List<String> strings : login) {
            WebElement element = wp.getWebElement(strings.get(0));
            mySendKeys(element, strings.get(1));
        }

    //mySendKeys(wp.eMail, "testnomad@hotmail.com");
    //mySendKeys(wp.password, "testnomad07.");
    }
    @And("User clicks on register sign in button")
    public void userClicksOnRegisterSignInButton() {
    myClick(wp.registerSignIn);
    }
    @When("User clicks on the men button in the TAB menu")
    public void userClicksOnTheMenButtonInTheTABMenu() {
    scrollToElement(wp.menButton);
    myClick(wp.product);
    }
    @Then("User choose a favourite product to like and click on the add to wish list button")
    public void userChooseAFavouriteProductToLikeAndClickOnTheButton() {
    myClick(wp.wishList);
    }
    @And("The product has been added to the wishlist message is displayed")
    public void theProductHasBeenAddedToTheWishlistMessageIsDisplayed() {
    verifyContainsText(wp.verifyMessage,"Argus All-Weather Tank has been added to your Wish List.");
    }
    @When("User clicks on my account and wish list button")
    public void userClicksOnMyAccountAndWishListButton(DataTable wish) {
        List<String> a = wish.asList(String.class);
        for (String s : a) {
            WebElement x = wp.getWebElement(s);
            myClick(x);

            //myClick(wp.myAccount);
        }
    }


   // @Then("User clicks on my wish list button")
  // public void userClicksOnMyWishListButton() {
  // myClick(wp.myWishList);
  // }

    @And("User clicks on remove item button")
    public void userClicksOnRemoveItemButton() {
    //wait.until(ExpectedConditions.elementToBeClickable(wp.removeItem));
    hoverFunction(wp.product);
    myClick(wp.removeItem);
    }
    @Then("The product has been removed from your wishlist message is displayed")
    public void theProductHasBeenRemovedFromYourWishlistMessageIsDisplayed() {
    verifyContainsText(wp.removeMessage, "Argus All-Weather Tank has been removed from your Wish List.");
    }


}
