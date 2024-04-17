Feature: Adding / Removing items from the shopping cart.

  Scenario: User orders a product
    Given User navigates to the Magento website
    When User clicks on an element within the TopNav
      | sign in |
    And User sends keys to an element within the DialogContent
      | email    |
      | password |
    And User clicks on an element within the DialogContent
      | sign in |
    Then User should successfully sign in
    When User clicks on an element within the TopNav
      | Men |
    And User clicks on an element within the DialogContent
      | Geo Insulated Jogging Pant |
      | size                       |
      | color                      |

    And User sends keys to an element within the DialogContent
      | Qty |
    And User clicks on an element within the DialogContent
      | add to cart |
    Then User should be able to adds Hero Hoodie to shopping cart
    When User clicks on an element within the TopNav
      | cart |
    Then the user should be able to delete the product






