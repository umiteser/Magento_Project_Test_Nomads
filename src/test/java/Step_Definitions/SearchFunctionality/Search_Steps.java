package Step_Definitions.SearchFunctionality;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.*;

public class Search_Steps extends ParentPage {

    Search_Pom sp = new Search_Pom();
    List<String> productNames = new ArrayList<>();
    List<String> productSKUNumber = new ArrayList<>();
    List<String> mainCategories = new ArrayList<>();
    List<String> subcategories = new ArrayList<>();
    List<String> name = new ArrayList<>();
    int rdmIndex;

    @And("List all products on the website")
    public void listAllProductsOnTheWebsite() {
        wait.until(ExpectedConditions.visibilityOfAllElements(sp.mainCategory));
        for (int i = 2; i < sp.tabMenu.size(); i++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='ui-id-2'] li")));
            switch (i) {
                case 3:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 12:
                case 13:
                case 14:
                case 15:
                case 17:
                case 18:
                case 20:
                case 21:
                case 22:
                    tabMenuDisplay(i);
                    listingProducts();
                    break;
            }
        }
    }

    @And("Send SKU number to the product search box")
    public void sendSKUNumberToTheProductSearchBox() {
        wait.until(ExpectedConditions.visibilityOf(sp.searchBox));
        rdmIndex = RandomGenerator(productSKUNumber.size(), 0);
        sp.mySendKeys(sp.searchBox, productSKUNumber.get(rdmIndex));
        sp.myClick(sp.searchButton);
    }

    @Then("View the listing of the SKU number shipped product")
    public void viewTheListingOfTheSKUNumberShippedProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElements(sp.products));
        Assert.assertTrue(ListContainsString(sp.products, productNames.get(rdmIndex)), "The product of the SKU number could not be displayed in the search results.");
    }

    @Then("Click on the relevant product by following the link of the product from the TAB Menu")
    public void clickOnTheRelevantProductByFollowingTheLinkOfTheProductFromTheTABMenu() {
        accessCategoryFromLink();
        for (int j = 0; j < sp.products.size(); j++) {
            wait.until(ExpectedConditions.elementToBeClickable(sp.products.get(j)));
            if (sp.products.get(j).getText().contains(name.get(rdmIndex))) {
                sp.myClickNoScroll(sp.products.get(j));
                break;
            }
        }
    }

    @And("Confirm the SKU number on the product page")
    public void confirmTheSKUNumberOnTheProductPage() {
        Assert.assertEquals(productSKUNumber.get(rdmIndex), sp.skuNumber.getText(), "The SKU number on the product page does not match the SKU number of the searched product.");
    }

    @And("Send invalid SKU number to product search box")
    public void sendInvalidSKUNumberToProductSearchBox() {
        wait.until(ExpectedConditions.visibilityOf(sp.searchBox));
        sp.mySendKeys(sp.searchBox, "ABC");
        sp.myClick(sp.searchButton);
    }

    @Then("Display error message")
    public void displayErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(sp.errorMessage));
        Assert.assertTrue(sp.errorMessage.getText().contains("Your search returned no results."), "Error message could not be displayed.");
    }

    private void tabMenuDisplay(int i) {
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
                sp.hoverFunction(sp.tabMenu.get(1));
                sp.hoverFunction(sp.tabMenu.get(2));
                sp.myClickNoScroll(sp.tabMenu.get(i));
                break;
            case 8:
            case 9:
                sp.hoverFunction(sp.tabMenu.get(1));
                sp.hoverFunction(sp.tabMenu.get(7));
                sp.myClickNoScroll(sp.tabMenu.get(i));
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                sp.hoverFunction(sp.tabMenu.get(10));
                sp.hoverFunction(sp.tabMenu.get(11));
                sp.myClickNoScroll(sp.tabMenu.get(i));
                break;
            case 17:
            case 18:
                sp.hoverFunction(sp.tabMenu.get(10));
                sp.hoverFunction(sp.tabMenu.get(16));
                sp.myClickNoScroll(sp.tabMenu.get(i));
                break;
            case 20:
            case 21:
            case 22:
                sp.hoverFunction(sp.tabMenu.get(19));
                sp.myClickNoScroll(sp.tabMenu.get(i));
                break;
        }
    }

    public void listingProducts() {
        boolean hasNextPage = true;
        while (hasNextPage) {
            for (int j = 0; j < sp.products.size(); j++) {
                wait.until(ExpectedConditions.elementToBeClickable(sp.products.get(j)));
                sp.myClickNoScroll(sp.products.get(j));
                productNames.add(sp.productTitle.getText());
                productSKUNumber.add(sp.skuNumber.getText());
                wait.until(ExpectedConditions.visibilityOfAllElements(sp.categoryLink));
                mainCategories.add(sp.categoryLink.get(1).getText());
                name.add(sp.categoryLink.get(sp.categoryLink.size() - 1).getText());
                subcategories.add(sp.categoryLink.get(sp.categoryLink.size() - 2).getText());
                GWD.getDriver().navigate().back();
            }
            List<WebElement> nextButtons = GWD.getDriver().findElements(By.xpath("//div[@class='column main']/div[5]//a[@title='Next']"));
            if (!nextButtons.isEmpty()) {
                sp.myClick(nextButtons.get(0));
            } else {
                hasNextPage = false;
            }
        }
    }

    public void accessCategoryFromLink() {
        if (mainCategories.get(rdmIndex).equals("Women")) {
            switch (subcategories.get(rdmIndex)) {
                case "Jackets":
                    sp.hoverFunction(sp.tabMenu.get(1));
                    sp.hoverFunction(sp.tabMenu.get(2));
                    sp.myClickNoScroll(sp.tabMenu.get(3));
                    break;
                case "Hoodies & Sweatshirts":
                    sp.hoverFunction(sp.tabMenu.get(1));
                    sp.hoverFunction(sp.tabMenu.get(2));
                    sp.myClickNoScroll(sp.tabMenu.get(4));
                    break;
                case "Tees":
                    sp.hoverFunction(sp.tabMenu.get(1));
                    sp.hoverFunction(sp.tabMenu.get(2));
                    sp.myClickNoScroll(sp.tabMenu.get(5));
                    break;
                case "Bras & Tanks":
                    sp.hoverFunction(sp.tabMenu.get(1));
                    sp.hoverFunction(sp.tabMenu.get(2));
                    sp.myClickNoScroll(sp.tabMenu.get(6));
                    break;
                case "Pants":
                    sp.hoverFunction(sp.tabMenu.get(1));
                    sp.hoverFunction(sp.tabMenu.get(7));
                    sp.myClickNoScroll(sp.tabMenu.get(8));
                    break;
                case "Shorts":
                    sp.hoverFunction(sp.tabMenu.get(1));
                    sp.hoverFunction(sp.tabMenu.get(7));
                    sp.myClickNoScroll(sp.tabMenu.get(9));
                    break;
            }
        } else if (mainCategories.get(rdmIndex).equals("Men")) {
            switch (subcategories.get(rdmIndex)) {
                case "Jackets":
                    sp.hoverFunction(sp.tabMenu.get(10));
                    sp.hoverFunction(sp.tabMenu.get(11));
                    sp.myClickNoScroll(sp.tabMenu.get(12));
                    break;
                case "Hoodies & Sweatshirts":
                    sp.hoverFunction(sp.tabMenu.get(10));
                    sp.hoverFunction(sp.tabMenu.get(11));
                    sp.myClickNoScroll(sp.tabMenu.get(13));
                    break;
                case "Tees":
                    sp.hoverFunction(sp.tabMenu.get(10));
                    sp.hoverFunction(sp.tabMenu.get(11));
                    sp.myClickNoScroll(sp.tabMenu.get(14));
                    break;
                case "Tanks":
                    sp.hoverFunction(sp.tabMenu.get(10));
                    sp.hoverFunction(sp.tabMenu.get(11));
                    sp.myClickNoScroll(sp.tabMenu.get(15));
                    break;
                case "Pants":
                    sp.hoverFunction(sp.tabMenu.get(10));
                    sp.hoverFunction(sp.tabMenu.get(16));
                    sp.myClickNoScroll(sp.tabMenu.get(17));
                    break;
                case "Shorts":
                    sp.hoverFunction(sp.tabMenu.get(10));
                    sp.hoverFunction(sp.tabMenu.get(16));
                    sp.myClickNoScroll(sp.tabMenu.get(18));
                    break;
            }
        } else if (mainCategories.get(rdmIndex).equals("Gear")) {
            switch (subcategories.get(rdmIndex)) {
                case "Bags":
                    sp.hoverFunction(sp.tabMenu.get(19));
                    sp.myClickNoScroll(sp.tabMenu.get(20));
                    break;
                case "Fitness Equipment":
                    sp.hoverFunction(sp.tabMenu.get(19));
                    sp.myClickNoScroll(sp.tabMenu.get(21));
                    break;
                case "Watches":
                    sp.hoverFunction(sp.tabMenu.get(19));
                    sp.myClickNoScroll(sp.tabMenu.get(22));
                    break;
            }
        }
    }
}