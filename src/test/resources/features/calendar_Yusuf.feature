@243_calendar
Feature: Calendar Module Functionality
  User Story: As a user, I should be able to see Daily-Weekly-Monthly calendar view and create a new event under the Calendar module

  Background: User logins and lands on the Calendar page
    Given the user is on the login page
    Given the user logged in with username as "Employee81" and password as "Employee123"
    Given the user goes to "Calendar" module


  @243_calendar_AC01-TC01-02-03
  Scenario Outline: User can display daily calendar view
    When user clicks date selector button
    Then user should see the "<Daily>" "<Weekly>" and "<Monthly>" calendar view
    Examples:
      | Daily |  | Weekly |  | Monthly |
      | Day   |  | Week   |  | Month   |

    @243_calendar_AC01-TC04
    Scenario: User can create a new event under the Calendar module and see it on the related day through the Monthly Calendar view
      When user opens new event
      Then user should see the "Adroit" under the Calendar Module
      And user should see the "Adroit" on Monthly Calendar View



