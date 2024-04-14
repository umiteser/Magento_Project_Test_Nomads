Feature: Login Functionality

  Scenario: User signs in, navigates through the website, and signs out
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
      | welcome |
      | sign out |
    Then User should successfully sign out
    When User clicks on an element within the TopNav
      | sign in |
    And User clicks on an element within the DialogContent
      | forgot your password |
    Then User should be directed to the Forgot Your Password page