Feature: Registration

  Scenario: Registering

    Given User navigates to the website
    When User clicks on register button
    Then User fills in the blanks
    And User clicks submit button
    Then User checks helper text