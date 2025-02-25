@B3801-251_tasks
Feature: Tasks Module Functionality
"""
  User Story:
  As a user, I should be able to create a new task list or a single task
        and add any task to completed and important tasks list.
  Acceptance Criteria:
  1. User can create a new list of tasks
  2. User can create a new task
  3. User can add any task to the list of completed tasks by clicking on the checkbox near the task name
  4. User can add any task to the list of important tasks by clicking on the star icon on the right side of task line
  5. User can see the number of all uncompleted tasks next to the Current tab
"""

  Background: User logins app with valid credentials and lands on the tasks module page
    Given the user is on the login page
    And the user logged in with username as "Employee71" and password as "Employee123"
    And the user navigates to "Tasks" module

  @B3801-251_tasks_AC01-TC01
  Scenario: Verify user can create a new list of tasks
    When user clicks Add list
    And user writes "Adnan1" for the list and clicks submit button
    Then user should see the "Adnan1" list under Tasks label

  @B3801-251_tasks_AC02-TC01
  Scenario: Verify user can create a new task
    When user clicks "Adnan1" list
    And user writes "adnan" for the task and presses Enter button
    Then user should see the "adnan" as a task

  @B3801-251_tasks_AC03-TC01
  Scenario: Verify user can add any task to the list of completed tasks by clicking on the checkbox near the task name
    When user clicks "Adnan1" list
    And user clicks checkbox near "adnan" task
    Then user should see "adnan" in completed tasks

  @B3801-251_tasks_AC04-TC01
  @wip
  Scenario: Verify user can add any task to the list of important tasks by clicking on the star icon on the right side of task line
    When user clicks "Adnan1" list
    And user clicks the star icon of "adnan" task
    Then user should see "adnan" in important tasks

  @B3801-251_tasks_AC05-TC01
  Scenario: Verify User can see the number of all uncompleted tasks next to the Current tab
    When user clicks the Current tab
    Then user should see the number of all uncompleted tasks
