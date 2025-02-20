@244_calendar
Feature: Calendar Module Functionality

  Background: User logins and lands on the Calendar page
    Given the user is on the login page
    Given the user logged in with username as "Employee81" and password as "Employee123"


  @244_calendar_AC01-TC01
  Scenario: As a user, I should be able to see Daily-Weekly-Monthly calendar view and create a new event under the Calendar module
    And the user navigates to "Calendar" module

