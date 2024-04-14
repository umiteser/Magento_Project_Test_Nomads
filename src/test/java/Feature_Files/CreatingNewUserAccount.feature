Feature: Registration

  Scenario: Registering

    Given User navigates to the website
    When User clicks on register button
    |register|
    Then User fills in the blanks
    |firstName|samo|
    |lastName|sam|
    |eMail|samAoas@hotmail.com|
    |pass|samO.@04#|
    |passConf|samO.@04#|
    And User clicks submit button
    |submit|
    Then User checks helper text
    |confirmation|Thank you for registering with Main Website Store.|