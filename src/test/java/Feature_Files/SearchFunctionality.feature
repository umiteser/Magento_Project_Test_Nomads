Feature: Search Functionality

  Scenario:
    Given Navigate to the Magento website
    When Click on the element in panel header
      | singIn |
    Then Enter email as "testdeneme@gmail.com" password as "TestDeneme123." click sing in button
    And List all products on the website
    And Send SKU number to the product search box
    Then View the listing of the SKU number shipped product
    Then Click on the relevant product by following the link of the product from the TAB Menu
    And Confirm the SKU number on the product page
