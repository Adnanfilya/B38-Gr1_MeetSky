package com.meetsky.pages;

import com.meetsky.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * Navigates to given module page on the App
     *
     * @param moduleName String
     */
    public void navigateTo(String moduleName) {
        moduleName = moduleName.substring(0, 1).toUpperCase() + moduleName.substring(1).toLowerCase();
        String locator = "//a[@aria-label='" + moduleName + "']";
        WebElement element = Driver.getDriver().findElement(By.xpath(locator));
        element.click();
    }

}
