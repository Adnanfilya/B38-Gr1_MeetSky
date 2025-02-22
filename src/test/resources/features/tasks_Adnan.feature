@tasks @B3801-251_tasks
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

  @tasks @B3801-251_tasks_AC01-TC01
  @wip
  Scenario: Verify user can create a new list of tasks
    When user clicks Add list
    And user writes "Adnan51" for the list and clicks submit button
    Then user should see the "Adnan51" list under Tasks label

  @tasks @B3801-251_tasks_AC02-TC01
  @wip
  Scenario: Verify user can create a new task

