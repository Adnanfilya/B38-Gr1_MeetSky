package com.meetsky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilesPage extends BasePage{


    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAllCheckBox;

    @FindBy(xpath = "//input[contains(@id,'select-files')]")
    public List<WebElement> allCheckBoxes;

    @FindBy(xpath = "(//div[@id='headerName-container']//span)[1]")
    public WebElement totalNumberOfFoldersFiles;

    @FindBy(xpath = "//tr[@data-type='dir']")
    public List<WebElement> folders;

    @FindBy(xpath = "//tr[@data-type='file']")
    public List<WebElement> files;

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement fileAddIcon;

    @FindBy(xpath = "//label[@for='file_upload_start']")
    public WebElement fileUploadStart;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement fileUploadButton;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> fileNamesList;

    @FindBy(xpath = "(//span[@class='displayname'])[2]")
    public WebElement fileNewFolder;

    @FindBy(xpath = "//input[@id='view11-input-folder']/following-sibling::input")
    public WebElement fileNewFolderButton;

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public  List<WebElement> fileMoreButtons;

    @FindBy(xpath = "//a[@class='menuitem action action-delete permanent']")
    public WebElement fileDeleteButton;

    @FindBy(xpath = "//span[starts-with(@class, 'dirinfo')]")
    public WebElement folderInfoText;

    @FindBy(xpath = "//span[starts-with(@class, 'fileinfo')]")
    public WebElement fileInfoText;

    @FindBy(xpath = "//div[@class='tooltip-inner']")
    public WebElement folderAlreadyExistsMessage;

    /**
     * Checks if a given file or folder is present in the list
     *
     * @param fileNameList the list of file or folder elements
     * @param fileName     the name of the file or folder to check for
     * @return true if the file or folder is found, false otherwise
     *
     * Iterates through the list of elements, prints each name, and returns true
     * if a match is found. The loop stops after the first match.
     */
    public boolean isFileOnTheList (List<WebElement> fileNameList, String fileName){
        boolean isFileOnTheList = false;
        for (WebElement name : fileNameList) {
            System.out.println(name.getText());
            if (name.getText().contains(fileName)) {
                isFileOnTheList = true;
                break;
            }
        }
        return isFileOnTheList;
    }
    /**
     * Clicks the three-dot button of a given folder or file
     *
     * @param fileName the name of the file or folder to locate and click the three-dot button for
     *
     * Iterates through the list of file names, finds the matching file/folder,
     * and clicks the corresponding three-dot button. The loop breaks after the first match.
     */
    public void clickThreeDotsOfGivenFolderOrFileName(String fileName){

        for (int i = 0; i < fileNamesList.size(); i++) {
            if (fileNamesList.get(i).getText().contains(fileName)) {
                fileMoreButtons.get(i).click();
                break;
            }
        }
    }


}
