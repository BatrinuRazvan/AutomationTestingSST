@clientSendMessageFeature
Feature: Test message from client feature

  @clientSendMessageSuccess
  Scenario Outline: Client message - possible combinations and success
    Given user is on client home page
    When user inputs correct <name>, <email>, <phone>, <subject> and <message>
    And user clicks submit
    Then a new message is visible on the admin page

    Examples: 
      | name     | email                       | phone          | subject      | message                                                                 |
      | "Razvan" | "razvan.batrinu03@e-uvt.ro" | "072321333245" | "Room price" | "Hello! I would like to know how much it would cost me to book a room." |
      | "Anton"  | "anton.pan02@e-uvt.ro"      | "072321333245" | "Room price" | "Hello! I would like to know how much it would cost me to book a room." |