@featureTag @login
Feature: Login Functionality

  @smoke @validCredsTest
  Scenario: Login with valid credentials
    #Given navigate to HRMS login page
    When enter valid credentials
    And click on login button
    Then verify Dashboard is displayed
    #And quit the browser

  @regression @invalidCredsTest
  Scenario: Login with invalid credentials
    #Given navigate to HRMS login page
    When enter invalid credentials
    And click on login button
    Then verify error message
    #And quit the browser

  @regression @emptyUsernameTest
  Scenario: Login with empty username
    #Given navigate to HRMS login page
    When leave username empty
    And click on login button
    Then verify error message for empty username
    #And quit the browser

    @regression @emptyPasswordTest @syntax
  Scenario: Login with empty password
    #Given navigate to HRMS login page
    When leave password empty
    And click on login button
    Then verify error message for empty password
    #And quit the browser
