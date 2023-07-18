Feature: Reqres create user

  Scenario Outline: Verify the create user api
    Given crate user payload with "<name>" and "<job>"
    When User hit "createUserAPI" api with http "POST" request
    Then api call get success with status code 201
   # And Validate user got created and map to "<name>" with "getuser" api

    Examples:
    |name              |   job        |
    | Karunakara       |    SDET      |
