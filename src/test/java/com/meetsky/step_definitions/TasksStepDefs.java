package com.meetsky.step_definitions;

import com.meetsky.pages.TasksPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TasksStepDefs {

    TasksPage tasksPage = new TasksPage();

    @And("the user navigates to {string} module")
    public void the_user_navigates_to_module(String moduleName) {
        tasksPage.navigateTo(moduleName);
    }

    @When("user clicks Add list")
    public void user_clicks_add_list() {
        BrowserUtils.sleep(2);
        tasksPage.addList.click();

    }

    @When("user writes {string} for the list and clicks submit button")
    public void user_writes_the_list_and_clicks_submit_button(String listName) {
        tasksPage.listName.sendKeys(listName + Keys.ENTER);

    }

    @Then("user should see the {string} list under Tasks label")
    public void user_should_see_the_list_under_tasks_label(String string) {
//div[@class='draggable-container']/li[@calendar-id='tasks']

    }


}
