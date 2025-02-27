@B3801-242_Deck
Feature: Deck Page
  User Story: As a user, I should be able to manage my works by creating a
  new board/list/card and modifying them under Deck Module.
  """
1.  User can create a new board
2.  User can create a new list of card/task under any board
3.  User can add a new card/task on any list on the current board
4.User can assign any card/task to himself/herself by using the three dots on the related card
"""
  Background: User is already in the log in page and go to Deck Modules
    Given the user is on the login page
    When the user logged in with username as "Employee31" and password as "Employee123"
    And the user navigates to "deck" module
    Then the user clicks on the open navigation button
  @B3801-242_Deck-AC02-TC01
  Scenario: User can create a new board
    When the user clicks on the add board button
    And the user enters "selim" as the board name
    Then the user should see "selim" under all boards
  @B3801-242_Deck-AC02-TC02
  Scenario: User can create a new list of cards/tasks under any board
    When  the user is on an existing board named "selim"
    And the user clicks on the add list button and enters "goals" as the list name
    Then the user should see "goals" under the board
  @B3801-242_Deck-AC02-TC03
  Scenario: User can add a new card/task on any list on the current board
    When the user is on an existing board named "selim"
    And the user clicks on the add card button under the list
    And the user enters "Atiba" as the card name
    Then the user should see card under the  list
  @B3801-242_Deck-AC02-TC04
  Scenario: User can assign any card/task to himself/herself by using the three dots on the related card
    When the user is on an existing board named "selim"
    And the user clicks on the three dots menu of card
    And the user selects the Assign to me option
    Then the user should see himself or herself assigned to related card
