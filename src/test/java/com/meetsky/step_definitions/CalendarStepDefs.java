package com.meetsky.step_definitions;

import com.meetsky.pages.BasePage;
import com.meetsky.pages.CalendarPage;

import io.cucumber.java.en.*;


public class CalendarStepDefs extends BasePage {

    CalendarPage calendarPage = new CalendarPage();

    @Given("the user goes to {string} module")
    public void theUserNavigatesToModule(String moduleName) {

        calendarPage.navigateTo(moduleName);

    }

    @When("user clicks date selector button")
    public void userClicksDateSelectorButton() {

        calendarPage.clickView();

    }


    @Then("user should see the {string} {string} and {string} calendar view")
    public void userShouldSeeTheCalendarView(String dayView, String weekView, String monthView) {

        calendarPage.compareDates(dayView, weekView, monthView)
                .checkEachView();

    }

    @When("user opens new event")
    public void userOpensNewEvent() {

        calendarPage.clickEvent();

    }

    @Then("user should see the {string} under the Calendar Module")
    public void userShouldSeeTheEventUnderTheCalendarModule(String eventNameFromFeatureFile) {

        calendarPage.openNewEvent(eventNameFromFeatureFile);

    }

    @And("user should see the {string} on Monthly Calendar View")
    public void userShouldSeeTheEventOnMonthlyCalendarView(String eventNameFromFeatureFile) {

        calendarPage.checkEventOnMonthlyCalendarView(eventNameFromFeatureFile);

    }
}
