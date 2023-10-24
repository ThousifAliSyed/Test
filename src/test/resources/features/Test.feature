Feature: Validate Login functionality

  @Regression
  Scenario Outline: Validate login functionality
    Given User navigates to the landing page
    When User navigates to Login Page
    And User enters username
    And User enters password
    And User clicks on Submit Button
    Then Validate User Navigates to Home Page successfully

    Examples:
      | username | password             |
      | tomsmith | SuperSecretPassword! |