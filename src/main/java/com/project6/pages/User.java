package com.project6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User {
    public User (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//p[contains(text(), 'Management')]")
    private WebElement managementMenu; //input[@id='email']

    @FindBy (xpath="//p[contains(text(),'User')]")
    private WebElement userMenu; //input[@id='password']

    @FindBy (xpath="//button[normalize-space()='Export']")
    private WebElement exportButton; //button[@type='submit']

    @FindBy (xpath="//tbody/tr[6]/td[7]/div[1]/div[1]/button[1]//*[name()='svg']")
    private WebElement titikMenu; //div[@class='alert alert-danger']

    @FindBy (xpath="//body/div[8]/div[3]/ul[1]/li[2]")
    private WebElement editMenu; //div[@class='MuiBox-root css-16

    @FindBy(xpath = "//input[@name='nik']") // Sesuaikan atribut 'name' atau 'id' dengan aslinya
    private WebElement fieldNIK;

    @FindBy (id="submit")
    private WebElement saveEditMenu; //div[@class='MuiBox-root css-16


    // Method untuk klik menu Management
    public void clickManagementMenu() {
        managementMenu.click();
    }

    // Method untuk klik menu User
    public void clickUserMenu() {
        userMenu.click();
    }

    // Method untuk klik tombol Export
    public void clickExportButton() {
        exportButton.click();
    }

    // Method untuk klik titik tiga (menu aksi di tabel)
    public void clickTitikMenu() {
        titikMenu.click();
    }

    // Method untuk klik opsi Edit
    public void clickEditMenu() {
        editMenu.click();
    }

        public void clickSaveEditMenu() {
        saveEditMenu.click();
    }

        public void clearFieldNIK() {
        fieldNIK.clear(); // atau fieldNIK.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
    }

    // Contoh method gabungan: Masuk ke halaman edit user
    public void goToEditUser() {
        managementMenu.click();
        userMenu.click();
        titikMenu.click();
        editMenu.click();
        saveEditMenu.click();
    }
}
