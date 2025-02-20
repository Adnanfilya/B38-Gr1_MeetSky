package com.meetsky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TasksPage extends BasePage {

    @FindBy(xpath = "//span[@title='Add List…']")
    public WebElement addList;

    @FindBy(xpath = "//input[@id='newListInput']")
    public WebElement listName;


    @FindBy(xpath = "(//input[@title='Save'])[2]")
    public WebElement submitButton;
}
