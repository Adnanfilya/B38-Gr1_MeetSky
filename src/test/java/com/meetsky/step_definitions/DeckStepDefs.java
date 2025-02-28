package com.meetsky.step_definitions;

import com.meetsky.pages.DeckPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class DeckStepDefs {
    DeckPage deckpage = new DeckPage();

    @When("the user clicks on the open navigation button")
    public void theUserClicksOnTheOpenNavigationButton() {
        deckpage.getopenNavigationButton.click();
    }

    @And("the user clicks on the add board button")
    public void theUserClicksOnTheAddBoardButton() {
        deckpage.addBoard.click();
    }

    @And("the user enters {string} as the board name")
    public void theUserEntersAsTheBoardName(String boardName) {
        BrowserUtils.waitFor(2);
        try {
            boolean isBoardFound = false;
            if (deckpage.allboa.getText().contains(boardName)) {
                isBoardFound = true;
                return;
            } else {
                deckpage.boardNameSpace.sendKeys(boardName);
                deckpage.submitButton.click();
            }
        } catch (Exception e) {


        }
    }

    @Then("the user should see {string} under all boards")
    public void theUserShouldSeeUnderAllBoards(String boardName) {
        BrowserUtils.waitFor(5);
        boolean isBoardFound = false;

        for (WebElement board : deckpage.allBoards) {
            if (board.getText().equals(boardName)) {
                isBoardFound = true;
                break;
            }
        }

        Assert.assertTrue(boardName, isBoardFound);
    }


    @When("the user is on an existing board named {string}")
    public void theUserIsOnAnExistingBoardNamed(String boardName) {
        deckpage.getBoardName(boardName);
    }


    @And("the user clicks on the add list button and enters {string} as the list name")
    public void theUserClicksOnTheAddListButtonAndEntersAsTheListName(String listName) {
        try {
            if (isElementPresent(deckpage.addListSpace)) {
                deckpage.addListSpace.sendKeys(listName + Keys.ENTER);
                System.out.println("✅ List added: " + listName);
            } else {
                System.out.println("⚠️ Add List Space is not visible, skipping this step.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error while adding list: " + e.getMessage());
        }
    }

    private boolean isElementPresent(WebElement addListSpace) {
        try {
            return addListSpace.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    @Then("the user should see {string} under the board")
    public void theUserShouldSeeUnderThe(String listName) {

        BrowserUtils.waitFor(5);
        String xpath = "//h3[contains(text(), '" + listName + "')]";
        WebElement listElement = Driver.getDriver().findElement(By.xpath(xpath));
        BrowserUtils.verifyElementDisplayed(listElement);

    }

    @When("the user clicks on the add card button under the list")
    public void theUserClicksOnTheAddCardButtonUnder() {
        deckpage.addCardButton.click();


    }

    @And("the user enters {string} as the card name")
    public void theUserEntersAsTheCardName(String cardName) {
        deckpage.cardNameInput.sendKeys(cardName);
        deckpage.submitButton.click();
    }

    @Then("the user should see card under the  list")
    public void theUserShouldSeeUnderTheList() {
        BrowserUtils.waitFor(10);
        BrowserUtils.verifyElementDisplayed(deckpage.nameOfCard);
    }

    @When("the user clicks on the three dots menu of card")
    public void theUserClicksOnTheThreeDotsMenuOf() {
        deckpage.cardMenu.click();
    }

    @And("the user selects the Assign to me option")
    public void theUserSelectsTheOption() {
        deckpage.assignToMeButton.click();
    }

    @Then("the user should see himself or herself assigned to related card")
    public void theUserShouldSeeAssignedTo() {
        BrowserUtils.waitFor(5);
        BrowserUtils.verifyElementDisplayed(deckpage.assignAvatar);
        deckpage.delete();


    }


}
