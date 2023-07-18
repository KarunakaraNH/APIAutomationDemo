Feature: Add and delete Place functionality

  Scenario Outline: Validate add place flow
    Given addplace payload with "<name>" "<language>" "<address>"
    When user calls "addPlaceAPI" with "POST" http request
    Then the api call get success with status code 200
    And "status" in the response body is "OK"
    And "scope" in the response body is "APP"
    Then verify place_Id created maps to "<name>" using "getPlaceAPI"

    Examples:
    |name        |language      | address|
    |Abhilash    |English       |Bangalore|
    | Rahul   |France       |Bangalore|


  # Scenario: Validate delete place
    #Given Delete place payload
      # When user calls "deletePlaceAPI" with post http request
     ##When user calls "addPlaceAPI" with "post" http request
      #Then the api call get success with status code 200
      #And "status" in the response body is "OK"
      #And "scope" in the response body is "APP"

