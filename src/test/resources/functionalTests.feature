Feature: Verifying API scenarios

  Scenario: Test basic status code
    Given the endpoint exists
    When I request to get clients
    Then the status code is equal to 200

  Scenario: Test basic value from Model Package description field
    Given the endpoint exists
    When I get the android language from clients endpoint
    Then the status code is equal to 200
    And the description field reads "Test"