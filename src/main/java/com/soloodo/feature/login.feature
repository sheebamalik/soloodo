@Login
Feature: Soloodo login test
  Background: As an already registered user, I would like to navigate to login page
    Given I am on soloodo homepage
    When I click on login link
    Then I should be navigated to login page

    @Test1
    Scenario: As a first time registered user, I would like to login to the application
    When I enter new email address on login page
    And I enter password on login page
    And I click on login button
    Then I should be navigated to welcome page of shipper

  @Test2
    Scenario: As a registered user, I should be able to login to the application
      When I enter registered email address on login page
      And I enter password on login page
      And I click on login button
      Then I should be navigated to Dashboard page


