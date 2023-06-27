Feature: Add book functionality

  Scenario: Validate add book function
    Given add book payload
    When user calls "addplaceAPI" with post http request
    Then the api call get success with status code 200
    And "status" in the response body is "OK"
    And "scope" in the response body is "APP"

