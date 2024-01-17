@brandingChangeDetailsFeature
Feature: Test change in details on branding page

  @brandingChangeLogoDetails
  Scenario: Change name and logodetails
    Given user is on admin branding page
    When user changes name
    And user changes logo link
    And user navigates to front page
    Then new logo is visible on front page

  @brandingChangeDescDetails
  Scenario: Change description detail
    Given user is on admin branding page
    When user changes description
    And user navigates to front page
    Then new description is visible on front page
