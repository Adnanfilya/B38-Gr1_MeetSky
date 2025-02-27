@B3801-239_dashboard
Feature: Dashboard Functionality
"""
  User Story :As a user I should be able to modify Dashboard page

Acceptance Criteria:
1 - After Login user can see all modules and Username.
2 - User can click on Customize button and select any of the Widgets.
3 - User can click on Set Status button and select any of the Status options.
  """

  Background: User logins and lands on the Dashboard

    Given the user is on the login page
    And the user logged in with username as "Employee21" and password as "Employee123"


  @B3801-239_dashboard_AC01_TC01
  Scenario: User views modules and username after login
    When  user should see all modules
    Then the user should see their "Employee21" correctly


  @B3801-239_dashboard_AC02_TC01
  Scenario: Customize Dashboard Widgets
    When User click on the Customize button
    Then USer should see a list of available Widgets
    When User unselect a Widget from the list
    And user select a all Widget from the list
    Then User selected Widget should be displayed on the Dashboard

  @B3801-239_dashboard_AC03_TC01
  Scenario: User should be able to change online status
    When User clicks on the  Set Status button
    And User selects the "Away" status
    Then The status should be updated to "Away"
