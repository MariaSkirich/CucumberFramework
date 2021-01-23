Feature: Dashboard Tab Functionality

  @dashboardTabs
  Scenario: dashboard tab verification
    When enter valid credentials
    And click on login button
    Then verify Dashboard is displayed
    Then verify the following tabs on dashboard
          |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|
