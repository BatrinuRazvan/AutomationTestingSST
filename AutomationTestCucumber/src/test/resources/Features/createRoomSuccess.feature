@createRoomSuccessFeature
Feature: Test adding rooms functionality
  The admin user wants to be able to add new rooms to be booked

  @createRoomsSuccess
  Scenario Outline: Create rooms - possible combinations
    Given user is on admin rooms page
    When user inputs <room>, <type>, accessible: true, <price> and <details>
    Then a new room is created

    Examples: 
      | room | type   | price | details         |
      |  110 | Single |    50 | TV,WiFi         |
      |  111 | Twin   |   100 | TV,WiFi,Safe    |
      |  112 | Double |   110 | Safe,Views      |
      |  113 | Family |   150 | WiFi,Radio      |
      |  114 | Suite  |   200 | Safe,Views,WiFi |
