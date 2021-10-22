@Registration
Feature: Soloodo registration test

  Background: As a new user, I would like to navigate to Registration page
    Given I am on soloodo homepage
    When I click on register link
    Then I should be navigated to registration page

  @Test1
    Scenario: As a new Shipper user, I would like to register myself in the website
    Given I should be navigated to registration page
    When I select shipper option
    #When user selects country
    And I enter company
    And I enter name
    And I enter phone Number
    And I enter email address
    And I enter password
    And I accept terms & conditions
    And I click on register button
    Then I should be navigated to welcome page of shipper

  @Test2
  Scenario: As a new Carrier user, I would like to register myself in the website
    Given I should be navigated to registration page
    When I select carrier option
    When user selects country
    And I enter company
    And I enter name
    And I enter phone Number
    And I enter email address
    And I enter password
    And I accept terms & conditions
    And I click on register button
    Then user navigates to welcome page of carrier




