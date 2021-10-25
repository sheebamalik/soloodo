@Login
Feature: Soloodo login test
  Background: As an already registered user, I would like to navigate to login page
    Given I am on soloodo homepage
    When I click on login link
    Then I should be navigated to login page

    @Test1
    Scenario Outline: As a first time registered user, I would like to login to the application
    When I enter email address "<email>" on login page
    And I enter password "<password>" on login page
    And I click on login button
    Then I should be navigated to welcome page of shipper
      Examples:
        | email                     | password |
        | sheebadmalik0.5@gmail.com | Test@123 |

  @Test2
    Scenario Outline: As a registered user, I should be able to login to the application
      When I enter email address "<email>" on login page
      And I enter password "<password>" on login page
      And I click on login button
      Then I should be navigated to Dashboard page
      Examples:
        | email                     | password |
        | sheeba.dmalik05@gmail.com | Test@123 |

