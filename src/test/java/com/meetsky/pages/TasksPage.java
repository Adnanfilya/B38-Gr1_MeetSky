package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TasksPage extends BasePage {

    @FindBy(xpath = "//span[@title='Add List…']")
    public WebElement addList;

    @FindBy(xpath = "//input[@id='newListInput']")
    public WebElement newListName;

    @FindBy(xpath = "(//input[@class='action icon-checkmark'])[last()]")
    public WebElement submitButton;

    public void selectList(String listName) {
        String locator = "//span[@title='" + listName + "']";
        WebElement element = Driver.getDriver().findElement(By.xpath(locator));
        element.click();
    }

    @FindBy(xpath = "//input[@class='transparent reactive']")
    public WebElement addTask;


    public WebElement taskControl(String task) {
        String locator = "//span[.='" + task + "']";
        WebElement element = Driver.getDriver().findElement(By.xpath(locator));
        return element;
    }

    public void checkbox(String checkbox){
        String locator= "//span[.='" + checkbox + "']/../../preceding-sibling::div[1]";
        WebElement element =  Driver.getDriver().findElement(By.xpath(locator));
        element.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Load all completed tasks.')]")
    public WebElement completedTasks;

    @FindBy(xpath = "//span[@title='Current']")
    public WebElement unCompletedTasks;

    @FindBy(xpath = "//li[@id='collection_current']//div[@class='app-navigation-entry__counter']")
    public WebElement numberOfUnCompletedTasks;

    @FindBy(xpath = "//li[@id='collection_all']//div[@class='app-navigation-entry__counter']")
    public WebElement numberOfAllTasks;

    public void starIcon(String icon){
        String locator= "//span[.='" + icon + "']/../../following-sibling::div[1]//span[@class='material-design-icon star-icon'])[1]";
        WebElement element =  Driver.getDriver().findElement(By.xpath(locator));
        element.click();
    }

    @FindBy(xpath = "//span[@title='Important']")
    public WebElement importantTasks;





}
