package com.meetsky.step_definitions;

import com.meetsky.pages.BasePage;
import com.meetsky.pages.CalendarPage;

import io.cucumber.java.en.*;


import java.util.List;

public class CalendarStepDefs extends BasePage {

    CalendarPage calendarPage = new CalendarPage();

    @Given("the user navigates to {string} module")
    public void theUserNavigatesToModule(String moduleName) {

        calendarPage.navigateTo(moduleName);

    }

    @When("user clicks date selector button")
    public void userClicksDateSelectorButton() {

        calendarPage.clickView();

    }


    @Then("user should see the views below")
    public void userShouldSeeTheViewsBelow(List<String> dateList) {

        calendarPage.displayDateView(dateList);

    }
}
