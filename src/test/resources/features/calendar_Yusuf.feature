@244_calendar
Feature: Calendar Module Functionality
  User Story: As a user, I should be able to see Daily-Weekly-Monthly calendar view and create a new event under the Calendar module

  Background: User logins and lands on the Calendar page
    Given the user is on the login page
    Given the user logged in with username as "Employee81" and password as "Employee123"


  @244_calendar_AC01-TC01
  Scenario: User can display daily calendar view
    When the user navigates to "Calendar" module
    When user clicks date selector button
    Then user should see the daily calendar view


