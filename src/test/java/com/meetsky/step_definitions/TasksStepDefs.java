package com.meetsky.step_definitions;

import com.meetsky.pages.TasksPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TasksStepDefs {

    TasksPage tasksPage = new TasksPage();

    @When("user clicks Add list")
    public void user_clicks_add_list() {
        tasksPage.addList.click();
        BrowserUtils.waitFor(2);
    }

    @When("user writes {string} for the list and clicks submit button")
    public void user_writes_the_list_and_clicks_submit_button(String listName) {
        tasksPage.newListName.sendKeys(listName);
        tasksPage.submitButton.click();
    }

    @Then("user should see the {string} list under Tasks label")
    public void user_should_see_the_list_under_tasks_label(String expectedStr) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains(expectedStr.toLowerCase()));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedStr.toLowerCase()));
    }

    @When("user clicks {string} list")
    public void user_clicks_list(String list) {
        tasksPage.selectList(list);
    }

    @When("user writes {string} for the task and presses Enter button")
    public void user_writes_for_the_task_and_presses_enter_button(String taskName) {
        tasksPage.addTask.sendKeys(taskName + Keys.ENTER);
    }

    @Then("user should see the {string} as a task")
    public void user_should_see_it_as_a_task(String expectedTask) {
        String actualTask = tasksPage.taskControl(expectedTask).getText();
        Assert.assertEquals(expectedTask, actualTask);
    }

    @When("user clicks checkbox near {string} task")
    public void user_clicks_checkbox_near_task(String checkboxName) {
        tasksPage.checkbox(checkboxName);
    }

    @Then("user should see {string} in completed tasks")
    public void user_should_see_in_completed_tasks(String expectedTask) {
        tasksPage.completedTasks.click();
        String actualTask = tasksPage.taskControl(expectedTask).getText();
        Assert.assertEquals(expectedTask, actualTask);
    }

    @When("user clicks the star icon of {string} task")
    public void user_clicks_the_star_icon_of_task(String importantTask) {
        tasksPage.starIcon(importantTask);
    }

    @Then("user should see {string} in important tasks")
    public void user_should_see_in_important_tasks(String expectedTask) {
        tasksPage.importantTasks.click();
        Assert.assertEquals(expectedTask, tasksPage.taskControl(expectedTask).getText());
    }

    @When("user clicks the Current tab")
    public void user_clicks_the_current_tab() {
        tasksPage.unCompletedTasks.click();
    }

    @Then("user should see the number of all uncompleted tasks")
    public void user_should_see_the_number_of_all_uncompleted_tasks() {
        String actualTask = tasksPage.numberOfUnCompletedTasks.getText();
        String expectedTask = tasksPage.numberOfAllTasks.getText();
        Assert.assertEquals(expectedTask, actualTask);

    }
}
