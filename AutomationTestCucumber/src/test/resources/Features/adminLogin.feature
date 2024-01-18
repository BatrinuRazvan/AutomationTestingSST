@loginFeature
Feature: Test Login as admin functionality

  @loginSuccess
  Scenario: Login is successful with valid credentials
    Given user is on admin login page
    When user enters username and password both valid
    And user clicks login
    Then admin home page opens

  @loginFail
  Scenario: Login fails with valid username
    Given user is on admin login page
    When user enters valid username and password
    And user clicks login
    Then input fields turn red

  @loginFail
  Scenario: Login fails with valid password
    Given user is on admin login page
    When user enters username and valid password
    And user clicks login
    Then input fields turn red

  @loginFail
  Scenario: Login fails with invalid credentials
    Given user is on admin login page
    When user enters invalid username password
    And user clicks login
    Then input fields turn red
