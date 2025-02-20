package com.meetsky.pages;

import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarPage extends BasePage {


    @FindBy(xpath = "//button[@aria-label='Actions']")
    public WebElement dateSelector;


    public void displayDateView(List<String> dates) {
        for (String date : dates) {

            String dateViewLocator = "//span[@class='action-button__text'][text()='" + date + "']";

            WebElement dateViewElement = Driver.getDriver().findElement(By.xpath(dateViewLocator));

            BrowserUtils.waitForVisibility(dateViewElement, 5);

            // Elementin metnini al ve doğrula
            Assert.assertEquals("Date view failed", date, dateViewElement.getText());
        }
    }

    public void clickView() {
        try {
            dateSelector.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Click failed.");
        }
    }

}