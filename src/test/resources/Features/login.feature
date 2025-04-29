Feature: Login Functionality

  Background:
    Given user should be on login

  Scenario: Valid_Login_TC01

    When user enters valid credentials
    And click login button
    Then user should be on navigated to home page
    And user can see the logout link

    Scenario: Invalid_Login_TC02
      When user enters invalid credentials
      And click login button
      Then user should ne navigated to login page
      And user can see the error message

      @data @sanity @smoke
      Scenario Outline: Invalid_Login_with_dataset_TC03
        When user enters invalid credentials username as "<userid>" and password as "<password>"
        And click login button
        Then user should ne navigated to login page
        And user can see the error message


        Examples:
         |userid | password |
         |admin1 | pwd1     |
         |admin2 | pwd2     |
         |admin3 | pwd3     |
