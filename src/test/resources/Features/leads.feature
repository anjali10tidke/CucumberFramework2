Feature: Lead Functionality

  Background:
    Given user should be on login
    When user login successfully


    @lead
    Scenario: Lead_Creation_TC04
      When user click on new lead and fill the mandatory fields and click on save
      |modi | bjp |
      |gandhi | congress |
      |kejriwal | arbind |
      And click on logout
      And close browser

  Scenario: Lead_Creation_TC05
    When user click on new lead and fill the mandatory fields from excel and click on save
    And click on logout
    And close browser