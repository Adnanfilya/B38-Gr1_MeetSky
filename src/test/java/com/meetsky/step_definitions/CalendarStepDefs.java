package com.meetsky.step_definitions;

import com.meetsky.pages.BasePage;
import com.meetsky.pages.CalendarPage;
import com.meetsky.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import org.openqa.selenium.WebElement;

public class CalendarStepDefs extends BasePage {

    CalendarPage calendarPage = new CalendarPage();

    @When("the user navigates to {string} module")
    public void theUserNavigatesToModule(String moduleName) {

        calendarPage.navigateTo(moduleName);

    }

    @When("user clicks date selector button")
    public void userClicksDateSelectorButton() {

        try {
            WebElement date = calendarPage.dateSelector;
            date.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Then("user should see the daily calendar view")
    public void userShouldSeeTheDailyCalendarView() {

        try {
            WebElement dailyViewElement = calendarPage.dailyView;
            BrowserUtils.waitForVisibility(dailyViewElement, 5);
            Assert.assertTrue(dailyViewElement.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
