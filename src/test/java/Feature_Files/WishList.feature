Feature: Wish List

  Scenario: Add and remove a product from wish list
    Given Navigate to the Magento
    When User clicks on sign in button
    Then Enter username and password
      | eMail    | testnomad@hotmail.com |
      | password | testnomad07.          |
    And User clicks on register sign in button
    When User clicks on the men button in the TAB menu
    Then User choose a favourite product to like and click on the add to wish list button
    And The product has been added to the wishlist message is displayed
    When User clicks on my account and wish list button
      | My Account   |
      | My Wish List |
    #Then User clicks on my wish list button
    And User clicks on remove item button
    Then The product has been removed from your wishlist message is displayed




