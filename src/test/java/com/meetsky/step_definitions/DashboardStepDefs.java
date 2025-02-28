package com.meetsky.step_definitions;
import com.meetsky.pages.DashboardPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class DashboardStepDefs {

    DashboardPage dashboardPage = new DashboardPage();



    @When ("user should see all modules")
    public void user_should_see_all_modules(){
        Assert.assertTrue(dashboardPage.appmenu.isDisplayed());


        for (WebElement modull   : dashboardPage.allModls) {
            String modulename = modull.getAttribute("data-id");
            System.out.println(modulename + "  module is displayed");
        }BrowserUtils.sleep(2);
        System.out.println("All modules are displayed");
    }




    @Then("the user should see their {string} correctly")
    public void the_user_should_see_their_correctly(String username){
        dashboardPage.profileIcon.click();
        BrowserUtils.sleep(3);
        if (dashboardPage.usernameWiew.getText().equals(username)) {
            System.out.println("Username is displayed correctly!");
        } else {
            throw new AssertionError("Expected username, but got '" + dashboardPage.usernameWiew.getText() + "'");
        }}











    @When("User click on the Customize button")
    public void userClickOnTheCustomizeButton() {
        dashboardPage.customizeBtn.click();
        BrowserUtils.sleep(5);}

    @Then("USer should see a list of available Widgets")
    public void u_ser_should_see_a_list_of_available_widgets()  {
        Assert.assertTrue(dashboardPage.widgtPanel.isDisplayed());}

    @When("User unselect a Widget from the list")
    public void userUnselectAWidgetFromTheList()  {

        for (WebElement widgets : dashboardPage.widgets2){
            BrowserUtils.sleep(2);
            widgets.click();}
        System.out.println("Widget list unselected");}

    @And("user select a all Widget from the list")
    public void userSelectAAllWidgetFromTheList()  {
        for (WebElement wid1 : dashboardPage.widgets1) {
            if(!wid1.isSelected()){
                BrowserUtils.sleep(1);
                wid1.click();}}
        System.out.println("All widgets selected");}



    @Then("User selected Widget should be displayed on the Dashboard")
    public void userSelectedWidgetShouldBeDisplayedOnTheDashboard() {
        Assert.assertTrue(dashboardPage.widgtPanel.isDisplayed());

        for (WebElement wid1 : dashboardPage.dashWid1){
            System.out.println(wid1.getText()+" widget is displayed!");}

        for (WebElement wid2 : dashboardPage.dashWid2){
            System.out.println(wid2.getText()+" widget is displayed!");}}






    @When("User clicks on the  Set Status button")
    public void userClicksOnTheSetStatusButton() {
        dashboardPage.statusBtn.click();
        BrowserUtils.sleep(2);
        Assert.assertTrue(dashboardPage.setStatusModal.isDisplayed());
        System.out.println("Set status modal is displayed");
    }

    @And("User selects the {string} status")
    public void userSelectsTheStatus(String modal)  {

        WebElement statusOption =Driver.getDriver().findElement(By.xpath("//label[contains(@for,'user-status-online-status-" + modal.toLowerCase() + "')]"));
        BrowserUtils.waitFor(7);
        statusOption.click();
        BrowserUtils.waitFor(3);
        dashboardPage.setStatusBtn.click();
        System.out.println("User selects the "+modal+" status");

    }


    @Then("The status should be updated to {string}")
    public void theStatusShouldBeUpdatedTo(String status) {
        WebElement statusbtn = Driver.getDriver().findElement(By.xpath("/html/body/div[3]/div/ul/div[1]"));
        Assert.assertEquals("Expected status is ", status, statusbtn.getText());

        System.out.println("Status should be updated to " + statusbtn.getText());
    }
}










