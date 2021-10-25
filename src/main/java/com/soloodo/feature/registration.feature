@Registration
Feature: Soloodo registration test

  Background: As a new user, I would like to navigate to Registration page
    Given I am on soloodo homepage
    When I click on register link
    Then I should be navigated to registration page

   @Test1
  Scenario Outline: As a new Shipper user, I would like to register myself in the website
  When I select country
  And I enter company
  And I enter name
  And I enter phone Number
  And I enter email "<email>"
  And I enter password "<password>"
  And I accept terms & conditions
  And I click on register button
  Then I should be navigated to welcome page of shipper
     Examples:
       | email                     | password |
       | sheebadmalik0.5@gmail.com | Test@123 |

  @Test2
  Scenario Outline: As a new Carrier user, I would like to register myself in the website
  When I select carrier option
  And I select country
  And I enter company
  And I enter name
  And I enter phone Number
  And I enter email "<email>"
  And I enter password "<password>"
  And I accept terms & conditions
  And I click on register button
  Then I should be navigated to welcome page of carrier
    Examples:
      | email            | password |
      | test243@test.com | Test@123 |





