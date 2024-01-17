@clientBookingFeature
Feature: Test client booking creation feature

  @clientBookingSuccess
  Scenario: Client creates a booking
    Given client is on home page
    And client clicks book now button
    When client inputs correct firstname "Razvan", lastname "Testing", email "razvan.batrinu@e-uvt.ro", phone "072834567899"
    And client selects nights
    And user clicks book button
    Then a new booking is visible on admin report page
