package com.project6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import io.cucumber.java.en.Then;

import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class UserMonitoring {
    
    private WebDriver driver; 
    private WebDriverWait wait;

    public UserMonitoring (WebDriver driver) {
        this.driver = driver; 
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//p[contains(@class,'MuiTypography-root')])[10]")
    private WebElement userMonitoringMenu;

    @FindBy(xpath = "//button[contains(.,'Tambah')]")
    private WebElement addMonitorButton;
    
    @FindBy(xpath = "//input[@name='fullname']")
    private WebElement fieldFullName;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//input[@placeholder='Pilih Unit']")
    private WebElement fieldUnit;

    @FindBy(xpath = "//button[normalize-space()='Tambah']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement fieldSearchMonitoring;

    @FindBy(xpath = "(//h6[contains(@class,'MuiTypography-root MuiTypography-h6')])[1]")
    private WebElement txtSearchName2;

    @FindBy(xpath =" (//button[contains(@class,'MuiButtonBase-root ')])[6]")
    private WebElement searchMonitoringButtton;

    @FindBy(xpath = "//button[contains(text(), 'Reset')]")
    private WebElement resetButtonMonitoring;

    // ===== ACTIONS =====

    public void clickUserMonitoringMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(userMonitoringMenu)).click();
    }

    public void clickaddMonitorButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addMonitorButton)).click();
    }   

    public void inputFullName(String name) {
        wait.until(ExpectedConditions.visibilityOf(fieldFullName)).sendKeys(name);
    }

    public void inputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(fieldEmail)).sendKeys(email);
    }

    public void inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(fieldPassword)).sendKeys(password);
    }

    //dropdown unit
    public void selectUnit(String unit) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldUnit)).click();

        fieldUnit.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        fieldUnit.sendKeys(unit);

        By option = By.xpath("//li[contains(text(),'" + unit + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String getTxtSearchName() {
        return wait.until(ExpectedConditions.visibilityOf(txtSearchName)).getText();
    }

    public void clickSearchButton() {
        WebElement searchBtn = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }

    @FindBy(xpath = "(//h6[contains(@class,'MuiTypography-root MuiTypography-h6')])[1]")
    private WebElement txtSearchName;
    public String getFirstResultName() {
        return wait.until(ExpectedConditions.visibilityOf(txtSearchName)).getText();
    }

    public void clickResetButtonMonitoring() {
        wait.until(ExpectedConditions.elementToBeClickable(resetButtonMonitoring)).click();   
    }

    public void inputSearchNameMonitoring(String searchQuery) {
        fieldSearchMonitoring.clear();
        fieldSearchMonitoring.sendKeys(searchQuery);
    }

      public String getSearchFieldValueMonitoring() {
    // Langsung ambil nilainya tanpa nunggu attribute value jadi ""
    return fieldSearchMonitoring.getAttribute("value");
    }



}

