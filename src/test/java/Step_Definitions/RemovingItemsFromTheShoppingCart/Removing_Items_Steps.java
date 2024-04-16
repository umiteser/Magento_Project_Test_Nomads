package Step_Definitions.RemovingItemsFromTheShoppingCart;

import Pages.DialogContent;
import Pages.ParentPage;
import Pages.TopNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Removing_Items_Steps extends ParentPage {
    Removing_Items_Pom rip=new Removing_Items_Pom();
    TopNav tn=new TopNav();
    DialogContent dc= new DialogContent();

    @Then("User should be able to adds Hero Hoodie to shopping cart")
    public void userShouldBeAbleToAddsHeroHoodieToShoppingCart() {
            wait.until(ExpectedConditions.elementToBeClickable(rip.MSG));
            Assert.assertTrue(rip.MSG.getText().contains("You added Geo Insulated Jogging Pant to your shopping cart"));
        }

    @Then("the user should be able to delete the product")
    public void theUserShouldBeAbleToDeleteTheProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(rip.Delete));
        myClick(rip.Delete);
        myClick(rip.OK);
        Assert.assertFalse(rip.DMSG.getText().contains("You have items"));
    }

}
