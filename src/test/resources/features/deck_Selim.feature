@B3801-242_Deck
Feature: Deck Page
  User Story: As a user, I should be able to manage my works by creating a
  new board/list/card and modifying them under Deck Module.

  Background: User is already in the log in page and go to Deck Modules
    Given the user is on the login page
    When the user logged in with username as "Employee31" and password as "Employee123"
    And the user navigates to "deck" module

  Scenario: User can create a new board
    When the user clicks on the open navigation button
    And the user clicks on the add board button
    And the user enters "selim" as the board name
    Then the user should see "selim" under all boards

  Scenario: User can create a new list of cards/tasks under any board
    Given the user clicks on the open navigation button
    When  the user is on an existing board named "selim"
    And the user clicks on the add list button
    And the user enters "To Do" as the list name
    Then the user should see "To Do" under the "selim" board
  @selim
  Scenario: User can add a new card/task on any list on the current board
    Given the user clicks on the open navigation button
    Given the user is on an existing board named "selim"
    When the user clicks on the add card button under "To Do"
    And the user enters "Automation" as the card name
    Then the user should see "Automation" under the "To Do" list

  Scenario: User can assign any card/task to himself/herself by using the three dots on the related card
    Given the user clicks on the open navigation button
    Given the user is on an existing board named "selim"
    When the user clicks on the three dots menu of "Automation"
    And the user selects the "Assign to me" option
    Then the user should see "himself or herself" assigned to "Automation"
