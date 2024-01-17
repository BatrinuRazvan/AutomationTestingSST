@brandingChangeContactFeature
Feature: Test change in contact details on branding page

  @brandingChangeContactName
  Scenario: Change name in contact section of client page
    Given user is on branding page
    When user changes name to "Happy Bed&Breakfast" in contact details
    And user navigates to client page
    Then new name is displayed in contact section

  @brandingChangeContactAddress
  Scenario: Change address in contact section of client page
    Given user is on branding page
    When user changes address to "Str. Pestalozzi 20" in contact details
    And user navigates to client page
    Then new address is displayed in contact section
    
    @brandingChangeContactPhone
  Scenario: Change phone in contact section of client page
    Given user is on branding page
    When user changes phone to 07232134256 in contact details
    And user navigates to client page
    Then new phone is displayed in contact section
    
    @brandingChangeContactEmail
  Scenario: Change email in contact section of client page
    Given user is on branding page
    When user changes email to "uvtProject@e-uvt.ro" in contact details
    And user navigates to client page
    Then new email is displayed in contact section
