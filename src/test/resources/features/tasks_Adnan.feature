@tasks
Feature: As a user, I should be able to create a new task list or a single task
       and add any task to completed and importants tasks list.

  Background: User logins app
    Given the user is on the login page
    And the user logged in with username as "Employee71" and password as "Employee123"


  @wip
  Scenario: User can create a new list of tasks
    When the user navigates to "Tasks" module
    And user clicks Add list
    And user writes a "name2" of the list and clicks submit button
    Then user should see the "name" list under Tasks label
