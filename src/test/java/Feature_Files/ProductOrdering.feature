Feature: Product Ordering

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
      | gear |
    And User clicks on an element within the DialogContent
      | water bottle |
      | add to cart  |
    Then User should be able to see Water Bottle in the cart
    When User clicks on an element within the TopNav
      | proceed |
    And User sends keys to an element within the DialogContent
      | street  |
      | city    |
      | zip     |
      | phoneNo |
    And User clicks on an element within the DialogContent
      | fixed |
    And User selects an element within the DialogContent
      | state | Kentucky |
    And User clicks on an element within the DialogContent
      | next        |
      | place order |
    Then User should successfully complete the order