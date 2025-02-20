package com.meetsky.pages;

import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarPage extends BasePage {


    @FindBy(xpath = "//span[@class='material-design-icon view-day-icon']/..")
    public WebElement dateSelector;

    /**
     * Taken dates from feature file as list of String, then compared with actual element texts.
     *
     * @param dates List of Dates
     */
    public void displayDateView(List<String> dates) {

        for (String date : dates) {
            try {
                String dateViewLocator = "//span[@class='action-button__text'][text()='" + date + "']";
                WebElement dateViewElement = Driver.getDriver().findElement(By.xpath(dateViewLocator));
                BrowserUtils.waitForVisibility(dateViewElement, 5);
                Assert.assertEquals("Date view failed", date, dateViewElement.getText());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to display date view for: " + date);
            }
        }
    }

    /**
     * Basic click function to open the views
     */
    public void clickView() {

        try {
            dateSelector.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Click failed.");
        }
    }

}