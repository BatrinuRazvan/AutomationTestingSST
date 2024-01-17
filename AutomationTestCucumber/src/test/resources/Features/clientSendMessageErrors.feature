@clientSendMessageErrorFeature
Feature: Test message from client is errorneous feature

  @nameMessageError
  Scenario Outline: Client message - name error
    Given the user is on client home page
    When user inputs incorrect name <name>
    And the user clicks submit
    Then the error <error> is expected

    Examples: 
      | name | error       |
      | ""   | nameIsBlank |

  @emailMessageError
  Scenario Outline: Client message - email error
    Given the user is on client home page
    When user inputs incorrect email <email>
    And the user clicks submit
    Then the error <error> is expected

    Examples: 
      | email     | error        |
      | ""        | emailIsBlank |
      | "nothing" | emailWrong   |

  @phoneMessageError
  Scenario Outline: Client message - phone error
    Given the user is on client home page
    When user inputs incorrect phone <phone>
    And the user clicks submit
    Then the error <error> is expected

    Examples: 
      | phone    | error        |
      | ""       | phoneIsBlank |
      | "077323" | phoneShort   |

  @subjectMessageError
  Scenario Outline: Client message - subject error
    Given the user is on client home page
    When user inputs incorrect subject <subject>
    And the user clicks submit
    Then the error <error> is expected

    Examples: 
      | subject | error          |
      | ""      | subjectIsBlank |
      | "not"   | subjectShort   |

  @textMessageError
  Scenario Outline: Client message - message error
    Given the user is on client home page
    When user inputs incorrect message <message>
    And the user clicks submit
    Then the error <error> is expected

    Examples: 
      | message   | error          |
      | ""        | messageIsBlank |
      | "message" | messagetShort  |
