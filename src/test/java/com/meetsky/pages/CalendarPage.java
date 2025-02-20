package com.meetsky.pages;

import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CalendarPage extends BasePage {


    @FindBy(xpath = "//span[contains(@class, 'material-design-icon view')]/..")
    public WebElement dateSelector;

    @FindBy(xpath = "//span[@class='action-button__text'][text()='Day']")
    public WebElement dayView;

    @FindBy(xpath = "//span[@class='action-button__text'][text()='Week']")
    public WebElement weekView;

    @FindBy(xpath = "//span[@class='action-button__text'][text()='Month']")
    public WebElement monthView;

    @FindBy(css = "button[class='button primary new-event']")
    WebElement newEventButton;

    @FindBy(css = "input[placeholder='Event title']")
    WebElement eventTitle;

    @FindBy(css = "button[class='primary']")
    WebElement saveEventButton;


    /**
     * Basic click function to open the views
     */
    public void clickView() {

        try {
            dateSelector.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("View click failed.");
        }

    }

    public void clickEvent() {
        try {
            newEventButton.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Event click failed.");
        }
    }

    /**
     * Comparing values using Maps
     *
     * @param day   from feature file
     * @param week  from feature file
     * @param month from feature file
     * @return used because of fluent interface/method chaining.
     */
    public CalendarPage compareDates(String day, String week, String month) {

        try {
            BrowserUtils.waitForVisibility(dateSelector, 2);

            Map<String, String> actualView = new LinkedHashMap<>();

            actualView.put("Day", dayView.getText());
            actualView.put("Week", weekView.getText());
            actualView.put("Month", monthView.getText());

            Map<String, String> expectedView = new LinkedHashMap<>();

            expectedView.put("Day", day);
            expectedView.put("Week", week);
            expectedView.put("Month", month);

            Assert.assertEquals(expectedView, actualView);
        } catch (TimeoutException e) {
            System.out.println("Element not visible in time: " + e.getMessage());
        }

        return this;

    }

    /**
     * Checking each button click is actually opens a new page or not with iteration.
     *
     * @return used because of method chaining.
     */
    public CalendarPage checkEachView() {

        List<WebElement> views = List.of(dayView, weekView, monthView);

        List<String> xpaths = List.of(
                "//button[@title='Previous day']",
                "//button[@title='Previous week']",
                "//button[@title='Previous month']"
        );

        for (int i = 0; i < views.size(); i++) {
            try {
                views.get(i).click();
                BrowserUtils.waitForPresenceOfElement(By.xpath(xpaths.get(i)), 10);
                Assert.assertTrue(Driver.getDriver().findElement(By.xpath(xpaths.get(i))).isDisplayed());
            } catch (NoSuchElementException | TimeoutException e) {
                e.printStackTrace();
                Assert.fail("View check failed for: " + views.get(i).getText());
            }
        }
        return this;
    }

    public void openNewEvent(String eventName) {

        try {
            eventTitle.sendKeys(eventName);

            saveEventButton.click();

//            dateSelector.click();
//
//            dayView.click();

            String calendarEventName = "//div[@class='fc-event-title fc-sticky'][text()='" + eventName + "']";

            WebElement calendarEvent = Driver.getDriver().findElement(By.xpath(calendarEventName));

            BrowserUtils.waitForVisibility(calendarEvent, 5);

            Assert.assertTrue(calendarEvent.isDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Calendar event is not displayed.");
        }

    }

    public void checkEventOnMonthlyCalendarView(String eventName) {

        BrowserUtils.waitForPageToLoad(3);

        try {
            dateSelector.click();

            BrowserUtils.waitForVisibility(monthView, 5);

            monthView.click();

            String calendarEventName = "//div[@class='fc-event-title fc-sticky'][text()='" + eventName + "']";

            WebElement calendarEvent = Driver.getDriver().findElement(By.xpath(calendarEventName));

            BrowserUtils.waitForVisibility(calendarEvent, 5);

            Assert.assertTrue(calendarEvent.isDisplayed());


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Calendar event in month is not displayed.");
        }
    }

}