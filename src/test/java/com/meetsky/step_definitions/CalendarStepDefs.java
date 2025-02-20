package com.meetsky.step_definitions;

import com.meetsky.pages.BasePage;
import com.meetsky.pages.CalendarPage;
import com.meetsky.pages.LoginPage;
import io.cucumber.java.en.*;

public class CalendarStepDefs extends BasePage {

    CalendarPage calendarPage = new CalendarPage();

    @And("the user navigates to {string} module")
    public void theUserNavigatesToModule(String moduleName) {

        calendarPage.navigateTo(moduleName);

    }
}
