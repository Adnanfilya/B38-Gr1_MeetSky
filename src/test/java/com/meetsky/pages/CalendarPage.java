package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// page_url = about:blank
public class CalendarPage extends BasePage {

    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}