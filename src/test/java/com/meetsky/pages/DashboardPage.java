package com.meetsky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(xpath="//*[@id=\"appmenu\"]")
    public WebElement appmenu;

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li")
    public List<WebElement> allModls;

    @FindBy(xpath="//*[@id=\"expand\"]/div/img")
    public WebElement profileIcon;

    @FindBy(xpath ="//*[@id=\"expanddiv\"]/ul/li[1]/div/a[1]/div[1]/div[1]")
    public WebElement usernameWiew;

    @FindBy(xpath = "//*[@id=\"app-dashboard\"]/div[2]/a")
    public WebElement customizeBtn;

    @FindBy(xpath = "/html/body/div[3]/div/div[1]/div")
    public WebElement widgtPanel;

    @FindBy(xpath = "//label[contains(@class,'draggable')]")
    public List<WebElement> widgets2;

    @FindBy(xpath = "//label[@data-v-af526754]")
    public List<WebElement> widgets1;

    @FindBy(xpath = "//*[@id=\"app-dashboard\"]/ul/div")
    public List<WebElement> dashWid1;

    @FindBy(xpath = "//h2[contains(@class,'icon')]")
    public List<WebElement> dashWid2;

    @FindBy(xpath = "//*[@id=\"status-status\"]/li/div/button")
    public WebElement statusBtn;

    @FindBy(xpath = "//*[@id=\"body-user\"]/div[7]/div[2]/div/div")
    public WebElement setStatusModal;

    @FindBy(xpath = "/html/body/div[7]/div[2]/div/div/div[7]/button[2]")
    public WebElement setStatusBtn;




}
