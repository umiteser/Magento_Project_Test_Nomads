Feature: Address

  Scenario: Adding new Address
    Given User navigates to the website
    When User clicks on signin button
      | signIn |
    Then User fills in to login
      | eMail | samAos@hotmail.com |
      | pass  | samO.@04#          |
    And User clicks submit
      | submit |
    Then User clicks on my acc button
      | drop  |
      | myAcc |
    And User clicks on manage address button
      | manageAddress |
      | addAddress    |
    When User fills in the blank
      | company | mechnostudy |
      | phone   | 3124121     |
      | street1 | mersinn     |
      | street2 | cilk        |
      | street3 | tomuk       |
      | city    | urfa        |
      | zip     | 12341       |
    Then User saves the new address
      | saveAddress |
    And User checks helper texts
      | confirmation | You saved the address. |
