Feature: User can checkout products

  Background:
    Given User navigate to landingPage
    And User type "standard_user" on username textField
    And User type "secret_sauce" on password textField
    Then User click login button
    And User can see homepage

  Scenario Outline: User can add product to shopping cart
    When User can see homepage
    And User can see "<Product>"
    And User add "<Product>" to chart
    Then User can see shopping cart page
    And User can see "<Product>" was listing
    Examples:
      | No | Product             |
      | 1  | Sauce Labs Backpack |