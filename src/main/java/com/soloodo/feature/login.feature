@Login
Feature: Soloodo login test
  Background: As an already registered user, I would like to navigate to login page
    Given I am on soloodo homepage
    When I click on login link
    Then I should be navigated to login page

    @Test1
      Scenario: As an already registered user, I would like to login to the application
      Given I should be navigated to login page
      When I enter email address
      And I enter password
      And I click on login button
      Then I should be logged in to the application