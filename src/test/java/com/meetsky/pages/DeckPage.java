package com.meetsky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeckPage extends BasePage {


    @FindBy (xpath = "//span[@title='Add board']")
    public WebElement addBoard;


    @FindBy(css = "[placeholder='Board name']")
    public WebElement boardNameSpace;

    @FindBy(xpath= "(//input[@type='submit'])[last()]")
    public WebElement submitButton;

    @FindBy(xpath = "//ul[@class='app-navigation-entry__children']//li")
    public List<WebElement> allBoards;

    @FindBy(css = "[class='action-item action-item--single app-navigation-toggle undefined undefined has-tooltip']")
    public WebElement getopenNavigationButton;


    @FindBy(id = "new-stack-input-main")
    public WebElement addListSpace;

    @FindBy(css = "[class='smooth-dnd-draggable-wrapper']")
    public List<WebElement> draggableList;

    @FindBy(css = "[class='board-title']")
    public WebElement boardHeader;

   @FindBy(css = " [class=\"animated smooth-dnd-draggable-wrapper\"]")
   public List<WebElement> listAndCards;


    @FindBy(xpath = "//h2[.='selim']")
    public WebElement nameOfCard;

    @FindBy(xpath = "//h3[@class='stack__title has-tooltip']")
    public WebElement listNameOfCard;

    @FindBy(xpath = "//div[@class=\"stack__header stack__header--add\"]//button[@icon=\"icon-add\"]")
    public WebElement addCardButton;

    @FindBy(xpath = "//button[contains(@class, 'action-button') and .//span[text()='Add card']]")
    public List<WebElement> addCardButtons;

    @FindBy(css = "[id='new-stack-input-main']")
    public WebElement cardNameInput;

    @FindBy(css = "[class='card-upper']")
    public List<WebElement> cards;

    @FindBy(css = "[class=\"stack__header\"]")
    public List<WebElement> lists;


    @FindBy(xpath= "//div[@class='card-menu']")
    public List<WebElement> cardMenus;


    @FindBy(xpath = "//span[.='Assign to me']")
    public WebElement assignToMeButton;

    @FindBy(css = "[class=\"card card__editable\"]")
    public List<WebElement> editCards;

    @FindBy(css = "[class=\"avatardiv popovermenu-wrapper has-tooltip\"]")
    public WebElement assignAvatar;


}
