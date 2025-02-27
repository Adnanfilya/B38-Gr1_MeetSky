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

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class DeckStepDefs {
    DeckPage deckpage = new DeckPage();

    @And("the user navigates to {string} module")
    public void the_user_navigates_to_module(String moduleName) {
        deckpage.navigateTo(moduleName);
    }


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
        //BrowserUtils.waitFor(2);
        boolean boardExists = false;

        for (WebElement board : deckpage.allBoards) {
            if (board.getText().equalsIgnoreCase(boardName)) {
                boardExists = true;
                break;
            }
        }

        if (boardExists) {
            System.out.println("Board already exists, skipping creation: " + boardName);
            return;
        }
        deckpage.boardNameSpace.sendKeys(boardName);
        deckpage.submitButton.click();
    }

    @Then("the user should see {string} under all boards")
    public void theUserShouldSeeUnderAllBoards(String boardName) {
        // Wait for the page to fully load before performing the check
        // BrowserUtils.waitFor(2);

        // Retrieve a list of all board names currently displayed on the page
        List<String> boardNames = BrowserUtils.getElementsText(deckpage.allBoards);

        // Verify that the expected board name exists in the list
        Assert.assertTrue("Board is NOT found: " + boardName, boardNames.contains(boardName));

        // Print confirmation message if the board is found
        System.out.println("✅ Board is successfully found: " + boardName);

    }

    @Given("the user is on an existing board named {string}")
    public void theUserIsOnAnExistingBoardNamed(String boardName) {
          BrowserUtils.waitFor(2); // Wait for the page to load completely

        // Get all available boards from the page
        List<WebElement> boards = deckpage.allBoards;

        // A flag to check if the board exists
        boolean isBoardFound = false;

        // Iterate through the board list to find the matching one
        for (WebElement board : boards) {
            if (board.getText().trim().equalsIgnoreCase(boardName)) {
                board.click(); // Click the board once found
                isBoardFound = true;
                System.out.println("✅ Successfully navigated to board: " + boardName);
                break; // Exit the loop after clicking
            }
        }

        // If no matching board was found, fail the test
        Assert.assertTrue("Board not found: " + boardName, isBoardFound);

    }

    @And("the user clicks on the add list button")
    public void theUserClicksOnTheAddListButton() {
        try {
            // Liste dolu değilse, 'add list' alanı görünür
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOf(deckpage.addListSpace));

            // Eğer öğe görünürse, tıklıyoruz
            deckpage.addListSpace.click();
            System.out.println("Add List button clicked");

        } catch (TimeoutException e) {
            // Eğer öğe görünür değilse, işlemi atlıyoruz ve devam ediyoruz
            System.out.println("Add List button not visible, skipping to the next step.");
        }
    }

    @And("the user enters {string} as the list name")
    public void theUserEntersAsTheListName(String listName) {
        try {
            // Eğer addListSpace görünürse, listeyi eklemeye çalış
            // WebDriverWait wait = new WebDriverWait(Driver.getDriver() , Duration.ofSeconds(1));
            //wait.until(ExpectedConditions.visibilityOf(deckpage.addListSpace));
            BrowserUtils.waitForVisibility(deckpage.addListSpace, 1);
            // Listeyi ekle
            deckpage.addListSpace.sendKeys(listName);
            deckpage.submitButton.click(); // Listeyi göndermek için submit butonuna tıklıyoruz
            System.out.println("List added: " + listName);

        } catch (TimeoutException e) {
            // Eğer addListSpace öğesi görünmüyorsa, liste zaten dolu demektir
            System.out.println("List is already full, skipping list addition.");
        }
    }

    @Then("the user should see {string} under the {string} board")
    public void theUserShouldSeeUnderTheBoard(String listName, String boardName) {
        // Wait for the page to load completely
        BrowserUtils.waitFor(2);

// Step 1: Verify that the board title matches the expected board name
        String actualBoardName = deckpage.boardHeader.getText().trim();
        Assert.assertEquals("Board name does not match!", boardName, actualBoardName);

// Step 2: Iterate through all draggable lists to find the list with the specified name
        boolean isListFoundAndVisible = false;
        for (WebElement list : deckpage.draggableList) {
            // Get the list name and compare
            String listText = list.getText().trim();
            if (listText.equalsIgnoreCase(listName)) {
                // If the list is found and is visible, set the flag to true and exit the loop
                if (list.isDisplayed()) {
                    isListFoundAndVisible = true;
                }
                break;
            }
        }


    }


    @When("the user clicks on the add card button under {string}")
    public void theUserClicksOnTheAddCardButtonUnder(String listName) {
        // Belirli bir liste adı altında kartları kontrol et
        boolean isCardPresent = deckpage.cards.stream()
                .anyMatch(card -> card.getText().trim().equalsIgnoreCase(listName));

        if (isCardPresent) {
            System.out.println("❌ '" + listName + "' kartı zaten mevcut, yeni kart oluşturulmayacak.");
        } else {
            try {
                // "Add Card" butonuna tıkla
                if (deckpage.addCardButton != null) {
                    // JavaScript ile tıklama işlemi
                    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                    js.executeScript("arguments[0].click();", deckpage.addCardButton);
                    System.out.println("✅ Yeni '" + listName + "' kartı oluşturuldu.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("❌ 'Add Card' butonu bulunamadı.");
            }
        }
    }


    @And("the user enters {string} as the card name")
    public void theUserEntersAsTheCardName(String cardName) {

        // Kartın zaten mevcut olup olmadığını kontrol edin
        boolean cardExists = false;
        for (WebElement card : deckpage.draggableList) {
            if (card.getText().equalsIgnoreCase(cardName)) {
                cardExists = true;
                break;
            }
        }

        if (cardExists) {
            System.out.println("Card already exists: " + cardName);
            return;
        } else {
            try {
                // 'Add Card' butonuna tıklayın
                deckpage.addCardButton.click();

                // 'cardNameSpace' alanının görünür olmasını bekleyin
                BrowserUtils.waitForVisibility(deckpage.cardNameInput, 10);

                // Kart adını girin ve Enter tuşuna basın
                deckpage.cardNameInput.sendKeys(cardName + Keys.ENTER);

                System.out.println("Card added: " + cardName);
            } catch (NoSuchElementException e) {
                System.out.println("Required element not found: " + e.getMessage());
            } catch (TimeoutException e) {
                System.out.println("Operation timed out: " + e.getMessage());
            }
        }
    }

    @Then("the user should see {string} under the {string} list")
    public void theUserShouldSeeUnderTheList(String cardName, String listName) {
        boolean isCardFound = false;

        // Listeleri kontrol et
        for (WebElement list : deckpage.lists) {
            if (list.getText().trim().equalsIgnoreCase(listName)) {
                // Kartları kontrol et
                for (WebElement card : deckpage.cards) {
                    if (card.getText().trim().equalsIgnoreCase(cardName)) {
                        isCardFound = true;
                        break;  // Kart bulunduğunda döngüden çık
                    }
                }
                break;  // Liste bulunduğunda döngüden çık
            }
        }

        // Kartın bulunduğunu doğrula
        Assert.assertTrue("Card '" + cardName + "' not found under list: " + listName, isCardFound);
    }



    // Adım tanımlayıcı sınıfında
    @When("the user clicks on the three dots menu of {string}")
    public void theUserClicksOnTheThreeDotsMenuOf(String cardName) {
        // 'cards' listesindeki her bir kartı kontrol et
        for (int i = 0; i < deckpage.cards.size(); i++) {
            WebElement card = deckpage.cards.get(i);
            // Kartın başlık metnini al
            String cardText = card.getText().trim();

            // Eğer kartın başlık metni 'cardName' ile eşleşiyorsa
            if (cardText.equalsIgnoreCase(cardName)) {
                // İlgili üç nokta menüsünü al
                WebElement cardMenu = deckpage.cardMenus.get(i);
                // Üç nokta menüsüne tıkla
                cardMenu.click();
                break; // İşlem tamamlandığında döngüden çık
            }
        }
    }


    @And("the user selects the {string} option")
    public void theUserSelectsTheOption(String assign) {

        //deckpage.assignToMeButton.click();

        try {
            // Wait for the 'Assign to me' button to be present and visible
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            WebElement assignButton = wait.until(ExpectedConditions.visibilityOf(deckpage.assignToMeButton));

            // Retrieve the button's text
            String buttonText = assignButton.getText().trim();

            // Check if the button text indicates the card is unassigned
            if (buttonText.equalsIgnoreCase("Assign to me")) {
                // Click the button to assign the card
                assignButton.click();
            } else {
                // The card is already assigned; no action needed
                System.out.println("The card is already assigned.");
            }
        } catch (NoSuchElementException e) {
            // Handle the case where the button is not found in the DOM
            System.out.println("'Assign to me' button not found: " + e.getMessage());
        } catch (TimeoutException e) {
            // Handle the case where the button is not visible within the wait time
            System.out.println("'Assign to me' button not visible after waiting: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

    }


    @Then("the user should see {string} assigned to {string}")
    public void theUserShouldSeeAssignedTo(String name, String cardName) {
        Assert.assertTrue("Avatar görünür değil", deckpage.assignAvatar.isDisplayed());

    }
}


