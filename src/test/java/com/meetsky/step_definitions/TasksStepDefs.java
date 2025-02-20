package com.meetsky.step_definitions;

import com.meetsky.pages.TasksPage;
import com.meetsky.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

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

    @When("user writes {string} of the list and clicks submit button")
    public void user_writes_a_of_the_list_and_clicks_submit_button(String listName) {
       // BrowserUtils.sleep(2);
        tasksPage.listName.sendKeys(listName + Keys.ENTER);
        //BrowserUtils.sleep(5);
//        System.out.println("tasksPage.submitButton.isDisplayed() = " + tasksPage.submitButton.isDisplayed());
//        System.out.println("tasksPage.submitButton.isEnabled() = " + tasksPage.submitButton.isEnabled());
//        BrowserUtils.waitForVisibility(tasksPage.submitButton,5);
//        System.out.println("tasksPage.submitButton.isDisplayed() = " + tasksPage.submitButton.isDisplayed());
//        System.out.println("tasksPage.submitButton.isEnabled() = " + tasksPage.submitButton.isEnabled());

    }

    @Then("user should see the {string} list under Tasks label")
    public void user_should_see_the_list_under_tasks_label(String string) {
////div[@class='draggable-container']/li[@calendar-id='tasks']
    }


}
