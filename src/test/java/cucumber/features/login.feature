Feature: User can login to homepage

  Background:
    Given User navigate to landingPage

  Scenario Outline: User can login to homepage
    When User type "<Username>" on username textField
    And User type "<Password>" on password textField
    Then User click login button
    And User can see homepage
    Examples:
      | No | Username      | Password     |
      | 1  | standard_user | secret_sauce |
      | 2  | problem_user  | secret_sauce |

  Scenario Outline: User can't login to homepage
    When User type "<Username>" on username textField
    And User type "<Password>" on password textField
    Then User click login button
    And User can see "<error>" message
    Examples:
      | No | Username      | Password     | error                                                                     |
      | 1  | admin         | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | 2  |               | secret_sauce | Epic sadface: Username is required                                        |
      | 3  | standard_user | admin        | Epic sadface: Username and password do not match any user in this service |
      | 4  | problem_user  |              | Epic sadface: Password is required                                        |