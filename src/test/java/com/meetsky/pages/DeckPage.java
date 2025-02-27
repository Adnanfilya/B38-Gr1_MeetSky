package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class DeckPage extends BasePage {


    @FindBy(xpath = "//span[@title='Add board']")
    public WebElement addBoard;

    @FindBy(css = "[class='app-navigation__list']")
    public WebElement allboa;

    @FindBy(css = "[placeholder='Board name']")
    public WebElement boardNameSpace;

    @FindBy(xpath = "(//input[@type='submit'])[last()]")
    public WebElement submitButton;

    @FindBy(xpath = "//ul[@class='app-navigation-entry__children']//li")
    public List<WebElement> allBoards;

    public void getBoardName(String boardName) {
        String locate = "//ul[@class='app-navigation-entry__children']//li//span[@title='" + boardName + "']";
        WebElement element = Driver.getDriver().findElement(By.xpath(locate));
        element.click();
    }

    @FindBy(xpath = "//button[@aria-controls='menu-tsepg']")
    public WebElement listThreeDot;

    @FindBy(xpath = "//span[.='Delete list']")
    public WebElement deleteList;


    public void setDeleteList(String listName) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

            // Liste ekleme alanı görünüyorsa, listeyi ekle
            if (isElementPresent(addListSpace)) {
                addListSpace.sendKeys(listName + Keys.ENTER);
                System.out.println("✅ List added: " + listName);
            }
            // Liste alanı görünmüyorsa, var olan listeyi sil
            else {
                if (isElementPresent(listThreeDot)) {
                    listThreeDot.click(); // Liste üç nokta menüsüne tıkla
                    deleteList.click();   // Silme işlemini yap
                    System.out.println("🗑️ List deleted: " + listName);

                    // Liste silindikten sonra tekrar ekleme alanının gelmesini bekle
                    wait.until(ExpectedConditions.visibilityOf(addListSpace));

                    // Listeyi tekrar ekle
                    addListSpace.sendKeys(listName + Keys.ENTER);
                    System.out.println("🔄 List re-added: " + listName);
                } else {
                    System.out.println("❌ List options (three dots) not found.");
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error during list handling: " + e.getMessage());
        }
    }

    // ✅ Elementin olup olmadığını kontrol eden yardımcı metod
    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @FindBy(css = "[class='action-item action-item--single app-navigation-toggle undefined undefined has-tooltip']")
    public WebElement getopenNavigationButton;

    public WebElement getBoardElement(String dynamicBoardName) {
        String dynamicXPath = "//span[@title='" + dynamicBoardName + "']";
        return Driver.getDriver().findElement(By.xpath(dynamicXPath));
    }


    @FindBy(xpath = "//input[@placeholder='List name']")
    public WebElement addListSpace;

    @FindBy(xpath = "//div[@class=\"board-wrapper\"]")
    public WebElement allListSpaces;

    @FindBy(css = "[class='smooth-dnd-draggable-wrapper']")
    public List<WebElement> draggableList;

    @FindBy(css = "[class='board-title']")
    public WebElement boardHeader;

    @FindBy(css = "[class=\"stack__header\"]")
    public WebElement stackHeader;

    public boolean isListPresent() {
        List<WebElement> lists = Driver.getDriver().findElements(By.xpath("//div[@class='stack__header']//h3"));
        return !lists.isEmpty();
    }


    public WebElement getListNameElement(String listName) {
        String locator = "//div[@class='stack__header']//h3[contains(text(), '" + listName + "')]";
        return Driver.getDriver().findElement(By.xpath(locator));
    }


    @FindBy(xpath = "//span[.='Delete list']")
    public WebElement deleteListSpace;


    @FindBy(css = " [class=\"animated smooth-dnd-draggable-wrapper\"]")
    public List<WebElement> listAndCards;

    public WebElement getNameOfCard(String name) {
        return Driver.getDriver().findElement(By.xpath("//h2[.='" + name + "']"));
    }

    @FindBy(xpath = "//h2[.='selim']")
    public WebElement nameOfCard;

    public void setListName(String listName) {
        String xpath = "//h3[contains(text(), '" + listName + "')]";
        WebElement listElement = Driver.getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//h3")
    public WebElement listNameOfCard;

    @FindBy(xpath = "//div[@class='stack__header']//button[@icon=\"icon-add\"]")
    public WebElement addCardButton;

    @FindBy(xpath = "//button[contains(@class, 'action-button') and .//span[text()='Add card']]")
    public List<WebElement> addCardButtons;

    @FindBy(css = "[id='new-stack-input-main']")
    public WebElement cardNameInput;

    @FindBy(css = "[class='card-upper']")
    public List<WebElement> cards;

    @FindBy(css = "[class=\"stack__header\"]")
    public List<WebElement> lists;


    @FindBy(xpath = "//div[@class='card-menu']")
    public WebElement cardMenu;


    @FindBy(xpath = "//span[.='Assign to me']")
    public WebElement assignToMeButton;

    @FindBy(css = "[class=\"card card__editable\"]")
    public List<WebElement> editCards;

    @FindBy(css = "[class=\"avatardiv popovermenu-wrapper has-tooltip\"]")
    public WebElement assignAvatar;


    @FindBy(xpath = "//span[.='Delete board']")
    public WebElement deleteBoardButton;

    @FindBy(xpath = "//button[@aria-controls='menu-kuohn']")
    public WebElement menUButton;

    //button[@aria-controls='menu-kuohn']

    public void setAddBoard(String boardName) {
        String Locator = "//span[@title='" + boardName + "']";
        WebElement element = Driver.getDriver().findElement(By.xpath(Locator));
        element.click();
    }

    //span[@title='selim']/../following-sibling::div//div//button
    public void delete() {
        String locator = "//button[@aria-label=\'Actions\']";
        WebElement menuDot = Driver.getDriver().findElement(By.xpath(locator));
        menuDot.click();
        WebElement deleter = Driver.getDriver().findElement(By.xpath("//span[.='Delete board']"));
        deleter.click();
        WebElement d = Driver.getDriver().findElement(By.xpath("//button[.='Delete']"));
        d.click();
        Driver.getDriver().navigate().refresh();

    }

    // Locating all lists (stacks)
    @FindBy(xpath = "//div[@class='stack']")
    private List<WebElement> getListAndCards;

    // Method to find a list by its name
    public WebElement getListByName(String listName) {
        for (WebElement list : lists) {
            if (list.getText().contains(listName)) {
                return list;
            }
        }
        return null; // Return null if the list is not found
    }


}


