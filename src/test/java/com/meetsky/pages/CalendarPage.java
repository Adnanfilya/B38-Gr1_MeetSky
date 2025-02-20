package com.meetsky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page_url = about:blank
public class CalendarPage extends BasePage {

    @FindBy(xpath = "//button[@aria-label='Actions']")
    public WebElement dateSelector;

    @FindBy(xpath = "//span[@class='action-button__text'][text()='Day']")
    public WebElement dailyView;
}