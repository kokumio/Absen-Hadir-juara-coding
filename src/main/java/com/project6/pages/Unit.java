package com.project6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Unit {
    public Unit (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath ="//p[normalize-space()='Unit']")
    private WebElement unitMenu; 

    @FindBy (xpath= "//button[normalize-space()='Tambahkan']")
    private WebElement addUnitButton; //button[@type='submit']")

    @FindBy (xpath = "//input[@name='locationType']")
    private WebElement fieldLocationType;

    @FindBy(xpath = "//input[@id='calendar']") 
    private WebElement fieldCalendar;

    @FindBy(xpath = "//input[@id='unitLeave']")
    private WebElement fieldUnitLeave;

    @FindBy(xpath = "//input[@id='ot_reason']")
    private WebElement fieldOTReason;

    @FindBy (xpath="//input[@id='max_day_ot']")
    private WebElement fieldMaxDayOT;

    @FindBy (xpath="//div[@id='ot_upload']")
    private WebElement fieldOTUpload;

    @FindBy (xpath="//button[normalize-space()='Tambah']")
    private WebElement submitAddUnitButton;

    public void clickUnitMenu() {
        unitMenu.click();
    }

    public void clickAddUnitButton() {
        addUnitButton.click();
    }

    public void setFieldLocationType(String locationType) {
        fieldLocationType.sendKeys(locationType);
    }

    public void setFieldCalendar(String calendar) {
        fieldCalendar.sendKeys(calendar);
    }

    public void setFieldUnitLeave(String unitLeave) {
        fieldUnitLeave.sendKeys(unitLeave);
    }

    public void setFieldOTReason(String otReason) {
        fieldOTReason.sendKeys(otReason);
    }


    public void setFieldMaxDayOT(String maxDayOT) {
        fieldMaxDayOT.sendKeys(maxDayOT);
    }

    public void setFieldOTUpload(String otUpload) {
        fieldOTUpload.sendKeys(otUpload);
    }

    public void clickSubmitAddUnitButton() {
        submitAddUnitButton.click();
    }


    // Contoh method gabungan: Masuk ke halaman edit user
    public void addUnit() {

        unitMenu.click();
        addUnitButton.click();
        fieldLocationType.sendKeys("Office");
        fieldCalendar.sendKeys("2024");
        fieldUnitLeave.sendKeys("12");
        fieldOTReason.sendKeys("Work from home");
        fieldMaxDayOT.sendKeys("5");
        fieldOTUpload.sendKeys("Yes");
        submitAddUnitButton.click();
    }
}

