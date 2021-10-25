@AddCompany
Feature: Soloodo login test
  Background: As a registered user, I would like to login for the first time to the application
    Given I am on soloodo homepage
    When I click on login link
    And I enter email address on login page
    And I enter password on login page
    And I click on login button
    Then I should be able to see email verified message

  Scenario: As a first time login user, I should be able to add company details
    Given I should be able to see email verified message
    When I click on Next button
    And I enter adress line, city and postal code
    And I enter VATID
    And I click on Next button
    And I click on Ask me later
    Then I should be navigated to Dashboard page




