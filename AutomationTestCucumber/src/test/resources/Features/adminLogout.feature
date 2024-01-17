@logoutFeature
Feature: Test logout when on admin page functionality

  @logoutSuccess
  Scenario: Logout is successful
    Given user is logged in as admin
    When user clicks on logout button
    Then user is navigated to login page