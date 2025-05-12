Feature: API Testing

  @API
  Scenario: Verify_List_User
    Given endpoint "https://reqres.in/api/users?page=2"
    When user perform GET operation
    Then user can validate the status code
    And validate the response
