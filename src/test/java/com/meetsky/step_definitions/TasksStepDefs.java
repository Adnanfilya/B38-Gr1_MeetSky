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
        tasksPage.listName.sendKeys(listName);
        tasksPage.submitButton.click();

    }

    @Then("user should see the {string} list under Tasks label")
    public void user_should_see_the_list_under_tasks_label(String expectedStr) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains(expectedStr.toLowerCase()));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedStr.toLowerCase()));

    }


}
