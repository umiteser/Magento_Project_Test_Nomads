Feature: TAB Menu

  Scenario: TAB Menu Control
    Given Navigate to the Magento website
    When Click on the element in panel header
      | singIn |

    Then Enter email as "testdeneme@gmail.com" password as "TestDeneme123." click sing in button
    And The main categories of the TAB menu should be displayed
    Then Check the TAB menu