@B3801-247_folderview
Feature: Folder View Functionality
"""
  User Story:
    As a user, I should be able to change folder view order by using Name/Size/Modified buttons
  Acceptance Criteria:
    1. User can change folder view order by Name.
    2. User can change folder view order by Size.
    3. User can change folder view order by Modified.
    4. User can select all the files at once and see the total values of all files in the first line
    when clicked on the "select all" checkbox at the left top comer of the list.
    """

  #Write a method which takes one String parameter as the "fileName"
#and clicks on given file's three dot button on the files/folders list
#under Files Module page
  #(//span[.='Emploee71'])[2]/following-sibling::span[2]/a[2]

  Background: User logins and lands on the Dashboard Page
    Given the user is on the login page
    And the user logged in with username as "Employee15" and password as "Employee123"
    And the user navigates to "Files" module

  @B3801-247_folderview_AC04-TC01
  Scenario: Verify user should see the total number of all files-folders in the first line once
  select all checkbox is selected
    When user clicks on the select all checkbox
    Then verify user should see total numbers of files-folders as expected

  @B3801-247_folderview_AC04-TC02
  Scenario: Verify all check boxes should be selected once select all checkbox is selected
    When user clicks on the select all checkbox
    Then verify user should see all checkboxes as selected

  @dynamicLocater
  Scenario: Verify user should click given file's three dot button on the files/folders list
    And user clicks on "Talk"'s three dot button on the files-folders list


