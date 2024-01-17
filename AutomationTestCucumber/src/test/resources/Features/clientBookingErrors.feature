@clientBookingErrorFeature
Feature: Test booking from client is errorneous feature

  @firstnameBookingError
  Scenario Outline: Client booking firstname error
    Given client is on client front page
    And client clicks book button
    When client inputs incorrect firstname <name>
    And client clicks submit
    Then the error <error> is shown

    Examples: 
      | name                            | error             |
      | ""                              | firstnameBlank    |
      | "R"                             | firstnameTooShort |
      | "ThisIsATestFirstnameIncorrect" | firstnameTooLong  |

  @lastnameBookingError
  Scenario Outline: Client booking lastname error
    Given client is on client front page
    And client clicks book button
    When client inputs incorrect lastname <lastname>
    And client clicks submit
    Then the error <error> is shown

    Examples: 
      | lastname                                                              | error            |
      | ""                                                                    | lastnameIsBlank  |
      | "E"                                                                   | lastnameTooShort |
      | "ThisIsATestLastnameAndIsRediculouslyLongButYouGottaDoWhatYouGottaDo" | lastnameTooLong  |

  @emailBookingError
  Scenario Outline: Client booking email error
    Given client is on client front page
    And client clicks book button
    When client inputs incorrect email <email>
    And client clicks submit
    Then the error <error> is shown

    Examples: 
      | email  | error           |
      | ""     | emailIsBlank    |
      | "test" | emailNotCorrect |

  @phoneBookingError
  Scenario Outline: Client booking phone error
    Given client is on client front page
    And client clicks book button
    When client inputs incorrect phone <phone>
    And client clicks submit
    Then the error <error> is shown

    Examples: 
      | phone | error         |
      | ""    | phoneIsBlank  |
      | "not" | phoneTooShort |

  @daysBookingError
  Scenario Outline: Client booking days error
    Given client is on client front page
    And client clicks book button
    When client does not select days
    And client clicks submit
    Then the error <error> is shown

    Examples: 
      | error      |
      | daysIsNull |
