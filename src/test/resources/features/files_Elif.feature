@B3801-240_files
Feature: Upload a file, move or delete any selected file under the Files module


  Background: : Verify that the user can successfully upload a file using the "Upload" option
    Given the user is on the login page
    And the user logged in with username as "Employee121" and password as "Employee123"
    And the user navigates to "Files" module

  @B3801-240_files_AC1_TC1
  Scenario: Verify that the uploaded file appears in the files list after a successful upload
    And the user clicks on the "Plus" button
    And the user selects a valid file "C:\Users\C\OneDrive\Desktop\Test1.txt" to upload
    Then the uploaded "Test1" should be displayed in the files list

  @B3801-240_files_AC2_TC1
  Scenario: Verify that the user can create a new folder using the "New Folder" option
    Then the total number of files and folders should be displayed under the files list table
    And the user clicks on the "Plus" button
    And the user clicks on the New Folder button
    Then the new folder "New folder" should be displayed in the files list
    And the user refresh the page
    Then the total number of the folder is increased one

  @B3801-240_files_AC2_TC2
  Scenario: Verify that the user receives an error message when attempting to create a folder with an existing name

    And the user clicks on the "Plus" button
    And the user clicks on the New Folder button
    And the user refresh the page
    And the user clicks on the "Plus" button
    And the user clicks on the New Folder button
    Then an error message should be displayed stating "New folder already exists"

  @B3801-240_files_AC3_TC1
  Scenario: Verify that the user can delete a selected file using the three dots menu

    And the user clicks on the three dots menu next to the file "Test1"
    And the user selects the "Delete" option
    Then the file "Test1" should no longer be displayed in the files list

  @B3801-240_files_AC4_TC1
  Scenario: Verify that the total number of files and folders is displayed under the files list table

    Then the total number of files and folders should be displayed under the files list table


  @B3801-240_files_AC4_TC2
  Scenario: Verify that the count updates correctly after uploading a new file or folder.

    Then the total number of files and folders should be displayed under the files list table
    And the user clicks on the "Plus" button
    And the user selects a valid file "C:\Users\C\OneDrive\Desktop\Test2.txt" to upload
    Then the total number of the file is increased one

  @B3801-240_files_AC4_TC3
  Scenario: Verify that the count updates correctly after deleting a file or folder.

    Then the total number of files and folders should be displayed under the files list table
    And the user clicks on the three dots menu next to the file "Test2"
    And the user selects the "Delete" option
    And the user refresh the page
    Then the total number of the file is decreased one

  @B3801-240_files_AC4_TC4
  Scenario: Verify that the count updates correctly after deleting folder.

    Then the total number of files and folders should be displayed under the files list table
    And the user clicks on the three dots menu next to the folder "New folder"
    And the user selects the "Delete" option
    And the user refresh the page
    Then the total number of the folder is decreased one